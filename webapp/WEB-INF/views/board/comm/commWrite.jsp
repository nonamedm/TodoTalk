<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
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
    
/*     // submit click
    $('#form1').on('submit', function() {
 	   // 작성자 입력? db writer : not null
 	   if ( $('#writer').val() == '') {
 		   alert('작성자를 입력하세요');
 		   $('#writer').focus();
 		   return false;   // submit 이벤트를 중지
 	   } 		   
 	   // 제목   입력? db title : not null
 	   if ( $('#title').val() == '') {
 		   alert('제목을 입력하세요');
 		   $('#title').focus();
 		   return false;   // submit 이벤트를 중지
 	   } 			   
 	   // 내용   입력? db cont  : not null
 	    if ( $('#cont').val() == '') {
 		   alert('내용을 입력하세요');
 		   $('#cont').focus();
 		   return false;   // submit 이벤트를 중지
 	   } 	
 	   
	       return true;
    }); */
    
    
});
</script>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
                
<!-- form 안에 enctype="multipart/form-data" -->                
<form action="/board/comm/commWrite"  method="post"  enctype="multipart/form-data">
<table>
 <h2>소통 커뮤 글쓰기</h2>

  <tr>
    <td>글제목</td>
    <td><input type="text" name="comm_title" /></td>
  </tr>
  <tr>
    <td>작성자</td>
    <td>${ cList.user_id}</td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><textarea name="comm_cont" cols="50" rows="100"></textarea></td>
  </tr>
  <tr>
      <td>파일</td>
      <td id="tdfile">
        <input type="button" id="btnAddFile" value="Add file" /><br>
        <input type="file" name="file_name" id="file_name" /><br>        
      </td>
    </tr> 
	<input type="submit" value="확인" />
</table>
</form>
</body>
</html>