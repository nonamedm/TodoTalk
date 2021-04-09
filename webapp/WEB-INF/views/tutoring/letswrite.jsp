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
    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2">
                <!--여기부터 컨텐츠내용 작업시작-->
                
                         
	<h1>Daily Practice</h1>
​
	<div class="grid-container">
	  <div class="grid-item"><a href="#">Question1</a></div>
	  <div class="grid-item"><a href="#">Question2</a></div>
	  <div class="grid-item"><a href="#">Question3</a></div>  
	  <div class="grid-item"><a href="#">Question4</a></div>
	  <div class="grid-item"><a href="#">Question5</a></div>
	  <div class="grid-item"><a href="#">Question6</a></div>  
	</div>

	<div class="row">
 		 <div class="leftcolumn">
		    <div class="card">
		      <h2>4월 1주차 학습내용</h2>
		      <h5>${sessionScope.login.userid} April 7, 2021</h5>
		      <div class="fakeimg" style="height:200px;">Image</div>
		      <p>(회원들 글)Bonjour, chaсun! Je parle le russe et l'anglais et j'apprends francais (B2) et l'allemagne (B1). Je cherche les gens avec lesquels je pourrais parler cette langue magnifique a laquelle j'ecris cette message. Je voudrais aussi aider les gens qui apprennent le russe. J'ai experience d'expliquer des themes difficiles de mon langue et je suis sur et certain qu'on pourrait travailler ensemble:)</p>
		     
		    </div>
		    <div class="card">
		      <h2>TITLE HEADING</h2>
		      <h5>${sessionScope.login.userid} Sep 2, 2017</h5>
		      <div class="fakeimg" style="height:200px;">Image</div>
		      <p>Some text..</p>
		      
		    </div>
  		</div><!-- <div class="leftcolumn"> -->
  		
  <div class="rightcolumn">
	<button class="open-button" onclick="openForm()">Do exercise!</button>
	
		<div class="form-popup" id="myForm">
		  	<form action="" method="POST" id="">
			<input type="hidden" name="TUBO_IDX"     value="${ TUTOR_BOARD.TUBO_IDX }" />     
	   		<input type="hidden" name="TUBO_CONT"        value="${ TUTOR_BOARD.TUBO_CONT }" />     
	   		<input type="hidden" name="USER_IDX"         value="${ TUTOR_BOARD.USER_IDX }" />     
	   		<input type="hidden" name="USER_ID"        value="${ TUTOR_BOARD.USER_ID }" />        
		
		   <table id="writeTable">
		    <caption><h2>UrrrrrrwWriting!!!</h2></caption>
			    <tr>
			      <td><input type="text" name="writer"  id="writer"
			        value="${sessionScope.login.userid}여기는 아이디" readonly /> <!-- 로그인된 유저아이디  -->
			      </td>
			    </tr> 
			    <tr>
			      <td><textarea name="cont" id="cont" placeholder="자유롭게 글을 써주세요."></textarea></td>
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
			<!-- 	<button type="submit" class="btn">Login</button>
				    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
				  -->
	  		</form>
		</div><!-- <div class="form-popup" id="myForm"> -->
	</div><!-- <div class="rightcolumn"> -->
		
				    <div class="card">
				      <h3>Popular Post</h3>
				      <div class="fakeimg">Image</div><br>
				      <div class="fakeimg">Image</div><br>
				      <div class="fakeimg">Image</div>
				    </div>
				    <div class="card">
				      <h3>Follow Me</h3>
				      <p>Some text..</p>
				    </div>
  	</div><!-- <div class="row"> -->





                
                
                
                
               
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