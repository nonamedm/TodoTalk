<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@include file="layout/header.jsp"%>
    <div class="sub-main-wrap">
    	<%@include file="layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="layout/allSearchHeader.jsp"%>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<style>
	#notice_message {text-align: center; background-color: white;}
	#my_message {text-align: right;}
	#your_message {text-align: left;}
	
</style>
<script>
	$(function(){
			//전역변수 설정하고
			var nickname='${login.user_id}';		//접속한 사람 id
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
						
						if(sender=='${login.user_id}'){
							loadText += '<br><div id="my_message">'+(message.substring(message.indexOf(':')+1))+'</div>';
						} else {
							loadText += '<br><div id="your_message">'+(message.substring(message.indexOf(':')+1))+'</div>'
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
			sock.onopen = onOpen;							
			sock.onmessage = onMessage;
			sock.onclose = onClose;
			console.dir(sock);
			
			
			$('#send').on('click',function(){
				send();
			});
			$('#close').on('click',function(){
				onClose();
				window.history.back();
			});
			function send(){
				msg = $('#message').val();
				//alert(msg+' : 전송');		//확인함
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'CHAT',
					sender : nickname,
					message : msg
				}));
				$('#message').val('');
				
			}
			function onOpen () {
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'ENTER',
					sender : nickname
				}));
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
				} else if(sender=='${login.user_id}'){
					var html = '<br><div id="my_message">'+message+'</div>';
				} else {
					var	html = '<br><div id="your_message">'+message+'</div>';
				}
				if(html!='<br>'){
				chatroom.append(html);
				chatroom.scrollTop($('#chatroom')[0].scrollHeight);	//새글 내려올 때 마다 스크롤 아래로
				}
				
			}
			function onClose () {
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'LEAVE',
					sender : nickname
				}));
			}
			//인풋에서 Enter치면 send 메소드 실행
			$("#message").keydown(function(key){
				if(key.keyCode == 13){
					send();
				}
			});
	});
</script>

</head>
<body>
<!-- <input type="text" id="nickname" class="form-inline" placeholder="닉네임을 입력해주세요" required autofocus>
<button class = "btn btn-primary" id = "name">확인</button> -->
<button class = "btn btn-primary" id = "close">나가기</button><br>
<label for="roomId" class="label label-default">방 번호</label>
<label id="roomId" class="form-inline">${ room.roomId }</label>
<br>
<label for="roomName" class="label label-default">방 이름</label>
<label id="roomName" class="form-inline">${ room.name }</label>
로그인유저 : ${ login.user_id }
<div id = "chatroom" style = "width:300px; height: 300px; border:1px solid; background-color : gray; overflow:scroll"></div>
<input type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>
<button class = "btn btn-primary" id = "send">전송</button>
</body>
</html>