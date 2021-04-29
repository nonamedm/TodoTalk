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
			 $('form').on('submit',function(e) {
				 idCheck(); 
			
			 })  
   });
	//var result = '';
    function idCheck() {
	// 아이디 체크2 
		$.ajax({
			url:'/Check_id2',
			data:{ 
				user_id :$('#user_id').val(),
				user_pwd:$('#user_pwd').val()
				},
		
			type:'POST',
			success:function(data){
				 
				if(data.result == -1){
					alert("회원이 아닙니다.\n회원가입을 해주세요.");
				}
				
				if(data.result == 0){
					alert("아이디혹은 비밀번호가  틀렸습니다.");
				}
				
				if(data.result == 1){
					alert('로그인성공');
				}
				
				
			 $("#id_check_result").html(data.html); 
			},
			error:function(xhr){
				alert(xhr.status+" : "+xhr.statusText);
			}
		}); 
 
    } 
  /*   function Login(){
    	 var formdate =$("form[name=Login]").serializeObject();
    	 var jsondata = JSON.stringify(formdate);
    	 
    	 $.ajax({
    			url:'/Login',
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
    } */
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
                                <h3>로그인</h3>
                            </div>
                            <div class="table-wrap">
						 	   <form  action="/Login" method="POST">
                                <table class="table-type02">
                                    <caption>로그인 테이블</caption>
                                    <colgroup>
                                        <col class="wp20">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
                                       
										   		<tr>
										   			<th>아이디</th>
											   		<td><input type="text" name="user_id" id="user_id"  class="wp30" /><span id=id_check_result></span></td>
										   		</tr>
										   		<tr>
										   			<th>비번</th>
											   		<td><input type="password" name="user_pwd" id="user_pwd"  class="wp30" /></td>
										   		</tr>
										   		<tr>
											   		<td  class="wp30">
												   		<input type="submit" value="로그인" />
												   		<input type="button" value="취소"  onclick="location.href='javascript:history.back();'"  />
												   		<input type="button" value="회원가입"  onclick="location.href='/User_MakeForm;'"  />
												   		<input type="button" value="아이디/비번찾기"  onclick="location.href='/Find;'"  />
											   		</td>
										   		</tr>
								          </tbody>
                                </table>
                                </form>
                            </div>
                           	
                        </section>
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













