<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
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
			
	});
</script>

</head>
<body>
<!-- <input type="text" id="nickname" class="form-inline" placeholder="닉네임을 입력해주세요" required autofocus>
<button class = "btn btn-primary" id = "name">확인</button> -->
<button class = "btn btn-primary" id = "talklist">대화방목록</button>
<button class = "btn btn-primary" id = "close">나가기</button><br>
<label for="roomId" class="label label-default">방 번호</label>
<label id="roomId" class="form-inline">${ room.roomId }</label>
<br>
<label for="roomName" class="label label-default">방 이름</label>
<label id="roomName" class="form-inline">${ room.name }</label>
로그인유저 : ${loginId} 대화상대방 : ${receiverId }
<div id = "chatroom"></div>
<input type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>
<button class = "btn btn-primary" id = "send">전송</button>
</body>
</html>