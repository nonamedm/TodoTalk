<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<c:set  var="showprev"      value="${ pagePdsVo.isshowpageprev }" />
	<c:set  var="shownext"      value="${ pagePdsVo.isshowpagenext }" /> 
	
	<c:set  var="startnum"      value="${ pagePdsVo.pagestartnum }" />
	<c:set  var="endnum"        value="${ pagePdsVo.pageendnum   }" />
	<c:set  var="pagegrpnum"    value="${ pagePdsVo.pagegrpnum   }" />
	
	<c:set  var="totalcount"      value="${ pagePdsVo.totalcount   }" />
	<c:set  var="pagecount"       value="${ pagePdsVo.pagecount   }" />
	<c:set  var="totalpagecount"  value="${ pagePdsVo.totalpagecount  }" />
	
	<c:set  var="nowpage"         value="${ pagePdsVo.nowpage   }" />
	<c:set  var="prevnowpage"     value="${ pagePdsVo.prevnowpage   }" />
	<c:set  var="nextnowpage"     value="${ pagePdsVo.nextnowpage   }" />
	


<div>
  <table>
    <tr>
     <td>
              
       <c:if test="${showprev eq true}">
        <a href="/board/QnA/qnaList?nowpage=${prevnowpage}&pagecount=${pagecount}&pagegrpnum=${pagegrpnum-1}">
         ◀  [이전 ${ totalpagecount }개]</a>
       </c:if>
       
       <!-- 1 2 3 4 5 6 7 8 9 10 -->
       <c:forEach  var="pagenum" begin="${startnum}" end="${endnum}" step="1" >
       <a href="/board/QnA/qnaList?nowpage=${pagenum}&pagecount=${pagecount}&pagegrpnum=${pagegrpnum}">
          ${ pagenum } &nbsp;&nbsp;
       </a>
       </c:forEach>    
       
       <c:if test="${ shownext eq true }">
        <a href="/board/QnA/qnaList?nowpage=${nextnowpage}&pagecount=${pagecount}&pagegrpnum=${pagegrpnum+1}">
         [다음 ${ totalpagecount }개] ▶</a>
       </c:if>
       
     
     </td>
    </tr>
  </table>
</div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    