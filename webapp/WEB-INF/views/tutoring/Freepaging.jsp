<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 



 <div>
	<ul>
	  <c:if test="${pageMaker.prev}">
	    	<a href="<c:url value='/tutoringwrite?page=${pageMaker.startPage-1}'/>" title="이전"><img src="/img/sub/btn-prev.png" alt="이전"></a>
	  </c:if>
	  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">

	    	<a href="<c:url value='/tutoringwrite?page=${pageNum}'/>" title="더보기">${pageNum}</a>

	  </c:forEach>
	  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">

	    	<a href="/tutoringwrite?page=${pageMaker.endPage+1}" title="다음"><img src="/img/sub/btn-next.png" alt="다음"></a>

	  </c:if>
	</ul>
</div>