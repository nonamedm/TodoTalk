<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(function(){
	
	$('#form1').on('submit', function() {		   
		   if ( $('#free_title').val() == '') {
			   alert('제목을 입력하세요');
			   $('#free_title').focus();
			   return false;   // submit 이벤트를 중지
		   } 			   
		    if ( $('#free_cont').val() == '') {
			   alert('내용을 입력하세요');
			   $('#free_cont').focus();
			   return false;   // submit 이벤트를 중지
		   } 	
		   
	     return true;
	});
	
})
</script>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->

<form action="/board/free/freeUpdate" method="post"  id="form1">
<table class="table-type02">
<h2>QnA Update</h2>
 
 <tr>
 	<td>글번호: ${freeBoardVo.free_idx}</td>
 	<input type="hidden" name="free_idx" value="${freeBoardVo.free_idx}" />
 	<td>제목  <input type="text" name="free_title" id="free_title" placeholder="제목을 입력하세요(필수입력) " /></td>
 	<td>작성자: ${user_id}<input type="hidden" name="user_id" value="${user_id}"/></td>
 </tr>
 <tr>
 	<td>내용</td>
 	<td colspan="4"><textarea id="free_cont" name="free_cont" rows="30" cols="80"  placeholder="글 내용 입력하세요(필수입력) "></textarea> </td>
 </tr>
 
 
 <input type="submit" value="확인" />
 <a href="/board/free/freeList"> 목록 </a>

</table>
</form>



</body>
</html>