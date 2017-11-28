<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" >
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/header.css"/>
<title>수익관리</title>
<script type="text/javascript">
	function dayProfit(){
		location.href='${ctx}/order/dayProfit.do'
	}
	function monthProfit(){
		location.href='${ctx}/order/monthProfit.do'
	}
	function yearProfit(){
		location.href='${ctx}/order/yearProfit.do'
	}
</script>
</head>
<body>
	<jsp:include page="/common/header.jsp"/>
	<jsp:include page="/common/menu.jsp"/>
	<div id="Index">
	<div class="contents-wrap-div">
	<div class="page-header">
  		<h1>수익관리<small>&nbsp;수익현황</small></h1>
	</div>
	<div id="table-width">
	<input <c:if test="${inputValue==1}">class="btn btn-default active"</c:if>class="btn btn-default" type="button" value="오늘매출" onclick="dayProfit();"/>
	<input <c:if test="${inputValue==2}">class="btn btn-default active"</c:if>class="btn btn-default" type="button" value="이번달매출" onclick="monthProfit();"/>
	<input <c:if test="${inputValue==3}">class="btn btn-default active"</c:if>class="btn btn-default" type="button" value="올해매출" onclick="yearProfit();"/>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>종류</th>
				<th>판매잔수</th>
				<th>판매금액</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="profit" items="${profits}">
				<tr>
					<td class="formCenter">${profit.name}</td>
					<td class="formCenter">${profit.sellCount} 잔</td>
					<td class="formCenter">${profit.profit}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" class="text">총 수익 :&nbsp;&nbsp;<strong>${totalProfit}</strong>원</td>
		</tbody>
	</table>
	</div>
	</div>
	</div>
	<jsp:include page="/common/footer.jsp"/>
</body>
</html>