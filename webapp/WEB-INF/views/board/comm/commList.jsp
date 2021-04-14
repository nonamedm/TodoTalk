<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@include file="/WEB-INF/views/layout/header.jsp"%>  --%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>

</style>

</head>
<body>
<table>
<%--     <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작--> --%>

 <a href="/board/comm/WriteForm"  method="post">글쓰기</a>
 
 <h2>소통 커뮤 목록</h2>
     <tr>
     	<td>글번호</td>
     	<td>글제목</td>
     	<td>작성자</td>
     	<td>작성일</td>
     	<td>조회수</td>
     </tr>

  	<c:forEach var="cList" items="${List}">
  	    <td>${ cList.comm_idx}</td>
     	<td><a href="/board/comm/commRead?comm_idx=${cList.comm_idx }">${ cList.comm_title}</a></td>
     	<td>${ cList.user_id}</td>
     	<td>${ cList.comm_regdate}</td>
     	<td>${ cList.comm_readcount}</td>
    </c:forEach>
    
</table>
</body>
</html>