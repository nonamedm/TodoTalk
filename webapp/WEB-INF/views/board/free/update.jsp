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
 $(function() {
		$('form').on('submit',function(){
			if ($('#free_title').val()==' ') {
				alert('제목을 입력하세요');
				 $('#free_title').focus();
				return false;
			}
			
		})
		
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



 <form action="/update" method="post">
<table>
 <h2>글수정</h2>
 	<tr>
		<td>글번호</td>
		<td>${ upBoard.free_idx}</td>
		<td><input type="hidden" name="free_idx" value="${ upBoard.free_idx}" /></td>
 	<tr>
		<td>작성자</td>
		<td>${upBoard.user_id }</td>
	</tr>
  <tr>
    <td>글제목</td>
    <td><input type="text" name="free_title" id="free_title"/></td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><textarea name="free_cont" id="free_title" cols="100" rows="50"></textarea></td>
  </tr>
	<input type="submit" value="수정" />
</table>
</form>
</body>
</html>