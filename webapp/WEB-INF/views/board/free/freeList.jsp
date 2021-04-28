<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
</script>

</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
                
                
<div class="sub-section-wrap review-sttus">
    <div class="">
        <section class="wp100">
			<div class="section-tit"> 
			 <h1>자게 목록</h1>
			 </div>
 <table>
  <div class="btn-box">
     <li><a href="/board/free/freeWriteForm" > 글쓰기 </a></li>
  </div>
  
<div class="table-wrap">
	<table class="table-type03">
      <colgroup>
          <col class="wp8">
          <col class="wauto">
          <col class="wp10">
          <col class="wp10">
          <col class="wp8">
      </colgroup>
            <thead>
                 <tr>
				    <th>글번호</th>
				    <th>글제목</th>
				    <th>작성자</th>
				    <th>작성일</th>
				    <th>조회수</th>
				</tr>
            </thead>
                <tbody>
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
        </tbody>
    </table>
 <!-- 페이징 영역   -->
<!-- <div class="btn-paging btn-pageing-bg"> -->
   <%@include file="/WEB-INF/views/board/Freepaging.jsp" %>
<!-- </div>    -->	
</div>
   
 </table>
</div>
</div>
</body>
</html>