<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<head>
    <title>채팅 서비스</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/css/import.css">
</head>
<body>
<div class = "talbe-wrap">
    <table class = "table-type02">
        <div class="chat-header"><h4>${loginId } 님의 대화 목록</h4></div> <hr>
        <tbody>
        <c:forEach var="list" items="${list }" varStatus="status">
        <%-- 방번호 : ${list.roomId }<br> --%>
        <tr><th>대화상대 : ${list.sender }</th>
        <!-- 새 메세지 몇개 -->
        <th>새 메시지 : ${newList[status.index] } 건<th></tr>   
        <tr><th colspan="2"><form action="/talk" method="POST" >
                	<input type="hidden" name="loginId" value="${loginId}" />
                	<input type="hidden" name="receiverId" value="${list.sender }" />
                	<input type="hidden" name="requireId" value="${loginId }" />
                	<input type="submit" value="대화시작"/>
               	</form></th>
         </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>