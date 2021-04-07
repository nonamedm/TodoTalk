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
            <div class="middle-content-wrap2 ciIntro">
                <!--여기부터 컨텐츠내용 작업시작-->
                <div class="top-title">
					<h1><span class="listBefore"></span>CI 소개</h1>
                </div>
                <div style="text-align: center;">
                	<img src="../img/common/CIIntro-img.jpg" alt="LOGO">
                	<div class="logo-cont" style="margin-top: 8px;">
                		로고의 의미 토도톡 이라는게 어떤 의미인지 설명을 적어주세요
                	</div>
                </div>
                <div class="color-intro">
                	<ul>
                		<li><span class="color-box1">#00A2FF</span> : ??</li>
                		<li><span class="color-box2">#1EDA69</span> : ??</li>
                	</ul>
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