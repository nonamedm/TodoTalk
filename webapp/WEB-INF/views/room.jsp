<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

<script>
	$(function(){
			//소켓 On명령 + onopen, onmessage, onclose 액션 연결
			var sock = new SockJS("http://localhost:9090/chat/");
			sock.onopen = onOpen;							
			sock.onmessage = onMessage;
			sock.onclose = onClose;
			console.dir(sock);
			
			var nickname='test용';					//접속하는 사람 id 받아서 쓸 예정
													//로그인 안되어있으면 동작X
			var msg;
			var roomId = '${room.roomId}';			//채팅 시작 할 상대방 아이디
			
			
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
				var data = e.data;
				console.dir(e);
				var chatroom =	 $('#chatroom');
				var html = '<br>'+data;
				
				chatroom.append(html);
			}
			function onClose () {
				sock.send(JSON.stringify({
					roomId : roomId,
					type : 'LEAVE',
					sender : nickname
				}));
			}
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
<div id = "chatroom" style = "width:300px; height: 300px; border:1px solid; background-color : gray"></div>
<input type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>
<button class = "btn btn-primary" id = "send">전송</button>
</body>
</html>