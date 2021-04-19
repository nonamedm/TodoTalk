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
              내아이디 : ${loginId }<hr>
        <c:forEach var="list" items="${list }" varStatus="status">
        <%-- 방번호 : ${list.roomId }<br> --%>
        대화상대 : ${list.sender }<br>
        <!-- 새 메세지 몇개 -->
        새 메시지 : ${newList[status.index] } 건   
        입장 : <form action="/talk" method="POST" >
                	<input type="hidden" name="loginId" value="${loginId}" />
                	<input type="hidden" name="receiverId" value="${list.sender }" />
                	<input type="hidden" name="requireId" value="${loginId }" />
                	<input type="submit" value="대화시작"/><hr>
               	</form>
      
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>