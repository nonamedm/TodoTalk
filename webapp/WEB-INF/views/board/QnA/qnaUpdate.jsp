<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
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

<form action="/board/QnA/qnaUpdate" method="post">
<table>
<h2>QnA Update</h2>
 
 <tr>
 	<td>글번호: ${qnaBoardVo.qna_idx}</td>
 	<input type="hidden" name="qna_idx" value="${qnaBoardVo.qna_idx}" />
 	<td>제목  <input type="text" name="qna_title"/></td>
 	<td>작성자: ${user_id}<input type="hidden" name="user_id" value="${user_id}"/></td>
 </tr>
 <tr>
 	<td>내용</td>
 	<td colspan="4"><textarea name="qna_cont" rows="30" cols="80"></textarea> </td>
 </tr>
 
 <input type="submit" value="확인" />
 <a href="/board/QnA/qnaList"> 목록 </a>

</table>
</form>



</body>
</html>