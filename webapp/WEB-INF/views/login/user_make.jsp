<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.red  { color:red;}
	.blue { color:blue;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
   $(function() {  
	   		var user_id          = document.getElementById('user_id');
	   		var user_name        = document.getElementById('user_name');
	   		var user_pwd         = document.getElementById('user_pwd');
	   		var user_pwd2        = document.getElementById('user_pwd2');
	   		var id_check_result  = document.getElementById('id_check_result');
	   		
	   		
	   		$('#user_phon2').on('keyup', function(e){
	   			 var regNumber = /^\d{1,4}$/; 
	   			/* var regNumber = /^[0-9]{1,4}$/; */
	   			var temp = $('#user_phon2').val();
		   		

	   			if(!regNumber.test(temp)){
	   				console.log('잘못된값잆니다.  다시 입력하세요');
	   				/*  $('#user_phon2').val(temp.replace(/^\d{1,4}/g, '')); */ 
	   				 $('#user_phon2').val(temp.replace(/[0-9]{1,4}/g, ''));
	   				return false;
	   			}else{
	   				return true;
	   			}
	   		});
	   		$('#user_mail1').on('keyup', function(e){
	   			var regmail= /^[0-9a-zA-Z_\.-]*$/;
	   			var temp2 = $('#user_mail1').val();
	   			if(!regmail.test(temp2)){
	   				console.log('다시 입력하세요');
	   				$('#user_mail1').val(temp2.replace(/[^0-9a-zA-Z_\.-]/g, ''));
	   				alert('다시 입력하세요');
	   				return false;
	   			}else{
	   				return true;
	   			}
	   		});
	   		$('#user_mail2').on('keyup', function(e){
	   			var regmail= /^[0-9a-zA-Z_\.-]*$/;
	   			var temp2 = $('#user_mail2').val();
	   			if(!regmail.test(temp2)){
	   				console.log('다시 입력하세요');
	   				$('#user_mail2').val(temp2.replace(/[^0-9a-zA-Z_\.-]/g, ''));
	   				alert('다시 입력하세요');
	   				return false;
	   			}else{
	   				return true;
	   			}
	   		});
	   		
	   		
	   		
	   		// 회원가입눌렀을때
			$('form').on('submit', function(e){
				// 아이디가  '' 이면  false
				if(user_id.value=='' ){
					alert('아이디를 입력 입력바랍니다');
					user_id.focus();
					return false;
				}
				// 이름이  '' 이면  false
				else if(user_name.value=='' ){
					alert('이름을 입력 입력바랍니다');
					user_name.focus();
					return false;
				}
				
				// 비밀번호가 '' 이면  false
				else if(user_pwd.value=='' ){
					alert('암호 입력 입력바랍니다');
					user_pwd.focus();
					return false;
				}
				// 비밀번호2가 '' 이면  false 
				else if(user_pwd2.value=='' ){
					alert('암호2 입력 입력바랍니다');
					user_pwd2.focus();
					return false;
				}
				// 이메일이  '' 이면  false 
				else if($('#user_mail1').val()==''  ){
					alert('이메일 입력바랍니다');
					$('#user_mail1').focus();
					return false;
				}
				// 이메일이  '' 이면  false 
				else if( $('#user_mail2').val()=='' ){
					alert('이메일 입력바랍니다');
					$('#user_mail2').focus();
					return false;
				}
				// 국적이  '' 이면  false 
				else if($('#country').val()=='' ){
					alert('국적을  입력바랍니다');
					$('#country').focus();
					return false;
				}
				// 
				/* else if(($('#check').val() == '')){
					alert('아이디  중복체크바랍니다');
					$('#id_check_result').focus();
					return false;
				} */
				 else if(($('#id_check_result').children().attr('class') != 'blue')){
					alert('아이디  중복체크바랍니다');
					$('#id_check_result').focus();
					return false;
				} 
				// 
				else if(($('#pws_check_result').children().attr('class') != 'blue')){
					alert('암호 체크바랍니다');
					$('#pwd_check_result').focus();
					return false;
				}
				// 비밀번호1과 비밀번호2의 값이 같다면 true
				else if(user_pwd.value()!=user_pwd2.value() ){
					return false;
					alert('암호들을  확인 바랍니다');
					user_pwd.focus();
				// 아이디 혹은 비밀번호 체크를 안한경우
				}else if($('#id_check_result').children().attr('class')== '' || $('#pwd_check_result').children().attr('class')== ''){
					alert('아이디 중복체크 혹은 비밀번호 체크를  해주세요');
					$('#button2').focus();
					return  false;
				// 아이디 체크다 red 이거나 비밀번호 체크가 red 이거나 아이디가 '' 이면 false 
				}else if( $('#id_check_result').children().attr('class') == 'red' ||$('#pwd_check_result').children().attr('class') == 'red' || user_id.value == '' ){
					alert('아이디 입력바랍니다');
					user_id.focus();
					return false;
				// 아이디와 비밀번호가 blue 일때만 true
				}else if($('#id_check_result').children().attr('class') == 'blue' && $('#pwd_check_result').children().attr('class') == 'blue' &&$('#user_mail1').val()!=''&&$('#user_mail2').val()!=''&&$('#user_mail3').val()!=''){
					return true;
				// 나머지 혹시 false  다른 에러있음 추가하겠습니다
				}else{
					return  false;
				}
			}); // 회원가입눌렀을때 end
			// 비밀번호 체크
			$('#button_pwd').on('click', function(e){
				// 비밀번호가  '' 이면  false 
				
				if($('#user_pwd').val() ==''){
					alert('-1');
					$('#user_pwd').focus();
					return false;
				}else{
					 if ($('#user_pwd').val().trim().length < 5 || $('#user_pwd').val() == null) {
						 $('#user_pwd').focus();
	 		         	 $("#pwd_check_result").html('<b class="red">최소 6글자입니다</b>');
							return false;
			   		 }else {
			   			 
						if($('#user_pwd').val().trim().length > 5 && $('#user_pwd').val().trim().length==$('#user_pwd2').val().trim().length ){
							alert('체크 완료');
							$("#pwd_check_result").html('<b class="blue">체크완료</b>');
							return true;
						}else{
							
							alert('비밀번호를 확인해주세요');
							$("#pwd_check_result").html('<b class="red">다시 입력하세요</b>');
							$('#user_pwd').focus();
							return false;	
				   		}
					}			
				}
				}); // 비밀번호 체크 끝
		
			
			
			// 아이디 중복 확인
			$('#button2').on('click', function(e){
				if($('#user_id').val()==''){
					alert('아이디 적어주세요');
					$('#user_id').focus();
					return false;
				}else{
					$.ajax({
						url:'/Check_id',
						data:{
						user_id:$('#user_id').val()
					}, 
						type:'POST',
						success: function(data){
							alert('사용 가능한 아이디 입니다');
							$("#id_check_result").html(data.html);
							console.log(data.html);
						},
						error: function(xhr){
							xhr.status+","+ xhr.statusText;
						}
						});
				}
			});
			// 아이디 중복 확인 끝
			
			// 메일뒤에  선택 예(네이버 : naver.com)
			$('#user_mail3').on('keyup', function(e){
				if ($("#user_mail3").val() == ""){
					$("#user_mail3").val('');
					$("#user_mail2").attr(false);
					$("#user_mail2").focus();
				}else{
					$("#user_mail2").val($("#user_mail3").val());
				}				
			}); 
			$('#user_mail3').on('click', function(e){
				if ($("#user_mail3").val() == ""){
					$("#user_mail3").val('');
					$("#user_mail2").attr(false);
					$("#user_mail2").focus();
				}else{
					$("#user_mail2").val($("#user_mail3").val());
				}				
			}); 
			// 메일뒤에  선택 예(네이버 : naver.com) 끝
			
			// 국가 선택 
			$('#country1').on('keyup', function(e){
				if ($("#country1").val() == ""){
					$("#country1").val('');
					$("#country1").attr(false);
					$("#country").focus();
				}else{
					$("#country").val($("#country1").val());
				}				
			});
			$('#country1').on('click', function(e){
				if ($("#country1").val() == ""){
					$("#country1").val('');
					$("#country1").attr(false);
					$("#country").focus();
				}else{
					$("#country").val($("#country1").val());
				}				
			});
			// 국가 선택  끝
			// 폰 앞번호 선택
			$('#user_phon').on('keyup', function(e){
				if ($("#user_phon").val() == ""){
					$("#user_phon").val('');
					$("#user_phon").attr(false);
					$("#user_phon1").focus();
				}else{
					$("#user_phon1").val($("#user_phon").val());
				}				
			});
			$('#user_phon').on('click', function(e){
				if ($("#user_phon").val() == ""){
					$("#user_phon").val('');
					$("#user_phon").attr(false);
					$("#user_phon1").focus();
				}else{
					$("#user_phon1").val($("#user_phon").val());
				}				
			});
			// 폰 앞번호 선택
   });
   
   function joinFm(){
	 var formdate =$("form[name=joinFm]").serializeObject();
	 var jsondata = JSON.stringify(formdate);
	 
	 $.ajax({
			url:'/joinFm',
			contentType : "application/json; charset=utf-8",
			dataType : 'json',
			data:jsondata,
			type:'POST',
			success: function(data){
				
			},
			error: function(xhr){
				xhr.status+","+ xhr.statusText;
			}
			});
	 
	 
	 
   }
   
</script>
</head>
<body>
<%@include file="../layout/header.jsp"%>
   <div class="sub-main-wrap">
  <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap">
   <div class="sub-section-wrap review-sttus">
                        <section style="width: 82%; margin: 16px auto;">
                            <div class="section-tit">
                                <h3>회원가입</h3>
                            </div>
                            <div class="table-wrap">
                      		 <form  action="/User_Make" method="POST">
                                <table class="table-type02">
                                    <caption>회원가입 테이블</caption>
                                    <colgroup>
                                        <col class="wp20">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
                                        <tr>
								   			<th>아이디</th>
									   		<td><input type="text" name="user_id" id="user_id" class="wp40"/><span id="id_check_result"></span></td>
									   		<td><input type="button" value="아이디 중복확인 " id='button2'/></td>
									   			
								   		</tr>
								   		<tr>
								   			<th>이름</th>
									   		<td><input type="text" name="user_name" id="user_name" class="wp40" /></td>
									   		
								   		</tr>
								   		<tr>
								   			<th>비번</th>
									   		<td><input type="password" name="user_pwd" id="user_pwd"class="wp40" /></td>
								   		</tr>
								   		<tr>
								   			<th>비번2</th>
									   		<td><input type="password" id="user_pwd2" class="wp40"/><span id="pwd_check_result"></span></td>
									   		<td>
									   			<input type="button" id="button_pwd" value="비밀번호 확인"/>
									   		</td>
								   		</tr>
									   		
								   		 <tr>
								   		 	<th>휴대폰번호</th>
									   		<td>
									   			<select id=user_phon>
									   				<option value="">직접입력</option>
									   				<option value="010">010</option>
									   				<option value="011">011</option>
									   			</select>
										   			<input type="text" name="user_phone1" id="user_phon1"  class="wp18"/>-
										   			<input type="text" name="user_phone2" id="user_phon2"  class="wp18"/>-
										   			<input type="text" name="user_phone3" id="user_phon3"  class="wp18"/>
									   		</td>
								   		</tr> 
								   		<tr>
								   			<th>이메일</th>
									   		<td><input type="text" name="user_mail1" id="user_mail1"  class="wp40"/>
									   			@
									   			<input type="text" name="user_mail2" id="user_mail2"  class="wp40"/>
									   			<select id=user_mail3>
									   				<option value="">직접 입력</option>
									   				<option value="naver.com">네이버</option>
									   				<option value="nate.com">네이트</option>
									   			</select>
									   			
									   		</td>
									   		
								   		</tr>
								   		<tr>
								   			<th>국적</th>
									   		<td><input type="text" name="country" id="country"  class="wp80"/>
								   			<select  id="country1">
									   			<option value="">선택하세요</option> 
									   			<option value="한국">대한한국</option> 
									   			<option value="미국">미국</option> 
									   			<option value="일본">일본</option> 
									   			<option value="중국">중국</option> 
								   			</select>
								   			</td>
								   		</tr>
								   		<tr>
								   			<th>당신은 멘토 입니까 튜터 입니까?</th>
									   		<td><input type="checkbox" name="register" value="" />상관없음
								  				<input type="checkbox" name="register" value="1" />멘토/멘티
								  				<input type="checkbox" name="register" value="2" />튜터
									   		</td>
								   		</tr>
								   		<tr>
									   		<td>
						                        <input type="submit" value="회원가입" class="btn-minsu"/>
										   		<input type="button" value="취소"  onclick="location.href='javascript:history.back();' "  />
									   		</td>
								   		</tr>
								   		
                                    </tbody>
                                </table>
                                </form>
                            </div>
                           	
                        </section>
                       <!--  <div class="btn-box">
                        	<ul>
                        		<li><a href="javascript:joinFm()">회원가입</a></li>
                        		<li><a href="">취소</a></li>
                        	</ul>
                        </div> -->
                </div>
	        </div>
	       <section style="width: 88%; margin: 10px auto; background:#f1f1f1; box-shadow: 0px 0px 0px 0px;">
	         <div class="sub-contents">
                    <div class="tabs">
                        <div id="pro_cap_btns">
                            <ul>
                                <li onClick="sub_pop(1);" id="menu1" class="sub_pop1">공지사항</li>
                                <li onClick="sub_pop(2);" id="menu2" class="sub_pop2">커뮤니티</li>
                            </ul>
                        </div>

                        <div id="sub_pa_pop_1">
                            <div class="">
                                <div class="">
                                    <ul>
                                        <li class="">메인페이지 공지사항입니다.</li>
                                        <span class="regdate">2021-04-02</span>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="sub_pa_pop_2">
                            <div class="">
                                <div class="">
                                    <ul>
                                        <li class="">메인페이지 커뮤니티입니다.</li>
                                        <span class="regdate">2021-04-02</span>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="width: 55%; height: 300px; background: #00a2ff; margin-top: 49px;">
                        추천멘트및강의 프로그램 목록(광고 또는 별점순)
                    </div>
                </div>
              </section>
	            <footer>
	                <div class="sub-footer">
	                    <p></p>
	                    <p>시스템관리자</p>
	                    <p>todotalk@gmail.com <span class="red fs13">(수정할 수 없는 항목에 오류가 있는 경우는 시스템 관리사에게 해당메일로 수정 요청을 해주시기 바랍니다.)</span></p>
	                </div>
	            </footer>
	        </div>
	        <!--//sub-container-wrap-->
	    </div>
	    <!--//sub-main-wrap-->
   
   
   
	</body>
</html>













