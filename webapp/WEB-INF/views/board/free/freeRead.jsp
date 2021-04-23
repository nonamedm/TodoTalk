<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@include file="/WEB-INF/views/layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->


<table class="table-type01">
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
	 	<td colspan="3" class="h250">${freeBoardVo.free_cont}</td>
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

</table ><br>
<!-- 댓글 목록 -->
<table class="table-type03">
	<tr>
		<td colspan="2">댓글 내용</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
	  <c:forEach var="list" items="${repList}" >
		<tr>
		 <td><c:out value="${list.free_re_cont}" /></td>
     	 <td><a href="/board/free/repDelete?free_idx=${list.free_idx}&free_re_idx=${list.free_re_idx}"> 삭제 </a></td>
     	 <!-- <td>대댓</td> -->
	     <td><c:out value="${user_id}" /></td>
	     <td><c:out value="${list.free_re_regdate}" /></td>
		</tr>	
      </c:forEach> 
</table><br>


<!-- 댓글쓰기 -->
<form action="/board/free/repWrite"  method="POST">
<table class="table-type01">
	<tr>
 		<td>댓글쓰기</td>
 		<td>글번호</td>
	 	<input type="hidden" name="free_idx" value="${map.free_idx}"/>
 		<td>
			작성자: ${user_id}<input type="hidden" name="user_id"  value="${map.user_id}"/>
	 		<textarea name="free_re_cont" rows="5" cols="15"></textarea> 
 		</td>
 		<div class="form-group">
              <div class="col-md-12 text-right">
 				<td><input type="submit" value="댓글쓰기"  class="btn btn-primary btn-lg" /></td>
 			   </div>
 		</div>
	</tr>
</table>
</form>	



</body>
</html>





