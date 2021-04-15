<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
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

<table>
<h2>QnA Read</h2>
	 <tr>
	 	<td>글번호</td>
	 	<td>${read.qna_idx }</td>
	 	<td>작성자</td>
	 	<td>${qnaBoardVo.user_id}</td>

	 </tr>
 	 <tr>
	 	<td>작성일</td>
	 	<td>${qnaBoardVo.qna_regdate}</td>
	 	<td>조회수</td>
	 	<td>${qnaBoardVo.qna_readcount}</td>
	 </tr> 
	 <tr>
	 	<td>제  목</td>
	 	<td  colspan="3" >${qnaBoardVo.qna_title}</td>
	 </tr>
	 <tr>	
	 	<td>글 내용</td>
	 	<td colspan="3" >${qnaBoardVo.qna_cont}</td>
	</tr>
	
	<tr>
	 <a href="/board/QnA/qnaList"> 목록 </a>
	 <a href="/board/QnA/delete?qna_idx=${read.qna_idx}"> 삭제 </a>
	 <a href="/board/QnA/updateForm?qna_idx=${read.qna_idx}"> 수정 </a>
	 <a href="/board/QnA/qnaWriteForm"> 글쓰기 </a>
	</tr>
</table>

</body>
</html>