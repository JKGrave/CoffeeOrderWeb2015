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
<title>제품주문</title>
<script type="text/javascript">
function previous() {
	location.href='${ctx}/inventory/inventoryList.do';
}
function checkPossible(){
	var item = document.getElementById('item').value.trim();
	var amount = document.getElementById('amount').value.trim();
	
	if(item.length==0 || item == ''){
		alert('주문하실 제품을 선택하세요');
		return false;
	}
	if(amount.length == 0 || amount == ''){
		alert('주문하실 수량을 선택하세요');
		return false;
	}
	
	document.getElementById('form').submit();
}
</script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">
<div class="contents-wrap-div">
<div class="page-header">
  <h1>재고관리<small>&nbsp;제품주문</small></h1>
</div>
<form action="${ctx}/inventory/isOrderd.do" method="post" id="form" onsubmit="checkPossible(); return false;">
제품명: 
<select name="item" id="item" class="form-control">
	<option value="">선택</option>
	<c:forEach var ="inventory" items="${inventoryList}">
		<option value="${inventory.id}">${inventory.name}</option>
	</c:forEach>
</select>
주문수량:
<select name="amount" id="amount" class="form-control">
	<option value="">선택</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
</select>
<br/>
<input class="btn btn-default orderBtn" type="button" value="되돌아가기" onclick="previous();">
<input class="btn btn-default orderBtn" type="submit" value="주문">
</form>
<br/><br/><br/>
<table class="table table-striped" id="form2">
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
</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>