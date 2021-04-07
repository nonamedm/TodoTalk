<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="layout/header.jsp"%>
    <div class="sub-main-wrap">
    	<%@include file="layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="layout/allSearchHeader.jsp"%>
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