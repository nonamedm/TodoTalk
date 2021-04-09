<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
<form action="/write">
<table>
 <h2>글쓰기</h2>

  <tr>
    <td>글제목</td>
    <td><input type="text" name="free_title" /></td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><input type="text" name="free_cont" /></td>
  </tr>
</table>
	<input type="submit" value="확인" />
	<!-- 확인 누르면 뜨는 주소 http://localhost:9090/write?title=&cont= -->
</form>
</body>
</html>