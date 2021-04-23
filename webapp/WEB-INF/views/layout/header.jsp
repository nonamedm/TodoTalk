<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todotalk</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/css/import.css" />
    
    <!-- calendar를 위한 css 지우면 안됨 -->
    <link rel="stylesheet" type="text/css" href="/css/fullCalendar.css" />
    
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/script.js"></script>
    <script src="/js/TweenMax.min.js"></script>
    <script src="/js/common.js"></script>
    

</head>
    
<body>
<script>
$(function(){
	$("#getText").keyup(function(){
		
		$.ajax({
			url : '/srcLangText',
			type : 'POST',
			data : {
				srcLangText : $("#getText").val()
			},
			success : function(data){
				console.log(data.resultData2);
				var srcLangText = data.resultData2;
				$("#srcLangText").val(srcLangText);
				var srcOption = $(".languages-box option").val();
			},
			error : function(xhr){
				alert(xhr.status + ", " + xhr.statusText);
			}
		});
	});
});
	//여기서 부터 번역기능 스크립트
	//::드래그한 값 가져오기
	function selectText(){
		var selectionText = "";
		if(document.getSelection){
			selectionText = document.getSelection();
		}else if(document.selection){
			selectionText = document.selection.createRange().text;
		}
		return selectionText;
	}
	
	//커서의 왼쪽이 누르고땟을때 
	document.onmouseup = function(event){
		//드래그한 값이 빈값이면 실행 중지
		if(selectText() == ""){
			$("#translationTxt").hide();
			return false;
		}else{
			var x = event.pageX;
			var y = event.pageY;
			$("#translationTxt").show();
			$("#translationTxt").css({"position":"absolute", "left": x+"px", "top": y+-40+"px"});
		}
	}
	
	function translationTxt(){
		$("#translationTxt").hide();
		$("#translation-wrap").show();
		$("#getText").val(selectText());
		$("#getText").focus();
		
		var getText = $("#getText").val();
		if(getText != ""){
			srcLangText();
		}
	}
	
	
	//번역글 보내기
	function translationSend(){
		var langOption1 = $("#srcLangText").val();
		var langOption2 = $(".languages-box2").val();
		
		if(langOption1 == langOption2){
			alert("번역할 언어를 변경해주십시오.");
			$(".languages-box2").focus();
			return false;
		}
		
		$.ajax({
			url : '/translatorText',
			type : 'POST',
			data : {
				srcLanguage : $("#srcLangText").val(),
				getText  : $("#getText").val(),
				tarLanguage : $(".languages-box2 option:selected").val()
			},
			success : function(data){
				var tarLanguage = data.resultData;
				$("#tarText").html(tarLanguage);
			},
			error : function(xhr){
				alert(xhr.status + ", " + xhr.statusText);
			}
		})
	}
	
	//자동언어감지 스크립트
	function srcLangText(){
		$.ajax({
			url : '/srcLangText',
			type : 'POST',
			data : {
				srcLangText : $("#getText").val()
			},
			success : function(data){
				console.log(data.resultData2);
				var srcLangText = data.resultData2;
				$("#srcLangText").val(srcLangText);
				var srcOption = $(".languages-box option").val();
			},
			error : function(xhr){
				alert(xhr.status + ", " + xhr.statusText);
			}
		});
	}//여기까지가 번역기능 스크립트 끝
</script>
        <%@include file="../popup/translation.jsp"%>
		<!-- 드래그 했을때 뜨는 번역하기 버튼 html -->
    	<div id="translationTxt" class="translation-txt">
        	<a href="javascript:translationTxt()" title="번역" id="btnTranslation">번역하기</a>
        </div>
        