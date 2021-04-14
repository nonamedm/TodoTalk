<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
<style>
</style>
</head>
<body>
<table>
  <h2>커뮤 read</h2>
     <tr>
     	<td>글번호</td>
     	<td>${ commBoardVo.comm_idx }</td>
     	<td>글제목</td>
     	<td>:${ commBoardVo.comm_title }</td>
     	<td>글내용</td>
     	<td>${ commBoardVo.comm_cont }</td>
     	<td>작성자</td>
     	<td>${ commBoardVo.user_id }</td>
     	<td>작성일</td>
     	<td>${ commBoardVo.comm_regdate }</td>
     	<td>조회수</td>
     	<td>${ commBoardVo.comm_readcount }</td>      
     </tr>

      <tr>
      </br>
      <td class="tdfile">파일</td> 
      
		<c:forEach var="file" items="${ filesList }" >
          <div> 
          <a href=" <c:out value="${ file.file_name}" />" > 
          <c:out value="${ file.file_name}" />
            ${ file.file_name }
         </a>  
          </div>
       </c:forEach> 
       
         
      </tr>
     </ul>
    </tr>
     <a href="/board/comm/commList" >목록</a>
     <a href="/board/comm/delete?comm_idx=${ commBoardVo.comm_idx }" >삭제</a>
     <a href="/board/comm/commUpdateForm?comm_idx=${ commBoardVo.comm_idx }" >수정</a>
     <a href="/board/comm/WriteForm" >글쓰기</a>

</table>
</body>
</html>