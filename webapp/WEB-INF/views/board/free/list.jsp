<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style></style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script></script>
</head>
<body>
 <a href="/writeForm">글쓰기</a>
 
 <h2>자게 목록</h2>
 	<c:forEach var="freeBoard" items="${ list }">
     <ul>
       <li>글 번호 : ${ freeBoard.free_idx }</li>
       <li>글 제목 :<a href="/read?idx=${ freeBoard.free_idx}">${ freeBoard.free_title }</a> </li>
       <%-- <li>글 제목 : ${ freeBoard.free_title }</li> --%>
       <li>작성자 : ${ freeBoard.user_id }</li>
       <li>작성일 : ${ freeBoard.free_regdate }</li>
       <li>조회수 : ${ freeBoard.free_readcount }</li>
     </ul>
    </c:forEach>
 
</body>
</html>