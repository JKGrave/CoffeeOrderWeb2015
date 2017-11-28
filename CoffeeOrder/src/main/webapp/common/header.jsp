<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
	
	setInterval("dpTime()",1000);
	function dpTime(){
	   var now = new Date();
	    hours = now.getHours();
	    minutes = now.getMinutes();
	    seconds = now.getSeconds();
	
	    if (hours >= 12 && hours < 24){
	    	if(hours != 12){
	    		hours -= 12;
	    	}
	    	ampm = "오후 ";
	    }else{
	    	if(hours == 24){
	    		hours = 0;
	    	}
	        ampm = "오전 ";
	    }
	    if (hours < 10){
	        hours = "0" + hours;
	    }
	    if (minutes < 10){
	        minutes = "0" + minutes;
	    }
	    if (seconds < 10){
	        seconds = "0" + seconds;
	    }
	document.getElementById("dpTime").innerHTML = ampm + hours + ":" + minutes + ":" + seconds;
	}
	
	
</script>

<div id="header"><a href="${ctx}/main.do"><img src="${ctx}/style/img/font.png" class="top"></a>
<span id="headerText">${loginStoreName}&nbsp;&nbsp;
<span id="dpTime">${thisTime}</span></span>
</div>
