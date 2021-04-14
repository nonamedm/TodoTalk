
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>     
<%@include file="../layout/header.jsp"%>

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
                               
	<h1>Question 1</h1>	
	
  <form action="/postwriting" method="POST">
  <table id="board">
  	<input type="hidden" name="user_idx"         value="5" />     
	<input type="hidden" name="tubo_title"       value="Question1" />     
    <caption><h2>게시물 등록</h2></caption>
    <tr>
      <td class="td2"><input type="text" id="user_id" name="user_id"  value="tutor01" readonly/></td>
    </tr>
	<tr>
	<td><textarea name="tubo_cont" id="tubo_cont" placeholder="이거 보고계신분, 이거 크기좀 늘려주십쇼"></textarea></td>
	</tr> 
   
    <tr>
      <td colspan="2">
       <input type="submit" value="저장" />
      </td>
    </tr>
  </table>
  </form>
	
	
	
​
		 <%--  <div class="rightcolumn">
				<div class="form-popup" id="myForm">
					<form action="<c:url value="/postwriting"/>" method="POST" id="postwriting">
			   		<input type="hidden" name="user_idx"         value="5" />     
			   		<input type="hidden" name="tubo_title"       value="Question1" />     

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
	 --%>
	<c:forEach var="Question"  items="${ tuboListOfQuestion1 }">	
		<div class="row">
	 		 <div class="leftcolumn">
			    <div class="card">
			      <h5>${Question.user_id}, ${Question.tubo_regdate}</h5>
			      <p><a href="/tutoringwrite/view?tubo_idx=${ Question.tubo_idx }&user_id=${Question.user_id}&tubo_regdate=${Question.tubo_regdate}&tubo_title=${Question.tubo_title}">${Question.tubo_cont}</a></p>
			    </div> 
	  		 </div><!-- <div class="leftcolumn"> -->
	  		
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