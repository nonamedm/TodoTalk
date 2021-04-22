<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<style>
table,td {border:2px solid DarkOrchid; border-collapse:collapse; }
 th,td {padding:10px;}
</style>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
                
<!--  파일 업로드때 필요 enctype="multipart/form-data"    -->             
<form action="/board/free/freeWrite"  method="post" enctype="multipart/form-data" >
<table>
 <h2>글쓰기</h2>
 
  <tr>
 	<td>제목</td>
 	<td><input type="text" name="free_title"/></td>
 	<td>작성자: ${user_id}<input type="hidden" name="user_id"  value="${user_id}"/></td>
 </tr>
 <tr>
 	<td>내용</td>
 	<td colspan="2"><textarea name="free_cont" rows="30" cols="80"></textarea> </td>
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
	 <a href="/board/free/freeList"> 목록 </a>
	 <a href="/#"> 홈으로 </a>
 </td>

 
</table>
</form>
</body>
</html>