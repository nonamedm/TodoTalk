<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
/* 	$(function() {
		$('form').on('submit',function(){
			if ('free_title'==' ') {
				alert('제목을 입력하세요');
				return false;
			}
			
		})
		
	}) */

</script>
</head>
<body>
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
    <td><input type="text" name="free_title" /></td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><textarea name="free_cont" cols="50" rows="100"></textarea></td>
  </tr>
	<input type="submit" value="수정" />
</table>
</form>
</body>
</html>