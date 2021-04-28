<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../layout/header.jsp"%>


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
                        <section class="wp100">
                            <div class="section-tit">
                                <h3>공지사항</h3>
                            </div>
                            <div class="table-wrap">
                                <table class="table-type01">
                                    <caption>공지사항 테이블</caption>
                                    <colgroup>
                                        <col class="wp8">
                                        <col class="wauto">
                                        <col class="wp10">
                                        <col class="wp10">
                                        <col class="wp8">
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
                                            <th>글제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="getNoticeList" items="${getNoticeList}">
                                        	<tr>
                                        		<td>${getNoticeList.NOTICE_IDX}</td>
                                        		<td><a href="/noticeRead?idx=${getNoticeList.NOTICE_IDX}">${getNoticeList.NOTICE_TITLE}</a></td>
                                        		<td>${getNoticeList.USER_ID}</td>
                                        		<td>${getNoticeList.NOTICE_REGDATE}</td>
                                        		<td>${getNoticeList.NOTICE_READCOUNT}</td>
                                        	</tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                           	<div class="btn-paging btn-pageing-bg">
								<ul>
								  <c:if test="${pageMaker.prev}">
								    <li>
								    	<a href="<c:url value='/noticeFm?page=${pageMaker.startPage-1}'/>" title="이전"><img src="/img/sub/btn-prev.png" alt="이전"></a>
								    </li>
								  </c:if>
								  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
								    <li>
								    	<a href="<c:url value='/noticeFm?page=${pageNum}'/>" title="더보기">${pageNum}</a>
								    </li>
								  </c:forEach>
								  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								    <li>
								    	<a href="/noticeFm?page=${pageMaker.endPage+1}" title="다음"><img src="/img/sub/btn-next.png" alt="다음"></a>
								    </li>
								  </c:if>
								</ul>
							</div>
                        </section>
                        <c:choose>
                        	<c:when test="${user_register == 0}">
                        		<div class="btn-box">
				                    <ul>
				                        <li><a href="/noticeWriteFm" title="글쓰기" class="bg-blue">글쓰기</a></li>
				                    </ul>
				                </div>
                        	</c:when>
                        </c:choose>
                        
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