<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style></style>
<script	 src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
   $(function() {
	  /*  $('#button1').on('click' , function (e){
			$.ajax({
				url : '/Test',
				data:  
					$('#user_id').val(),
				
				type : 'POST', 
				success :  function(data){
						alert('삭제됨?');
						
				} ,
				
				error: function(xhr){
					
				}
			}); */
		  $('#button1').on('click' , function (e){ 
			 alert('나니'); 
				location.href ='/TestPhoto';
				/* location.history.go(0); */
				/* location.reload(); */
		   
	   });
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
	   <form  action="/User_UpDate" method="POST"  enctype="multipart/form-data">
		   	<table>
		   		<tr>
			   		<td><input type="hidden" name="user_idx" id="user_idx" value="${ login.user_idx }"  /></td>
			   		<td><input type="hidden" name="user_id" id="user_id" value="${ login.user_id }"  /></td>
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
		   			<th>사진</th>
		   			        <c:choose>
								<c:when test="${empty img.photo_name}"> <!-- session 값없을때  -->
								   		<th>프로필 사진 등록</th>
								   		<tr>
									   		<td><input type="file" name="file_name" id="file_name " /></td>
								   		</tr>
								</c:when>
								<c:otherwise> <!--  session 값 잇을때-->
							    <tr>
						   			<th>프로필  사진</th>
							   		<!-- <td ><img src="/image/baby-turtle-6074231_19201.jpg" width="300px" height="300px"/></td> -->
							   			<td><img src="/image/${img.photo_name}"  id="photo_name" name ="photo_name"  width="300px" height="300px"/>  </td>
				   						<td><input  type="button" id = "button1"  value="프로필 사진 삭제"/></td>
				   						<!-- <td><input  type="button" onclick="location.href='/TestPhoto'"id = "button1"  value="프로필 사진 삭제"/></td> -->
						   		</tr>
							                    
								</c:otherwise>
							</c:choose>  
             
		   			
		   			
   						<%-- <div class="form-group" style="border: 1px solid #dbdbdb;">
							<c:forEach var="file" items="${file}">										
								 <img src="/image/${file.stored_file_name}"/>
							</c:forEach>
						</div> --%>
		   		
		   		</tr>
		   		<tr>
			   		<td>
			   		<input  type="submit"  value="수정"/>
			   		<a href="/" >확인</a>
			   		</td>
		   		</tr>
		   	</table>
	   </form>
	</body>
</html>













