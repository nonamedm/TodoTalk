<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
 $(function() {
		$('form').on('submit',function(){
			if ($('#comm_title').val()==' ') {
				alert('제목을 입력하세요');
				 $('#comm_title').focus();
				return false;
			}
			
		})
		
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



 <form action="/board/comm/commUpdate" method="post">
<table>
 <h2>글수정</h2>
 	<tr>
		<td>글번호</td>
		<td>${ cList.comm_idx}</td>
		<td><input type="hidden" name="comm_idx" value="${ cList.comm_idx}" /></td>
 	<tr>
		<td>작성자</td>
		<td>${ cList.user_id}</td>
	</tr>
  <tr>
    <td>글제목</td>
    <td><input type="text" name="comm_title" id="comm_title"/></td>
  </tr>
  <tr>
    <td>글내용</td>
    <td><textarea name="comm_cont" id="comm_title" cols="100" rows="50"></textarea></td>
  </tr>
	<input type="submit" value="수정" />
</table>
</form>
</body>
</html>