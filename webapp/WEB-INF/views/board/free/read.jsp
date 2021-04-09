<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
</head>
<body>
  <h2>read</h2>
 
     <ul>
       <li>글 번호 :${ board.free_idx }</li>
       <li>글 제목 :${ board.free_title } </li>
       <li>글 내용 :${ board.free_cont }</li>
       <li>작성자 : ${ board.user_id }</li>
       <li>작성일 : ${ board.free_regdate }</li>
       <li>조회수 : ${ board.free_readcount }</li>
     </ul>
     <a href="/delete?idx=${ board.free_idx}"" >삭제</a>

</body>
</html>