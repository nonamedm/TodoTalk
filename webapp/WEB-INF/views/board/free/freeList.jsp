<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
table,td {border:2px solid DarkOrchid;  border-collapse:collapse; }
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
 
 <h1>자게 목록</h1>
 <table>
  <a href="/board/free/freeWriteForm"> 글쓰기 </a>
     <tr>
        <th>글번호</th>
        <th>글제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>

   <c:forEach var="list" items="${getFreeList}">
   	<tr>
   		<td>${list.free_idx}</td>
   		<td>
   			<a href="/board/free/freeRead?free_idx=${list.free_idx}">
   			${list.free_title}
   			</a>
   		</td>
   		<td>${list.user_id}</td>
   		<td>${list.free_regdate}</td>
   		<td>${list.free_readcount}</td>
   	</tr>
   </c:forEach>
   
   <!-- 페이징 영역   -->
    <tr>
     <td colspan="6">
       <%@include file="/WEB-INF/views/board/Freepaging.jsp" %>
     </td>
   </tr>	
 </table>
</body>
</html>