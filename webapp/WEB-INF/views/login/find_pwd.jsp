<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script	 src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
   $(function() {
			
   });
</script>
</head>
<body>


   <h1>비밀번호 찾기</h1>
	   <form  action="/Find_PwdLoding" method="POST">
		   	<table>
		   		<tr>
		   			<td>아이디를  입력하세요</td>
		   			<td><input type="text" name="user_id" id="user_id"/></td>
		   		</tr>
		   	
		   		<tr>
			   		<td>
			   		<a href="javascript:history.back();" >취소</a>
			   		</td>
		   		</tr>
		   	</table>
	   </form>
	   
	   
	</body>
</html>













