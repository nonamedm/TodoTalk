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
	function noticeDelete(){
		var con_result = confirm("삭제 하시겠습니까?");
		
		if(con_result == true){
			alert("삭제되었습니다.");
			location.href = "/noticeDelete?idx=${getViewRead.NOTICE_IDX}";
		}else{
			alert("취소하였습니다.");
			return false;
		}
	}
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
                    <form action="/noticeWrite" method="POST" enctype="multipart/form-data">
                    		<input type="hidden" name="notice_user" value="${user_id}">
	                        <section class="wp100">
	                            <div class="section-tit">
	                                <h3>글쓰기</h3>
	                            </div>
	                            <div class="table-wrap">
	                                <table class="table-type02">
	                                    <caption>공지사항 글쓰기 테이블</caption>
	                                    <colgroup>
	                                        <col class="wp8">
	                                        <col class="wauto">
	                                        <col class="wp8">
	                                        <col class="wp20">
	                                    </colgroup>
	                                    <tbody>
	                                   	  <tr>
	                                        <th>제목</th>
	                                        <td>${getViewRead.NOTICE_TITLE}</td>
	                                        <th>조회수</th>
	                                        <td>${getViewRead.NOTICE_READCOUNT}</td>
	                                      </tr>
	                                      <tr>
	                                        <th>내용</th>
	                                        <td colspan="3" style="width:100%; height:500px;">${getViewRead.NOTICE_CONT}</td>
	                                      </tr>
	                                      <tr>
	                                      	<th>작성자</th>
	                                      	<td>${getViewRead.USER_ID}</td>
	                                      	<th>작성일</th>
	                                      	<td>${getViewRead.NOTICE_REGDATE}</td>
	                                      </tr>
	                                    </tbody>
	                                </table>
	                            </div>
                           	
	                        </section>
	                        <c:choose>
	                        	<c:when test="${user_register == 0}">
	                        		<div class="btn-box">
					                    <ul>
					                        <li><a href="/noticeFm" title="목록으로" class="">목록으로</a></li>
					                        <li><a href="/noticeUpdateFm?idx=${getViewRead.NOTICE_IDX}" title="수정" class="">수정</a></li>
<%-- 					                        <li><a href="/noticeDelete?idx=${getViewRead.NOTICE_IDX}" title="삭제" class="bg-blue">삭제</a></li> --%>
					                        <li><a href="javascript:noticeDelete()" title="삭제" class="bg-blue">삭제</a></li>
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