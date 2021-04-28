<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@include file="layout/header.jsp"%>
    <div class="sub-main-wrap">
    	<%@include file="layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="layout/allSearchHeader.jsp"%>
            <script src="js/common.js"></script>
            <script src="js/main.js"></script>
            
            
            <div class="middle-content-wrap">
                <!--여기부터 컨텐츠내용 작업시작-->
				
                <div id="tutorSearch">
                <h3>튜터 검색결과 - 총 ${ tutorVoSize } 건</h3>
                <c:forEach var="tutorVo" items="${ tutorVo }">
                <br>
                	
                	<table class="table-type02" style="width:850px;">
                	<thead></thead>
                	<tbody>
                	<tr><td>튜터 : ${ tutorVo.user_name }</td><td>이메일 : ${ tutorVo.user_mail }</td>
                	<c:choose>
	                	<c:when test="${empty login.user_id}">
	                	</c:when>
	                	<c:otherwise>
	                	<form action="/relation" method="POST" id="relation" target="relationOpen" onsubmit="popup();">
		                	<input type="hidden" name="require_id" value="${ login.user_id }" />
		                	<input type="hidden" name="require_name" value="${ login.user_name }" />
		                	<input type="hidden" name="receiver_id" value="${ tutorVo.user_id }" />
		                	<input type="hidden" name="receiver_name" value="${ tutorVo.user_name }" />
		                	<th><input type="submit" value="멘토신청"  /></th></tr>
	                	</form>
	                	</c:otherwise>
                	</c:choose>
                	<tr><td>국적 : ${ tutorVo.country }</td><td>좋아요 ${ tutorVo.recommend }</td>
                	<form action="/talk" method="POST" target="TodoTalk" onsubmit="createWindow();">
                	<input type="hidden" name="loginId" value="${login.user_id}" />
                	<input type="hidden" name="receiverId" value="${tutorVo.user_id }" />
                	<input type="hidden" name="requireId" value="${login.user_id }" />
                	<c:choose>
	                	<c:when test="${empty login.user_id}">
	                	</c:when>
	                	<c:otherwise>
	                	<th><input type="submit" id="chatStart" value="대화시작"/></th></tr>
	                	</c:otherwise>
                	</c:choose>
                	</form>
                	<tr><td colspan="3">${tutorVo.introduce }</td></tr>
                	</tbody>
                	</table>
                <br>
                </c:forEach>
                </div>
                <br>
                <hr>
                <br>
                <div id="mentorSearch">
                <h3>유저 검색결과 - 총 ${ mentorVoSize }건</h3>
                <c:forEach var="mentorVo" items="${ mentorVo }">
                <br>
                	<table class="table-type02" style="width:850px;">
                	<thead></thead>
                	<tbody>
                	<tr><td>이름 : ${ mentorVo.user_name } </td><td>이메일 : ${ mentorVo.user_mail } </td>
                	<c:choose>
	                	<c:when test="${empty login.user_id}">
	                	</c:when>
	                	<c:otherwise>
	                	<form action="/relation" method="POST" id="relation" target="relationOpen" onsubmit="popup();">
		                	<input type="hidden" name="require_id" value="${ login.user_id }" />
		                	<input type="hidden" name="require_name" value="${ login.user_name }" />
		                	<input type="hidden" name="receiver_id" value="${ mentorVo.user_id }" />
		                	<input type="hidden" name="receiver_name" value="${ mentorVo.user_name }" />
		                	<th><input type="submit" value="멘토신청"  /></th></tr>
	                	</form>
	                	</c:otherwise>
                	</c:choose>
                	<tr><td>국적 : ${ mentorVo.country }</td><td>좋아요 ${ mentorVo.recommend }</td>
                	<form action="/talk" method="POST" target="TodoTalk" onsubmit="createWindow();">
                	<input type="hidden" name="loginId" value="${login.user_id}" />
                	<input type="hidden" name="receiverId" value="${mentorVo.user_id }" />
                	<input type="hidden" name="requireId" value="${login.user_id }" />
                	<c:choose>
	                	<c:when test="${empty login.user_id}">
	                	</c:when>
	                	<c:otherwise>
	                	<th><input type="submit" id="chatStart" value="대화시작"/></th></tr>
	                	</c:otherwise>
                	</c:choose>
                	</form>
                	<tr><td colspan="3">${mentorVo.introduce }</td></tr>
                	</tbody>
                	</table>
                <br>
                </c:forEach>
                </div>
             	<br>
                <hr>
                <br>
              
                <div class="boardSearch">
                <h3>게시판 검색결과 - 총 ${ boardAllSearchSize }건</h3>
                <c:forEach var="boardAllSearch" items="${ boardAllSearch }">
                <br>
                	<table class="table-type02" style="width:850px;">
                	<thead></thead>
                	<tbody>
                	<tr><td>분류 : ${ boardAllSearch.BOARD_NAME } </td><td>작성자 : ${ boardAllSearch.USER_ID } </td></tr>
                	<tr><td colspan="2"><a href="#">${ boardAllSearch.TITLE }</a></td></tr>
                	<tr><td colspan="2">${ boardAllSearch.CONT }</td></tr>
                </tbody>
                	</table>
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
    <script>
    function popup () {
    	//alert(form);
    	window.open('','relationOpen','toolbar=no, width=500,height=350');
    }
    $(function(){
    	
    });
    </script>
</body>

</html>