<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/css/import.css" />
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
	<script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/script.js"></script>
    <script src="/js/TweenMax.min.js"></script>
    <script src="/js/common.js"></script>
	
<style>
	#notice_message {text-align: center; background-color: white;}
	#my_message {text-align: right;}
	#my_message_span {text-align: right; width:300px; background-color: yellow; padding : 7px;}
	#your_message {text-align: left;}
	#your_message_span {text-align: left; width:300px; background-color: yellow; padding : 7px;}
	#chatroom {width : 400px; height : 500px; border:1px solid; background-color: lavender; overflow : scroll;}
	
</style>
<script>
//layout 없는 빈 페이지를 import 하면??헤더랑 채팅방이랑??
		
	$(function(){
			//전역변수 설정하고
			var nickname='${loginId}';		//접속한 사람 id
													//로그인 안되어있으면 동작X
			var msg;
			var roomId = '${room.roomId}';			//방번호
			var loadText = '';
			//채팅창에 기존값  먼저 불러오기
			$.ajax({
				url : '/loadTalk',
				type : 'POST',
				data : { roomId : roomId },
				success : function(result){			///result.셋오브젝트이름.변수
					//console.dir(result.loadMessage);
					for (var i = 0; i < result.loadMessage.length; i++) {
						var sender = result.loadMessage[i].sender;
						var message = result.loadMessage[i].message;
						
						if(sender=='${loginId}'){
							loadText += '<br><div id="my_message"><span id="my_message_span">'+(message.substring(message.indexOf(':')+1))+'</span></div>';
						} else {
							loadText += '<br><div id="your_message"><span id="your_message_span">'+(message.substring(message.indexOf(':')+1))+'</span></div>'
						}
					}
					var chatroom =	 $('#chatroom');
					chatroom.append(loadText);
					chatroom.scrollTop($('#chatroom')[0].scrollHeight);
				},
				error : function(xhr){
					alert(xhr.status + " : "+xhr.statusText);
				}
			});
			//소켓 On명령 + onopen, onmessage, onclose 액션 연결
			var sock = new SockJS("http://localhost:9090/chat/");
			
			sock.onopen = onOpen;					//소켓 오픈 시 function 연결		
			sock.onmessage = onMessage;				//메세지 도착 시 function 연결
			sock.onclose = onClose;					//종료 시 function 연결
			console.dir(sock);
			
			function onOpen () {
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'ENTER',
					sender : nickname
				}));
			}
			
			function onClose () {
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'LEAVE',
					sender : nickname
				}));
			}
			$('#send').on('click',function(){
				send();
			});
			$('#close').on('click',function(){
				onClose();
				window.close();
			});
			$('#talklist').on('click',function(){
				$(location).attr('href','/rooms?loginId=${param.loginId}');
			});
			//인풋에서 Enter치면 send 메소드 실행
			$("#message").keydown(function(key){
				if(key.keyCode == 13){
					send();
				}
			});
			//창닫기 감지 -> onClose명령 수행
			$(window).bind("beforeunload", function (e){
				onClose();
			});
			function send(){
				msg = $('#message').val();
				//alert(msg+' : 전송');		//확인함
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'CHAT',
					sender : nickname,
					receiver : '${receiverId}',
					message : msg
				}));
				
				$('#message').val('');
			}
			function onMessage(e) {
				console.dir(e);
				//파싱해서 sender, text 나누기
				var data = e.data.replaceAll('"','');
				var sender = data.substring(0,data.indexOf(':'));
				//alert(sender);
				var message = data.substring(data.indexOf(':')+1);
				//alert(message);
				
				var chatroom =	 $('#chatroom');
				if(sender==''){
					var	html = '<br><div id="notice_message">'+message+'</div>';
				} else if(sender=='${param.loginId}'){
					var html = '<br><div id="my_message"><span id="my_message_span">'+message+'</span></div>';
				} else {
					var	html = '<br><div id="your_message"><span id="your_message_span">'+message+'</span></div>';
				}
				if(html!='<br>'){
					chatroom.append(html);
					chatroom.scrollTop($('#chatroom')[0].scrollHeight);	//새글 내려올 때 마다 스크롤 아래로
					
				}
				
			}
			$("#getText").keyup(function(){
				
				$.ajax({
					url : '/srcLangText',
					type : 'POST',
					data : {
						srcLangText : $("#getText").val()
					},
					success : function(data){
						console.log(data.resultData2);
						var srcLangText = data.resultData2;
						$("#srcLangText").val(srcLangText);
						var srcOption = $(".languages-box option").val();
					},
					error : function(xhr){
						alert(xhr.status + ", " + xhr.statusText);
					}
				});
			});
			
	});
	//여기서 부터 번역기능 스크립트
	//::드래그한 값 가져오기
	function selectText(){
		var selectionText = "";
		if(document.getSelection){
			selectionText = document.getSelection();
		}else if(document.selection){
			selectionText = document.selection.createRange().text;
		}
		return selectionText;
	}
	
	//커서의 왼쪽이 누르고땟을때 
	document.onmouseup = function(event){
		//드래그한 값이 빈값이면 실행 중지
		if(selectText() == ""){
			$("#translationTxt").hide();
			return false;
		}else{
			var x = event.pageX;
			var y = event.pageY;
			$("#translationTxt").show();
			$("#translationTxt").css({"position":"absolute", "left": x+"px", "top": y+-40+"px"});
		}
	}
	
	function translationTxt(){
		$("#translationTxt").hide();
		$("#translation-wrap").show();
		$("#getText").val(selectText());
		$("#getText").focus();
		
		var getText = $("#getText").val();
		if(getText != ""){
			srcLangText();
		}
	}
	
	
	//번역글 보내기
	function translationSend(){
		var langOption1 = $("#srcLangText").val();
		var langOption2 = $(".languages-box2").val();
		
		if(langOption1 == langOption2){
			alert("번역할 언어를 변경해주십시오.");
			$(".languages-box2").focus();
			return false;
		}
		
		$.ajax({
			url : '/translatorText',
			type : 'POST',
			data : {
				srcLanguage : $("#srcLangText").val(),
				getText  : $("#getText").val(),
				tarLanguage : $(".languages-box2 option:selected").val()
			},
			success : function(data){
				var tarLanguage = data.resultData;
				$("#tarText").html(tarLanguage);
			},
			error : function(xhr){
				alert(xhr.status + ", " + xhr.statusText);
			}
		})
	}
	
	//자동언어감지 스크립트
	function srcLangText(){
		$.ajax({
			url : '/srcLangText',
			type : 'POST',
			data : {
				srcLangText : $("#getText").val()
			},
			success : function(data){
				console.log(data.resultData2);
				var srcLangText = data.resultData2;
				$("#srcLangText").val(srcLangText);
				var srcOption = $(".languages-box option").val();
			},
			error : function(xhr){
				alert(xhr.status + ", " + xhr.statusText);
			}
		});
	}//여기까지가 번역기능 스크립트 끝
</script>

</head>
<body>
<%@include file="popup/translation.jsp"%>
<!-- 드래그 했을때 뜨는 번역하기 버튼 html -->
<div id="translationTxt" class="translation-txt">
   	<a href="javascript:translationTxt()" title="번역" id="btnTranslation">번역하기</a>
</div>

<!-- <input type="text" id="nickname" class="form-inline" placeholder="닉네임을 입력해주세요" required autofocus>
<button class = "btn btn-primary" id = "name">확인</button> -->
<button class = "btn btn-primary" id = "talklist">대화방목록</button>
<button class = "btn btn-primary" id = "close">나가기</button><br>
<%-- <label for="roomId" class="label label-default">방 번호</label>
<label id="roomId" class="form-inline">${ room.roomId }</label>
<br>
<label for="roomName" class="label label-default">방 이름</label>
<label id="roomName" class="form-inline">${ room.name }</label> --%>
로그인유저 : ${loginId} 대화상대방 : ${receiverId } <img src="/img/main2.jpg" style="float:right; width:500px; height:150px;" />
<div id = "chatroom"></div>
<input type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>
<button class = "btn btn-primary" id = "send">전송</button>

		
</body>
</html>