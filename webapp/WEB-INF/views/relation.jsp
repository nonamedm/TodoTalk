<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멘토신청 페이지</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/css/import.css" />
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
	<script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/script.js"></script>
    <script src="/js/TweenMax.min.js"></script>
    <script src="/js/common.js"></script>
<style></style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){

	});
</script>
</head>
<body>
<%@include file="popup/translation.jsp"%>
<!-- 드래그 했을때 뜨는 번역하기 버튼 html -->
<div id="translationTxt" class="translation-txt">
   	<a href="javascript:translationTxt()" title="번역" id="btnTranslation">번역하기</a>
</div>
<div class = "talbe-wrap">
    <table class = "table-type02">
        <tbody>
        <tr><th colspan="2">${ receiver.user_name } (${ receiver.user_id }) 님에게 멘토를 신청합니다.</th>
        </tr>   
        <tr>
        <td rowspan="3" style="width:20%">
        <c:choose>
			<c:when test="${empty img.photo_name}"> 
                <img src="img/common/user-img3.png" alt="사용자 이미지" style="width: 80%;"> 
			</c:when>
      		<c:otherwise>
            	<img src="/image/${img.photo_name}" alt="사용자 이미지" style="width: 80%;">
      		</c:otherwise>
        </c:choose>
        </td>
        <td>이름 : ${receiver.user_name }</td></tr>
		<tr><td>국적 : ${receiver.country }</td></tr>
		<tr><td>인사말 : ${receiver.introduce }</td></tr>
        <tr><th colspan="2">
        <form action="/relationCreate" method="POST">
	        <input type="hidden" name="require_id" value="${ require_id }" />
	        <input type="hidden" name="require_name" value="${ require_name }" />
	        <input type="hidden" name="receiver_id" value="${ receiver.user_id }" />
	        <input type="hidden" name="receiver_name" value="${ receiver.user_name }" />
        	<input type="submit" value="확인">
       		<input type="button" value="취소" onclick="window.close()"/>
        </form>
        </th>
         </tr>
        </tbody>
    </table>
</div>
</body>
</html>