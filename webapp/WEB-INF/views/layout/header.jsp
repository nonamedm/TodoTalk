<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/script.js"></script>
    <script src="/js/TweenMax.min.js"></script>
    <script>
        $(function() {
            $(".sub_pop1").css({"background":"#00a2ff", "color":"#fff", "font-weight":"900"});
            $("#menu1").on('click',function(){
                $("#sub_pa_pop_1").show();
                $("#sub_pa_pop_2").hide();
                $(".sub_pop1").css({"background":"#00a2ff", "color":"#fff", "font-weight":"900"});
                $(".sub_pop2").css({"background":"#fff", "color":"#333", "font-weight":"500"});
            });
            
            $("#menu2").on('click',function(){
                $("#sub_pa_pop_2").show();
                $("#sub_pa_pop_1").hide();
                $(".sub_pop2").css({"background":"#00a2ff", "color":"#fff", "font-weight":"900"});
                $(".sub_pop1").css({"background":"#fff", "color":"#333", "font-weight":"500"});
            });
        })
    </script>
</head>
<body>