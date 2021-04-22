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
		  $('#button1').on('click' , function (e){ 
				location.href ='/TestPhoto';
		   
	   });
   });
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
                                <h3>회원정보                                </h3>
                            </div>
                            <div class="table-wrap">
						 	   <form  action="/User_UpDate" method="POST" enctype="multipart/form-data">
                                <table class="table-type02">
                                    <caption>로그인 테이블</caption>
                                    <colgroup>
                                        <col class="wp20">
                                        <col class="wauto">
                                    </colgroup>
                                    <tbody>
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
													   		</tr>
									   		<tr>
										   		<td>
										   		<input  type="submit"  value="수정"/>
										   		<a href="/" >확인</a>
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
	</body>
</html>













