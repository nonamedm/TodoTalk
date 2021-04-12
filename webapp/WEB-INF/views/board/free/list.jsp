<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style></style>

</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->

 <a href="/writeForm"  method="post">글쓰기</a>
 
 <h2>자게 목록</h2>
 	<c:forEach var="freeBoard" items="${ list }">
     <ul>
       <li>글 번호 : ${ freeBoard.free_idx }</li>
       <li>글 제목 :<a href="/read?idx=${ freeBoard.free_idx}">${ freeBoard.free_title }</a> </li>
       <li>작성자 : ${ freeBoard.user_id }</li>
       <li>작성일 : ${ freeBoard.free_regdate }</li>
       <li>조회수 : ${ freeBoard.free_readcount }</li>
     </ul>
    </c:forEach>
 
</body>
</html>