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
			/*  $('form').on('submit',function(e) {
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
			 })  */
   });
</script>
</head>
<body>
   <h1>회원 정보</h1>
	   <form  action="/User_UpDate" method="POST">
		   	<table>
		   		<tr>
			   		<td><input type="hidden" name="user_idx" id="user_idx" value="${ login.user_idx }"  /></td>
		   		</tr>
		   		<tr>
		   			<th>이름</th>
			   		<td><input type="text" name="user_name" id="user_name" value="${ login.user_name }"  /></td>
		   		</tr>
		   		<tr>
		   			<th>전화 번호 </th>
			   		<td><input type="text" name="user_phone" id="user_phone" value="${ login.user_phone }" /></td>
		   		</tr>
		   		<tr>
		   			<th>이메일</th>
			   		<td><input type="text" name="user_mail" id="user_mail" value="${ login.user_mail }" /></td>
		   		</tr>
		   		<tr>
			   		<td>
			   		<input  type="submit"  value="수정"/>
			   		
			   		<a href="javascript:history.back();" >확인</a>
			   		</td>
		   		</tr>
		   	</table>
	   </form>
	</body>
</html>













