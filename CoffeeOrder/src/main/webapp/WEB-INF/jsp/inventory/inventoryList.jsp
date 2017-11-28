<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" >
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/header.css"/>
<title>재고현황</title>
<script type="text/javascript">
function order() {
	location.href='${ctx}/inventory/order.do';
}
</script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">	
<div class="contents-wrap-div">
<div class="page-header">
  <h1>재고관리<small>&nbsp;재고현황</small></h1>
</div>
<div id="form">
<table class="table table-striped">
<thead>
	<tr>
		<th>제품명</th>
		<th>수량</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="inventory" items="${inventoryList}">
		<tr>
			<td class="formCenter">${inventory.name}</td>
			<td class="formCenter">${inventory.amount}</td>
		</tr>
	</c:forEach>
</tbody>
</table>
<input class="btn btn-default orderBtn" type="button" value="주문" onclick="order();">
</div>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>