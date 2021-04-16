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
		$('form').on('submit', function(e){
			
			
			// 비밀번호가 '' 이면  false
			if($('#user_pwd').value=='' ){
				alert('암호 입력 입력바랍니다');
				user_pwd.focus();
				return false;
			}
			
			// 비밀번호2가 '' 이면  false 
			else if($('#user_pwd2').value=='' ){
				alert('암호2 입력 입력바랍니다');
				user_pwd2.focus();
				return false;
			}else if($('#user_pwd').value!=$('#user_pwd2').value ){
				return false;
				alert('암호들을  확인 바랍니다');
				user_pwd.focus();
			}else if ($('#user_pwd').val().trim().length < 5 ) {
						 $('#user_pwd').focus();
							return false;
			}else if($('#user_pwd').val().trim().length > 5 && $('#user_pwd').val().trim().length==$('#user_pwd2').val().trim().length ){
							alert('체크 완료');
							return true;
			
			}else {
				alert('예외 발생 문제를 알려주세요');
				return  false;
			}
				
			
		});
			
   });
</script>
</head>
<body>


   <h1>틀렸습니다</h1>
   <h1>다시 비밀번호 입력해주세요</h1>
	   <form  action="/Find_PwdLoding" method="POST">
		   	<table>
		   		<tr>
		   			<td>비밀번호를 입력하세요</td>
		   			<td><input type="password" name="user_id" id="user_id"/></td>
		   		</tr>
		   		<tr>
		   			<td>비밀번호 한번더  입력하세요</td>
		   			<td><input type="password" name="user_id2" id="user_id2"/></td>
		   		</tr>
		   	
		   		<tr>
			   		<td>
			   		<input type="submit" value="비밀번호 변경"/>
			   		<a href="javascript:history.back();" >취소</a>
			   		<a href="/" >홈으로</a>
			   		</td>
		   		</tr>
		   	</table>
	   </form>
	   
	   
	</body>
</html>













