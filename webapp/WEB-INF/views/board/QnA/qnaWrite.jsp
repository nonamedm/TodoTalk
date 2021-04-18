<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<style>
table,td {border:2px solid DarkOrchid; 
 	   border-collapse:collapse; 
}
 th,td {padding:10px;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(function() {
	   // btnAdd Click 	
	   var  num = 1;
	   $('#btnAddFile').on('click', function() {
	   //alert('Click');    	   
	   var html  = '<input type="file"';
	   html     += ' name = "file_name' + num + '"';
	   html     += ' id   = "file_name' + num + '"';
	   html     += ' /><br>';
	   $('#tdfile').append( html );
	   num      += 1;
 });	
	
	
})
</script>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->


<form action="/board/QnA/qnaWrite?"  method="POST"  enctype="multipart/form-data" >

<%-- 
   <input type="hidden" name="qna_idx" value="${map.qna_idx}"/>
   <input type="hidden" name="bnum"        value="${ map.bnum }" />     
   <input type="hidden" name="lvl"         value="${ map.lvl }" />     
   <input type="hidden" name="step"        value="${ map.step }" />     
   <input type="hidden" name="nref"        value="${ map.nref }" />     
   <input type="hidden" name="nowpage"     value="${ map.nowpage }" />     
   <input type="hidden" name="pagecount"   value="${ map.pagecount }" />     
   <input type="hidden" name="pagegrpnum"  value="${ map.pagegrpnum }" />     
 --%>
 
<table>
<h2>QnA Write</h2>
 <tr>
 	<td>제목</td>
 	<td><input type="text" name="qna_title"/></td>
 	<td>작성자: ${user_id}<input type="hidden" name="user_id"  value="${user_id}"/></td>
 </tr>
 <tr>
 	<td>내용</td>
 	<td colspan="2"><textarea name="qna_cont" rows="30" cols="80"></textarea> </td>
 </tr>
 <tr>
	<td>파일</td>
	<td id="tdfile" colspan="2">
		<input type="button" id="btnAddFile" value="Add file" />
		<input type="file" name="file_name" id="file_name" />
	</td>
 </tr>
	
 <td colspan="4">
	 <input type="submit" value="확인" />
	 <a href="/board/QnA/qnaList"> 목록 </a>
	 <a href="/#"> 홈으로 </a>
 </td>

</table>
</form>
</body>
</html>