<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>    
<%@include file="../layout/header.jsp"%>

<script>
	function openForm() {
	  document.getElementById("myForm").style.display = "block";
	}
	function closeForm() {
	  document.getElementById("myForm").style.display = "none";
	}
</script>
<script>
   $(function() {
	   $('input[type=submit]').on('click', function(event) {
		   alert("저장되었습니다!");
		 })
   });
</script>
<style>
h1 {
  font-size: 40px;
}
</style>
    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2">
                <!--여기부터 컨텐츠내용 작업시작-->
                                 
	<br><h1>Daily Practice</h1><br>

	<div class="grid-container"> 
 	  <div class="grid-item" id="tubo_title1"><a href="/tutoringwrite/view/question1?tubo_title=Question1">Question1. How was your day?</a></div>
 	  <div class="grid-item" id="tubo_title1"><a href="/tutoringwrite/view/question2?tubo_title=Question2">Question2. What is your hobby?</a></div>
	</div>
 


	
	<c:forEach var="tuboVo"  items="${ tuboList }">
		<div class="row">
	 		 <div class="leftcolumn">
			    <div class="card">
			      <h5>${tuboVo.user_id}, ${tuboVo.tubo_regdate}</h5>
			      <p><a href="/tutoringwrite/view?tubo_idx=${ tuboVo.tubo_idx }&user_id=${tuboVo.user_id}&tubo_regdate=${tuboVo.tubo_regdate}&tubo_title=${tuboVo.tubo_title}">${tuboVo.tubo_cont}</a></p>
			    </div> 
	  		 </div><!-- <div class="leftcolumn"> -->
	  		
		  <div class="rightcolumn">
			<button class="open-button" onclick="openForm()">Do exercise!</button>
				<div class="form-popup" id="myForm">
					<form action="<c:url value="/postwriting"/>" method="POST" id="postwriting">
			   		<input type="hidden" name="user_idx"         value="${sessionScope.login.user_idx}" />     

					   <table id="writeTable">
						    <tr>
						    	<h2>글을 쓰시오</h2>
						    </tr>
								<c:choose>
						         <c:when test="${ sessionScope.login.user_id eq null }">
						         	<tr>
						         		<td><input type="text" name="guest"  id="guest"
						        		value="로그인 해주세요" readonly /></td> 
						        	</tr> 
						         </c:when>
						         <c:otherwise>
						         	<tr>
										<td><input type="text" name="user_id"  id="user_id"
						        		value="${sessionScope.login.user_id}" readonly />
						      			</td>
						      		</tr>
						      		<tr>
						    			<div class="question-select" style="width:200px;">
								    		<select name="tubo_title" id="tubo_title" style="width:200px;">
								    			<option value="0"> 주제를 선택하세요 </option>
								    			<option value="Question1"> Question1 </option>
								    			<option value="Question2"> Question2 </option>
								    		</select>
						    			</div>
						    		</tr>
								    <tr>
								      <td><textarea rows="20" cols="50" name="tubo_cont" id="tubo_cont" placeholder="예쁜말 고운말"></textarea></td>
								    </tr> 
								    <tr>      
								      <td colspan="2">
								        <input type="submit" value="확인" />
								      </td>
								    </tr> 
						      		
						         </c:otherwise>
						        </c:choose>
					   </table> 
			  		</form>
				</div><!-- <div class="form-popup" id="myForm"> -->
			</div><!-- <div class="rightcolumn"> -->
	  	</div><!-- <div class="row"> -->
	</c:forEach>


<!-- 		여기까지가 보으니가 쓴거 -->
                

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
