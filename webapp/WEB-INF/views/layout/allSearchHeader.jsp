<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(function () {
		$('#btn-search2').on('click',function(){
			var searchText = $('#search2-Text').val();
			searchText1 = encodeURI(searchText);	// 한글 인코딩
			//alert(searchText); //검색값+버튼액션 확인
			var url = '/AllSearch?query='+searchText1;
			$(location).attr('href',url);
		});
		
	});
</script>
<div class="header-wrap">
                <div class="header-title">
                    <!--<h1>H-Smart 인사관리시스템</h1>-->
                </div>
                <div class="common-box">
                    <div class="search-input">
                        <input type="text" placeholder="통합검색" id='search2-Text'>
                        <a href="#" title="검색" class="btn-search2" id="btn-search2"></a>
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