<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Todotalk</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/css/import.css" />
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/script.js"></script>
    <script src="/js/TweenMax.min.js"></script>
    <script>
    	
    </script>
</head>

<body>
    <div class="sub-main-wrap">
        <div class="lnb-wrap">
            <div class="lnb-top-cont">
                <h1><a href="/" title="홈으로가기"><img src="../img/common/logo.png" alt="홈바로가기"></a></h1>
                <a href="#" title="메뉴" class="menu-btn menubar"></a>
            </div>
            <div class="lnb-menu">
                <ul>
                    <li>
                        <a href="#" title="사이트 소개" class="lnb-dep1">사이트 소개</a>
                        <ul class="lnb-dep2">
                            <li><a href="/siteFuncIntro" title="사이트 기능 소개" class="">사이트 기능 소개</a></li>
                            <li><a href="/adminIntro" title="관리자 소개" class="">관리자 소개</a></li>
                            <li><a href="/ciIntro" title="CI 소개" class="">CI 소개</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" title="튜터링" class="lnb-dep1">튜터링</a>
                        <ul class="lnb-dep2">
                            <li><a href="#" title="학습공간" class="">학습공간</a></li>
                            <li><a href="#" title="튜터링 언어 검색" class="">튜터링 언어 검색</a></li>
                            <li><a href="#" title="튜터링 내용 등록" class="">튜터링 내용 등록</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" title="멘토링" class="lnb-dep1">멘토링</a>
                        <ul class="lnb-dep2">
                            <li class="on"><a href="#" title="멘토,멘티 검색/등록">멘토,멘티 검색/등록</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" title="게시판" class="lnb-dep1">게시판</a>
                        <ul class="lnb-dep2">
                            <li><a href="#" title="공지사항" class="">공지사항</a></li>
                            <li><a href="#" title="Q&A" class="">Q&A</a></li>
                            <li><a href="#" title="커뮤니티" class="">자유 커뮤니티</a></li>
                            <li><a href="#" title="커뮤니티" class="">멘티 멘토 소통 커뮤니티</a></li>
                        </ul>
                    </li>
<!--                     <li> -->
<!--                         <a href="#" title="개인정보 관리" class="lnb-dep1">개인정보 관리</a> -->
<!--                         <ul class="lnb-dep2"> -->
<!--                             <li><a href="#" title="2dep menu 1" class="">2dep menu 1</a></li> -->
<!--                             <li><a href="#" title="2dep menu 2" class="">2dep menu 2</a></li> -->
<!--                             <li><a href="#" title="2dep menu 3" class="">2dep menu 3</a></li> -->
<!--                             <li><a href="#" title="2dep menu 4" class="">2dep menu 4</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->
                    <li>
                        <a href="#" title="관리자 메뉴" class="lnb-dep1">관리자 메뉴</a>
                        <ul class="lnb-dep2">
                            <li><a href="#" title="2dep menu 1" class="">2dep menu 1</a></li>
                            <li><a href="#" title="2dep menu 2" class="">2dep menu 2</a></li>
                            <li><a href="#" title="2dep menu 3" class="">2dep menu 3</a></li>
                            <li><a href="#" title="2dep menu 4" class="">2dep menu 4</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="lnb-menu lnb-menu2" style="display: none">
                <ul>
                    <li>
                        <a href="#" title="사이트소개" class="lnb-dep1"></a>
                    </li>
                    <li>
                        <a href="#" title="튜터링" class="lnb-dep1"></a>
                    </li>
                    <li>
                        <a href="#" title="멘토링" class="lnb-dep1"></a>
                    </li>
                    <li>
                        <a href="#" title="게시판" class="lnb-dep1"></a>
                    </li>
                    <li>
                        <a href="#" title="관리자 메뉴" class="lnb-dep1"></a>
                    </li>
                </ul>
            </div>
        </div>
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