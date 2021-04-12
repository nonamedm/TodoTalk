<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
                
                
<form action="/write"  method="post">
<table>
 <h2>글쓰기</h2>

  <tr>
    <td>글제목</td>
    <td><input type="text" name="free_title" /></td>
  </tr>
  <tr>
    <td>작성자</td>
    <td>${ board.user_id }</td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><textarea name="free_cont" cols="50" rows="100"></textarea></td>
  </tr>
	<input type="submit" value="확인" />
</table>
</form>
</body>
</html>