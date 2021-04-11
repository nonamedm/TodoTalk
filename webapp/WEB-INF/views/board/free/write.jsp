<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
<form action="/write"  method="post">
<table>
 <h2>글쓰기</h2>

  <tr>
    <td>글제목</td>
    <td><input type="text" name="free_title" /></td>
  </tr>
  <tr>
    <td>작성자</td>
    <td>${ board.user_id }</td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><textarea name="free_cont" cols="50" rows="100"></textarea></td>
  </tr>
	<input type="submit" value="확인" />
</table>
</form>
</body>
</html>