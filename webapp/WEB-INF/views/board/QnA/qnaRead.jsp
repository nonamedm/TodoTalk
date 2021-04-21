<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
<style>
table,td {border:2px solid DarkOrchid; border-collapse:collapse; }
th,td {padding:10px;}
</style>

<script>


</script>

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
	 <a href="/board/QnA/qnaList"> 목록 </a>
	 <a href="/board/QnA/delete?qna_idx=${map.qna_idx}"> 삭제 </a>
	 <a href="/board/QnA/updateForm?qna_idx=${map.qna_idx}"> 수정 </a>
	 <a href="/board/QnA/qnaWriteForm"> 글쓰기 </a>
	</tr>
	 <tr>
	 	<td>글번호</td>
	 	<td>${map.qna_idx }</td>
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
	    <td class="tdfile" colspan="1">파일</td> 
          <td colspan="3"> 
          
			<c:forEach var="file" items="${ filesList }" >
	          <a href=" <c:out value="${ file.file_name}" />" > 
		          ★파일번호: <c:out value="${ file.file_idx}" /><br>
		          ★파일이름: <c:out value="${ file.file_name}" />
	          </a>  
      		 </c:forEach> 
      		 
          </td>
	</tr>
</table><br>

	<!-- 댓글 -->
<table>
	<tr>
		<td>댓글 목록</td>
	</tr>
	<tr>
		<td>
			<c:forEach var="list" items="${ repList }" >
	         <c:out value="${list.qna_re_cont}" /><br> 
      		</c:forEach> 
		</td>
	</tr>	
</table><br>
	

<form action="/board/QnA/repWrite"  method="POST">
<table>
	<tr>
 		<td>댓글쓰기</td>
	 	<input type="hidden" name="qna_idx" value="${map.qna_idx}"/>
 		<td>
			작성자: ${user_id}<input type="hidden" name="user_id"  value="${user_id}"/>
	 		<textarea name="qna_re_cont" rows="5" cols="15"></textarea> 
 		</td>
 		<td><input type="submit" value="댓글쓰기"/></td>
	</tr>
</table>
</form>	


</body>
</html>


