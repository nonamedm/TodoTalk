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
			 $('form').on('submit',function(e) {
				var user_id = document.getElementById('user_id');
				var user_pwd = document.getElementById('user_pwd');
				$.ajax({
					url:'/Check_id',
					data: $('#user_id').val(),
					type:'POST',
					success:function(data){
						console.log(data.html);
						$("#id_check_result").html(data.html);
					},
						
					error:{
						return false;
					}
				
					
					
				});
				
				
				if($('id_check_result').chaildren().attr() == 'red' ||  user_id.value==''){
					alert();
					user_id.focus();
					return false;
				}else{}
				if(user_pwd.value==''){
					alert('다시 입력하세요');
					user_pwd.focus();
					return false;
				}else{}
				
				
				
			 }) 
   });
</script>
</head>
<body>


   <h1>로그인</h1>
	   <form  action="/Login" method="POST">
		   	<table>
		   		<tr>
		   			<th>아이디</th>
			   		<td><input type="text" name="user_id" id="user_id" value="11" /><span id=id_check_result></span></td>
		   		</tr>
		   		<tr>
		   			<th>비번</th>
			   		<td><input type="password" name="user_pwd" id="user_pwd" value="11" /></td>
		   		</tr>
		   		<tr>
			   		<td>
			   		<input type="submit" value="확인"/>
			   		<a href="javascript:history.back();" >취소</a>
			   		<a href="/User_MakeForm">회원가입</a>
			   		<a href="/Find" >아이디 /비번찾기</a>
			   		</td>
		   		</tr>
		   	</table>
	   </form>
	   
	   
	</body>
</html>













