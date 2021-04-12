<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->



  <h2>read</h2>
 
     <ul>
       <li>글 번호 :${ board.free_idx }</li>
       <li>글 제목 :${ board.free_title } </li>
       <li>글 내용 :${ board.free_cont }</li>
       <li>작성자 : ${ board.user_id }</li>
       <li>작성일 : ${ board.free_regdate }</li>
       <li>조회수 : ${ board.free_readcount }</li>
     </ul>
     <a href="/list" >목록</a>
     <a href="/delete?idx=${ board.free_idx}" >삭제</a>
     <a href="/updateForm?idx=${ board.free_idx}" >수정</a>
     <a href="/writeForm" >글쓰기</a>

</body>
</html>