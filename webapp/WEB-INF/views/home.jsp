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
        $(function() {
            $(".sub_pop1").css({"background":"#00a2ff", "color":"#fff", "font-weight":"900"});
            $("#menu1").on('click',function(){
                $("#sub_pa_pop_1").show();
                $("#sub_pa_pop_2").hide();
                $(".sub_pop1").css({"background":"#00a2ff", "color":"#fff", "font-weight":"900"});
                $(".sub_pop2").css({"background":"#fff", "color":"#333", "font-weight":"500"});
            });
            
            $("#menu2").on('click',function(){
                $("#sub_pa_pop_2").show();
                $("#sub_pa_pop_1").hide();
                $(".sub_pop2").css({"background":"#00a2ff", "color":"#fff", "font-weight":"900"});
                $(".sub_pop1").css({"background":"#fff", "color":"#333", "font-weight":"500"});
            });
        })

        

    </script>
</head>

<body>
    <div class="sub-main-wrap">
        <div class="lnb-wrap">
            <div class="lnb-top-cont">
                <h1><a href="/" title="홈으로가기"><img src="img/common/logo.png" alt="홈바로가기"></a></h1>
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
                    <!--<h1>H-Smart 인사관리시스템</h1>-->
                </div>
                <div class="common-box">
                    <div class="search-input">
                        <input type="text" placeholder="통합검색">
                        <a href="#" title="검색" class="btn-search2"></a>
                    </div>
                    <div class="user-wrap">
                        <div class="user-img">
                            <a href="#" title="사용자 정보 더보기" class="user-open">
                                <img src="img/common/user-img.png" alt="사용자 이미지">
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
            <div class="middle-content-wrap">
                <!--여기부터 컨텐츠내용 작업시작-->

                <div id="contents">
                    <div class="section main">
                        <div class="bg_motion">
                            <div class="bg_box">
                                <div class="bg1 bg on"></div>
                                <div class="bg2 bg"></div>
                                <div class="bg3 bg"></div>
                                <!--<div class="bg4 bg"></div>-->
                            </div>
                        </div>
                        <div class="letter_motion">
                            <div class="letter_box eng active"></div>
                            <div class="letter_box eng"></div>
                            <div class="letter_box eng"></div>
                        </div>
                        <div class="main_navi">
                            <ul class="inmotion">
                                <li><a class="eng" href="#"></a></li>
                                <li><a class="eng" href="#"></a></li>
                                <li><a class="eng" href="#"></a></li>
                            </ul>
                        </div>

                    </div>
                </div>
                <script src="js/common.js"></script>
                <script src="js/main.js"></script>

                <div class="sub-contents">
                    <div class="tabs">
                        <div id="pro_cap_btns">
                            <ul>
                                <li onClick="sub_pop(1);" id="menu1" class="sub_pop1">공지사항</li>
                                <li onClick="sub_pop(2);" id="menu2" class="sub_pop2">커뮤니티</li>
                            </ul>
                        </div>

                        <div id="sub_pa_pop_1">
                            <div class="">
                                <div class="">
                                    <ul>
                                        <li class="">메인페이지 공지사항입니다.</li>
                                        <span class="regdate">2021-04-02</span>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="sub_pa_pop_2">
                            <div class="">
                                <div class="">
                                    <ul>
                                        <li class="">메인페이지 커뮤니티입니다.</li>
                                        <span class="regdate">2021-04-02</span>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="width: 55%; height: 300px; background: #00a2ff; margin-top: 49px;">
                        추천멘트및강의 프로그램 목록(광고 또는 별점순)
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
    <!--//sub-main-wrap-->
</body>

</html>