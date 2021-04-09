<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>    
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="../layout/header.jsp"%>

<script>
   $(function() {
	  $('input[type=button]').on('click', function(event) {
		  var btn = event.target;
		  var href = '';
		  switch( btn.id ) {
		  case 'btnUpdate':
			  var  idx =  '${ tuboVo.tubo_idx }';
			  href     = '/tutoringwrite/update?tubo_title=${tuboVo.tubo_title}&idx=' + idx;
		  	  break;
		  case 'btnDelete':
			  var  idx =  '${ tuboVo.tubo_idx }';
			  href 	   = '/tutoringwrite/delete?&idx=' + idx;
			  break;
		  }
		  //alert(href);
		  location.href = href;
		  
	  })
   });
</script>
    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2">
                <!--여기부터 컨텐츠내용 작업시작-->
         

		  <table> 
		    <tr>
		      <td class="td1">글쓴이</td>
		      <td class="td2">${ tuboVo.user_id }</td>   
		    </tr>    
		    <tr>
		      <td class="td1">주제</td>
		      <td class="td5" colspan="3">${ tuboVo.tubo_title }</td>
		    </tr>
		    <tr>
		      <td class="td1">내용</td>
		      <td class="td5" id="cont" colspan="3">${ tuboVo.tubo_cont }</td>
		    </tr>  
		    <tr>
		      <td class="td3">날짜</td>
		      <td class="td4">${ tuboVo.tubo_regdate }</td>
		    </tr>    
		    <tr>
		      <td colspan="4">
		       <input type="button" value="글수정"    id="btnUpdate"/>
		       <input type="button" value="글삭제"    id="btnDelete"/>
		      </td>
		    </tr>
		  </table>

   
				<!--여기부터 컨텐츠내용 작업 끝-->
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