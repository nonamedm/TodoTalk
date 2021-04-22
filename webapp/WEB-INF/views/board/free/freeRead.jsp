<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
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


<table>
  <h2>read</h2>
  	<tr>
	 <a href="/board/free/freeList"> 목록 </a>
	 <a href="/board/free/delete?free_idx=${map.free_idx}"> 삭제 </a>
	 <a href="/board/free/freeUpdateForm?free_idx=${map.free_idx}"> 수정 </a>
	 <a href="/board/free/freeWriteForm"> 글쓰기 </a>
	</tr>
	 <tr>
	 	<td>글번호</td>
	 	<td>${map.free_idx }</td>
	 	<td>작성자</td>
	 	<td>${freeBoardVo.user_id}</td>

	 </tr>
 	 <tr>
	 	<td>작성일</td>
	 	<td>${freeBoardVo.free_regdate}</td>
	 	<td>조회수</td>
	 	<td>${freeBoardVo.free_readcount}</td>
	 </tr> 
	 <tr>
	 	<td>제  목</td>
	 	<td  colspan="3" >${freeBoardVo.free_title}</td>
	 </tr>
	 <tr>	
	 	<td>글 내용</td>
	 	<td colspan="3" >${freeBoardVo.free_cont}</td>
	</tr>
 
<!--  파일 목록 -->
 	<tr>
	    <td colspan="1">파일</td> 
          <td colspan="3"> 
			<c:forEach var="file" items="${ filesList }" >
	          <a href=" <c:out value="${ file.file_name}" />" > 
		          ★파일번호: <c:out value="${ file.file_idx}" /><br>
		          ★파일이름: <c:out value="${ file.file_name}" /><br>
	          </a>  
      		 </c:forEach> 
          </td>
	</tr>

</table>
</body>
</html>