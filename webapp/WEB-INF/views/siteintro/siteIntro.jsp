<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <div class="header-wrap">
                <div class="header-title">
                </div>
                <div class="common-box">
                    <div class="search-input">
                        <input type="text" placeholder="통합검색">
                        <a href="#" title="검색" class="btn-search2"></a>
                    </div>
                    <div class="user-wrap">
                        <div class="user-img">
                            <a href="#" title="사용자 정보 더보기" class="user-open">
                                <img src="../img/common/user-img.png" alt="사용자 이미지">
                                <span class="mask"></span>
                            </a>
                        </div>
                        <div class="user-info-txt">
                            <ul>
                                <li class="user-team"></li>
                                <li class="user-name">손민수</li>
                            </ul>
                        </div>
                        <div class="user-detail-box">
                            <ul>
                            	<li><a href="#" title="개인정보 수정" class="pw-change">개인정보 수정</a></li>
                                <li><a href="#" title="로그아웃" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="middle-content-wrap2 siteFuncIntro">
                <!--여기부터 컨텐츠내용 작업시작-->
                <div class="top-title">
					<h1><span class="listBefore"></span>사이트 기능 소개</h1>
                </div>
                <div style="background: #fff; width: 100%; height: 400px; padding: 200px; text-align: center; font-weight: 900; margin-bottom: 12px;">
                	여기 안에는 첨삭할 수 있다, 튜터링 기능, 멘토+멘티 1대1 강의 연결시스템? 영상 하나 올리는거 추천<br/>
                	
                </div>
                <div class="cont">
                	사이트 기능에 대한  자세한 내용을 채워주십시오.
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