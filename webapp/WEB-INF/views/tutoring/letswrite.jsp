<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>    
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
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
    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2">
                <!--여기부터 컨텐츠내용 작업시작-->
                               
	<h1>Daily Practice</h1>
​
	<div class="grid-container">
	  <div class="grid-item"><a href="/question1">Question1</a></div>
	  <div class="grid-item"><a href="#">Question2</a></div>
	  <div class="grid-item"><a href="#">Question3</a></div>  
	  <div class="grid-item"><a href="#">Question4</a></div>
	  <div class="grid-item"><a href="#">Question5</a></div>
	  <div class="grid-item"><a href="#">Question6</a></div>  
	</div>
	
	<c:forEach var="tuboVo"  items="${ tuboList }">
		<div class="row">
	 		 <div class="leftcolumn">
			    <div class="card">
			      <h5>${tuboVo.user_id}, ${tuboVo.tubo_regdate}</h5>
			      <p><a href="/tutoringwrite/view?tubo_idx=${ tuboVo.tubo_idx }&user_id=${tuboVo.user_id}&tubo_regdate=${tuboVo.tubo_regdate}">${tuboVo.tubo_cont}</a></p>
			    </div> 
	  		 </div><!-- <div class="leftcolumn"> -->
	  		
		  <div class="rightcolumn">
			<button class="open-button" onclick="openForm()">Do exercise!</button>
				<div class="form-popup" id="myForm">
					<form action="<c:url value="/postwriting"/>" method="POST" id="postwriting">
			   		<input type="hidden" name="user_idx"         value="5" />     

					   <table id="writeTable">
						    <tr>
						    	<h2>UrrrrrrwWriting!!!</h2>
						    </tr>
						    <tr>
						      <td><input type="text" name="user_id"  id="user_id"
						        value="tutor01" readonly /> <!-- 로그인된 유저아이디  -->
						      </td>
						    </tr>
						    <tr>
						    	<div class="question-select" style="width:200px;">
						    		<select name="tubo_title" id="tubo_title" style="width:200px;">
						    			<option value="0"> 주제를 선택하세요 </option>
						    			<option value="1"> Question1 </option>
						    			<option value="2"> Question2 </option>
						    			<option value="3"> Question3 </option>
						    			<option value="4"> Question4 </option>
						    			<option value="5"> Question5 </option>
						    			<option value="6"> Question6 </option>
						    			<option value="7"> 자유 </option>
						    		</select>
						    	</div>
						    </tr>
						    <tr>
						      <td><textarea name="tubo_cont" id="tubo_cont" placeholder="이거 보고계신분, 이거 크기좀 늘려주십쇼"></textarea></td>
						    </tr> 
							<!--     <tr>
							      <td>파일</td>
							      <td id="tdfile">
							        <input type="button" id="btnAddFile" value="Add file" /><br>
							        <input type="file" name="upfile" id="upfile" /><br>        
							      </td>
							    </tr>  -->
						    <tr>      
						      <td colspan="2">
						        <input type="submit" value="확인" />
						      </td>
						    </tr> 
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