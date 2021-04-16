<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@include file="layout/header.jsp"%>
    <div class="sub-main-wrap">
    	<%@include file="layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="layout/allSearchHeader.jsp"%>
            
            
            <script>
	            var win;
	            function createWindow(){
	             win = open('','TodoTalk','width=450,height=650');
	            }
            </script>
            
            <div class="middle-content-wrap">
                <!--여기부터 컨텐츠내용 작업시작-->

                <div id="tutorSearch">
                튜터 검색결과 - 총 ${ tutorVoSize } 건
                <c:forEach var="tutorVo" items="${ tutorVo }">
                <br>
                	<div>
                	튜터 : ${ tutorVo.user_name } <br>
                	이메일 : ${ tutorVo.user_mail } <br>
                	국적 : ${ tutorVo.country }　　좋아요 ${ tutorVo.recommend }<br>
                	<form action="/talk" method="POST" target="TodoTalk" onsubmit="createWindow();">
                	<input type="hidden" name="loginId" value="${login.user_id}" />
                	<input type="hidden" name="receiverId" value="${tutorVo.user_id }" />
                	<input type="hidden" name="requireId" value="${login.user_id }" />
                	<input type="submit" value="대화시작"/>
                	</form>
                	
                	<a href="/rooms/">대화방 목록</a>
                	<!-- 대화방 목록에 수식 걸어서 내아이디 포함된 방만 보여주기 -->
                	</div>
                <br>
                </c:forEach>
                </div>
                <br>
                <hr>
                <br>
                <div id="mentorSearch">
                멘토 검색결과 - 총 ${ mentorVoSize }건
                <c:forEach var="mentorVo" items="${ mentorVo }">
                <br>
                	<div>
                	멘토 : ${ mentorVo.user_name } <br>
                	이메일 : ${ mentorVo.user_mail } <br>
                	국적 : ${ mentorVo.country }　　좋아요 ${ mentorVo.recommend }<br>
                	<form action="/talk" method="POST" target="TodoTalk" onsubmit="createWindow();">
                	<input type="hidden" name="loginId" value="${login.user_id}" />
                	<input type="hidden" name="receiverId" value="${mentorVo.user_id }" />
                	<input type="hidden" name="requireId" value="${login.user_id }" />
                	<input type="submit" value="대화시작"/>
                	</form>
                	
                	<a href="/rooms/">대화방 목록</a>
                	</div>
                <br>
                </c:forEach>
                </div>
             	<br>
                <hr>
                <br>
              
                <div class="boardSearch">
                게시판 검색결과 - 총 ${ boardAllSearchSize }건
                <c:forEach var="boardAllSearch" items="${ boardAllSearch }">
                <br>
                	<div>
                	분류 : ${ boardAllSearch.BOARD_NAME }   작성자 : ${ boardAllSearch.USER_ID }<br>
                	<a href="#">${ boardAllSearch.TITLE }</a> <br>
                	${ boardAllSearch.CONT } <br>
                	${ boardAllSearch.REGDATE }
                	</div>
                <br>
                </c:forEach> 
                </div>
            </div>
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