<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
</head>
<body>
<div class = "container">
    <table class = "table table-striped">
        <tbody>
              내아이디 : ${loginId }<br>
        <c:forEach var="list" items="${list }">
        방번호 : ${list.roomId }<br>
        대화상대 : ${list.sender }<br>
        입장 : <form action="/talk" method="POST" >
                	<input type="hidden" name="loginId" value="${loginId}" />
                	<input type="hidden" name="receiverId" value="${list.sender }" />
                	<input type="hidden" name="requireId" value="${loginId }" />
                	<input type="submit" value="대화시작"/>
               	</form>
      
        <!-- 다시 form 으로 지정해서, login id, receiver id, require id 구분해서 날리기 -->
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>