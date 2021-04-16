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
              ${loginId }
        <c:forEach var="list" items="${list }">
        ${list.roomId }<br>
        ${list.sender }<br>
        
        <!-- 다시 form 으로 지정해서, login id, receiver id, require id 구분해서 날리기 -->
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>