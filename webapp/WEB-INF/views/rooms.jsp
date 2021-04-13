<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>


</head>

<body>

<div class = "container">
    <table class = "table table-striped">
        <thead>
        <tr>
            <th>번호</th>
            <th>방 이름</th>
            <th>입장버튼</th>
            <th>인원수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${ rooms }">
        	<tr>
        		<td>${room.roomId }</td>
        		<td>${room.name }</td>
        		<td>
					<a href="/rooms/${room.roomId }"> 입장</a>
				</td>
				<td>${people }</td>
        	</tr>
        </c:forEach>
        </tbody>
    </table>
    <a class = "btn btn-primary pull-right" href = "/new">새로 만들기</a>
    <a class = "btn btn-primary pull-right" href = "javascript:location.reload()">새로 고침</a>
</div>


</body>
</html>