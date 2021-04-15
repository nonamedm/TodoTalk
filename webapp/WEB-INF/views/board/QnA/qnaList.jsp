<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
table,td {border:2px solid DarkOrchid; 
 	   border-collapse:collapse; 
}
 th,td {padding:10px;}
</style>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->


<table>
 <caption><h2>QnA List</h2></caption>
 
	 <a href="/board/QnA/qnaWriteForm"> 글쓰기 </a>
	 <a href="/#"> 홈으로 </a>
	 <tr>
	 	<td>글번호</td>
	 	<td>제  목</td>
	 	<td>작성자</td>
	 	<td>작성일</td>
	 	<td>조회수</td>
	 </tr>
	 
	<c:forEach items="${list}" var="list">
	 <tr>
	 	<td>${list.qna_idx}</td>
	 	<td><a href="/board/QnA/qnaRead?qna_idx=${list.qna_idx}">${list.qna_title }</a></td>
	 	<td>${list.user_id }</td>
	 	<td>${list.qna_regdate }</td>
	 	<td>${list.qna_readcount }</td>
	 </tr>
	 
	
	</c:forEach>
</table>


</body>
</html>