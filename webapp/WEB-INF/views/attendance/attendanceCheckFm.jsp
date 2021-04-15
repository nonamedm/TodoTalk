<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
    <!-- FullCalendar를 위한 라이브러리들 지우면 안됨 -->
 	<script src="/js/fullCalendar/main.js"></script>
	<script src="/js/fullCalendar/locales-all.js"></script>

<script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	headerToolbar: {
        		  start: "today",
        		  center: "prev title next",
        		  end: "custom2",
        	},
        	titleFormat : function(date) { // title 한글 설정
        		  return date.date.year +"년 "+(date.date.month +1)+"월"; 
        	} ,
        	contentHeight: 650,
        	fixedWeekCount: false,
        	showNonCurrentDates : false,
        	// 한글로 표시
        	dayHeaderContent: function (date) {
        	  let weekList = ["일", "월", "화", "수", "목", "금", "토"];
        	  return weekList[date.dow];
        	},
        	dateClick: function (dateClickInfo) {
        		  const fcDayElements = document.querySelectorAll(
        		    ".fc-daygrid-day.fc-day"
        		  );
        		  fcDayElements.forEach((element, key, parent) => {
        		    element.style.backgroundColor = "";
        		  });
        		  //선택한 날짜 div 컬러 변경
        		  dateClickInfo.dayEl.style.backgroundColor = "#787878";
        	},
    		customButtons: { 
    	        custom2: {
    	          text: '출석체크하기',
    	          id: 'check',
    	          click: function() {
                      var now = new Date();
                      var year  = now.getFullYear();
                      var month = ("00"+(now.getMonth()+1)).slice(-2);
                      var day   = now.getDate();
                      var today = year+"-"+month+"-"+day;
    	        	  alert($("#attendanceCheck_userid").val());
    	        	  $.ajax({
    	        		  url : '',
    	        		  type : 'POST',
    	        		  data : {
    	        			  userid : $("#attendanceCheck_userid").val(),
    	        			  today  : today
    	        		  },
    	        		  success : function (result){
    	        			  
    	        		  },
    	        		  error : function (xhr){
    	        			  
    	        		  }
    	        	  });
                      
    	          }
    	        }
    	    },
    	    events: [
                {
                    title : "All Day Event"
                  , start : "2021-04-01"
              },
			]
        });
        calendar.render();
      });

    </script>

    <div class="sub-main-wrap">
        <%@include file="../layout/leftMenu.jsp"%>
        <div class="sub-container-wrap">
            <%@include file="../layout/allSearchHeader.jsp"%>
            <div class="middle-content-wrap2 attendanceCheck">
                <!--여기부터 컨텐츠내용 작업시작-->
                <input type="hidden" id="attendanceCheck_userid" value="${user_id}">
				<div id="calendar" style="margin:40px auto;"></div>
				
            </div>
            <footer>
                <div class="sub-footer">
                    <p></p>
                    <p>시스템관리자</p>
                    <p>todotalk@gmail.com <span class="red fs13">(수정할 수 없는 항목에 오류가 있는 경우는 시스템 관리사에게 해당메일로 수정 요청을 해주시기 바랍니다.)</span></p>
                </div>
            </footer>
        </div>
        <!--//sub-container-wrap-->
    </div>
    <!--//sub-main-wrap-->
</body>

</html>