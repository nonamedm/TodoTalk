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
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->


<form action="/board/QnA/qnaWrite">
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
 
 <input type="submit" value="확인" />
 <a href="/board/QnA/qnaList"> 목록 </a>
 <a href="/#"> 홈으로 </a>
 
<!--  페이징 -->

</table>
</form>
</body>
</html>