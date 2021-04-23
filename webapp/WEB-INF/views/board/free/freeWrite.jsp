<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
    <div class="sub-main-wrap">
        <%@include file="/WEB-INF/views/layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="/WEB-INF/views/layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 mentorMenteePage">
                <!--여기부터 컨텐츠내용 작업시작-->
                
<!--  파일 업로드때 필요 enctype="multipart/form-data"    -->             

<div class="container" >
	<div class="row">
      <div class="col-md-6 col-md-offset-3">
            <h2 class="text-center">자유 게시판 글쓰기</h2>
        <div class="well well-sm">
			
          <form action="/board/free/freeWrite"  method="post" enctype="multipart/form-data" >
          <fieldset>
    
            <div class="form-group">
              <label class="col-md-3 control-label" for="name">글 제목</label>
              <div class="col-md-9">
                <input id="name" name="free_title" type="text" placeholder="제목을 입력하세요 " class="form-control" >
				<input type="hidden" name="user_id"  value="${user_id}"/>
              </div>
            </div>
    
            <div class="form-group">
              <label class="col-md-3 control-label" for="message">글 내용 </label>
              <div class="col-md-9">
                <textarea class="form-control" id="message" name="free_cont" placeholder="글 내용 입력 " rows="30" cols="100"></textarea>
              </div>
            </div>
			     
            <div class="form-group">
              <label class="col-md-3 control-label" for="email">파일 추가</label>
              <div class="col-md-9">
				<input type="file" name="file_name" id="file_name" />
              </div>
            </div>
    
            <div class="form-group">
              <div class="col-md-12 text-right">
                <input type="submit" value="확인"  class="btn btn-primary btn-lg" />
				  <a href="/board/free/freeList"  class="btn btn-primary btn-lg"> 목록 </a>
	 			  <a href="/#" class="btn btn-primary btn-lg"> 홈으로 </a> 
              </div>
            </div>
          </fieldset>
          </form>
			
        </div>
      </div>
	</div>
</div>

</body>
</html>