<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<script>
	$(function(){
		
		//인풋창에서 Enter치면 mentorSearch 메소드 실행
		$("#mentorSearch").keydown(function(key){
			if(key.keyCode == 13){
				mentorSearch();
			}
		})
	});
	
	function mentorSearch(){
		alert("검색");
		$.ajax({
			url : '',
			type : 'POST',
			data : {
				mentorSearch : $("#mentorSearch").val() 
			},
			success : function(){
				
			},
			error : function(xhr){
				alert(xhr.status + ", " + xhr.statusText);
			}
		})
	}
</script>
    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
               	<div class="search-box">
               		<input type="text" id="mentorSearch" name="mentorSearch" class="mentor-search" placeholder="멘토 검색">
               		<a href="javascript:mentorSearch()" title="검색" class="btn-search3"></a>
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