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


   <h1>로그인</h1>
	   <form  action="Find_IdLoding" method="POST">
		   	<table>
		   		<tr>
		   			<td>이메일을 입력하세요</td>
		   			<td><input type="text" name="user_mail" id="user_mail"/></td>
		   		</tr>
		   		<tr>
			   		<td>
			   		<a href="javascript:history.back();" >취소</a>
			   		<a href="/Find_Id">아이디 찾기</a>
			   		<a href="Find_Pwd" >비번찾기</a>
			   		</td>
		   		</tr>
		   	</table>
	   </form>
	   
	   
	</body>
</html>













