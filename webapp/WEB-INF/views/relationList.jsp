<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<head>
    <title>내 멘토멘티 목록</title>
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
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<%@include file="popup/translation.jsp"%>
<!-- 드래그 했을때 뜨는 번역하기 버튼 html -->
<div id="translationTxt" class="translation-txt">
   	<a href="javascript:translationTxt()" title="번역" id="btnTranslation">번역하기</a>
</div>
<div class = "talbe-wrap">
    <table class = "table-type02" id="requireList">
        <div class="chat-header"><h4>${loginId } 님의 멘토요청 목록</h4></div> <hr>
        <tbody>
        	<c:choose>
        	<c:when test="${empty relationRequire}">
        	<tr><th>멘토 신청을 모두 수락하셨습니다</th></tr>
        	</c:when>
        	<c:otherwise>
	        	<c:forEach var="require" items="${ relationRequire }">
	        	<tr><th>신청자 : ${ require.require_name }(${require.require_id })</th>
	        	<th><a onclick="permit('${require.require_id }')">승인</a></th>
	        	</tr>
	        	</c:forEach>
        	</c:otherwise>
        	</c:choose>
        </tbody>
     </table>
     <table class = "table-type02">
        <div class="chat-header"><h4>${loginId } 님의 멘티 목록</h4></div> <hr>	
        	<c:forEach var="list" items="${ relationList }">
        	<tr><th>이름 : ${ list.require_name }(${ list.require_id })</th>
        	<th>구분 : 멘티</th>
        	</tr>
        	</c:forEach>
        </tbody>
    </table>
     <table class = "table-type02">
        <div class="chat-header"><h4>${loginId } 님의 멘토 목록</h4></div> <hr>	
        	<c:forEach var="list2" items="${ relationList2 }">
        	<tr><th>이름 : ${ list2.receiver_name }(${ list2.receiver_id })</th>
        	<th>구분 : 멘토</th>
        	</tr>
        	</c:forEach>
        </tbody>
    </table>
</div>
</body>
<script>
	function permit (require_id) {
		var receiver_id = '${ loginId }';
		//alert(require_id+receiver_id);
		//var url = '/permitRelation?require_id='+require_id+'&receiver_id='+receiver_id;
		var url = '/permitRelation';
		$.ajax ({
			url : url,
			data : {require_id : require_id, receiver_id : receiver_id},
			type : 'POST',
			success : function () {
				alert('승인이 완료되었습니다!');
				var redirect = '/relationList?loginId='+receiver_id;
				$(location).attr('href',redirect);
			},
			error : function (xhr) {
				
			}
		});
	}
</script>
</html>