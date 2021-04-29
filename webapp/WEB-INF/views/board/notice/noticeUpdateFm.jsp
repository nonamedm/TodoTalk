<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../layout/header.jsp"%>

<style>
	input[type="submit"] {font-size: 15px;
    display: block;
    padding: 6px 17px;
    color: #fff;
    background-color: #325694;
    border-radius: 6px;
    border: 1px solid #fff;
    cursor:pointer;
    }
</style>
<script>
$(function() {
	 $('form').on('submit',function(e) {
		var notice_title = $("#notice_title").val();
		var notice_cont = $("#summernote").val();
		
		if(notice_title == ""){
			alert("제목을 입력하십시오.");
			$("#notice_title").focus();
			return false;
		}
		
		if(notice_cont == ""){
			alert("내용을 입력하십시오.");
			$("#notice_cont").focus();
			return false;
		}
		return true;
	 })
	 
	 $('#summernote').summernote({
			tabsize : 2,
			height : 300
		});
});



</script>
 <div class="sub-main-wrap">
    	<div id="translationTxt" class="translation-txt">
        	<a href="javascript:translationTxt()" title="번역" id="btnTranslation">번역하기</a>
        </div>
        <%@include file="../../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
               	<div class="sub-section-wrap review-sttus">
                    <div class="">
                    <form action="/noticeUpdate" method="POST" enctype="multipart/form-data">
                    		<input type="hidden" name="notice_idx" value="${getViewRead.NOTICE_IDX}">
	                        <section class="wp100">
	                            <div class="section-tit">
	                                <h3>글수정</h3>
	                            </div>
	                            <div class="table-wrap">
	                                <table class="table-type02">
	                                    <caption>공지사항 글수정 테이블</caption>
	                                    <colgroup>
	                                        <col class="wp15">
	                                        <col class="wauto">
	                                    </colgroup>
	                                    <tbody>
	                                   	  <tr>
	                                        <th>제목</th>
	                                        <td><input type="text" name="notice_title" id="notice_title" value="${getViewRead.NOTICE_TITLE}"/></td>
	                                      </tr>
	                                      <tr>
	                                        <th>내용</th>
	                                        <td>
	                                        	<textarea id="summernote" name="notice_cont">${getViewRead.NOTICE_CONT}</textarea>
	                                        </td>
	                                      </tr>
	                                    </tbody>
	                                </table>
	                            </div>
                           	
	                        </section>
	                        <c:choose>
	                        	<c:when test="${user_register == 0}">
	                        		<div class="btn-box">
					                    <ul>
					                    	<li><input type="submit" class="bg-blue" value="수정완료"/></li>
					                        <li><a href="javascript:history.back()" title="취소" class="">취소</a></li>
					                    </ul>
					                </div>
	                        	</c:when>
	                        </c:choose>
                        </form>
                    </div>
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
</body>
</html>