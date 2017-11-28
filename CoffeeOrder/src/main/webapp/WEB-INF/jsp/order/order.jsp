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
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/order.css"/>
<title>주문받기</title>
<script type="text/javascript">
	function orderCancle(){
		location.href='${ctx}/order/cancleOrder.do';
	}

	function checkPossible(){
		var coffeeName = document.getElementsByName('coffeeName');
		var whippingOption = document.getElementsByName('whippingOption');
		var shotOption = document.getElementsByName('shotOption');
		var syrupOption = document.getElementsByName('syrupOption');
		var cupOption = document.getElementsByName('cupOption');
		var sizeOption = document.getElementsByName('sizeOption');
		var tempOption = document.getElementsByName('tempOption');
		var checkPossible = false;
		
		for(i=0 ; i<coffeeName.length;i++){
			checkPossible = false;
			if(coffeeName[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('커피를 선택하세요');
			return false;
		}
		
		for(i=0 ; i<whippingOption.length;i++){
			checkPossible = false;
			if(whippingOption[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('휘핑옵션을 선택하세요');
			return false;
		}
		
		for(i=0 ; i<shotOption.length;i++){
			checkPossible = false;
			if(shotOption[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('샷옵션을 선택하세요');
			return false;
		}
		
		for(i=0 ; i<syrupOption.length;i++){
			checkPossible = false;
			if(syrupOption[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('시럽옵션을 선택하세요');
			return false;
		}
		
		for(i=0 ; i<cupOption.length;i++){
			checkPossible = false;
			if(cupOption[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('컵옵션을 선택하세요');
			return false;
		}
		
		for(i=0 ; i<sizeOption.length;i++){
			checkPossible = false;
			if(sizeOption[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('사이즈를 선택하세요');
			return false;
		}
		
		for(i=0 ; i<tempOption.length;i++){
			checkPossible = false;
			if(tempOption[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		if(checkPossible == false){
			alert('핫/아이스를 선택하세요');
			return false;
		}
				
		document.getElementById('coffeeOrderForm').submit();
	}
	
	
</script>
</head>

<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">
<div class="contents-wrap-div">
<div class="page-header">
  <h1>주문받기<small>&nbsp;음료를 선택해주세요.</small></h1>
</div>

<form action="${ctx}/order/addOrder.do" method="post" id="coffeeOrderForm" onsubmit="checkPossible();return false;">
<div id=coffee>
<table class="table table-striped">
	<thead><tr><th>메뉴</th></tr></thead>
	<tbody>
		<c:forEach var="coffee" items="${coffee}">
			<tr>
				<td><input type="radio" id="coffeeName" name="coffeeName" value="${coffee.id}">${coffee.name}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>


<div id="option">
<table class="table table-striped">
<thead><tr><th>옵션설정</th><th></th><th></th><th></th></tr></thead>
<tbody>
	<tr>
		<th>휘핑 양</th>
		<c:forEach var ="whipping" items="${whipping}"> 
			<td><input type="radio" id="whippingOption" name="whippingOption" value="${whipping.code}">${whipping.name}</td>						
		</c:forEach>
	</tr>
	<tr>
		<th>샷수</th>
		<c:forEach var ="shot" items="${shot}"> 
			<td><input type="radio" id="shotOption" name="shotOption" value="${shot.code}">${shot.name}</td>						
		</c:forEach>
	</tr>
	<tr>
		<th>시럽 양</th>
		<c:forEach var ="syrup" items="${syrup}"> 
			<td><input type="radio" id="syrupOption" name="syrupOption" value="${syrup.code}">${syrup.name}</td>						
		</c:forEach>
	</tr>
	<tr>
		<th>컵 종류</th>
		<c:forEach var ="cup" items="${cup}"> 
			<td><input type="radio" id="cupOption" name="cupOption" value="${cup.code}">${cup.name}</td>						
		</c:forEach>
	</tr>
	<tr>
		<th>음료 양</th>
		<c:forEach var ="size" items="${size}"> 
			<td><input type="radio" id="sizeOption" name="sizeOption" value="${size.code}">${size.name}</td>						
		</c:forEach>
	</tr>
	<tr>
		<th>HOT/ICE</th>
		<c:forEach var ="temperature" items="${temperature}"> 
			<td><input type="radio" id="tempOption"  name="tempOption" value="${temperature.code}">${temperature.name}</td>						
		</c:forEach>
		<td></td>
	</tr>
</tbody>
</table>
<p>
<input class="btn btn-default orderBtn" type="reset" value="초기화">
<input class="btn btn-default orderBtn" type="submit" value="추가">
<p>
</div>
</form>

<form action="${ctx}/order/payCoffeeForm.do" method="post" id="confirmOrder" onsubmit="return isOrderList();">
<div id="order">
<table class="table table-striped">
	<thead>
		<tr>
			<th>제품</th>
			<th>휘핑 양</th>
			<th>샷 수</th>
			<th>시럽 양</th>
			<th>HOT/ICE</th>
			<th>컵 종류</th>
			<th>음료 양</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="order" items="${orderList}">
			<tr>
				<td class="formCenter">${order.coffee.name}</td>
				<td class="formCenter">${order.whipping.name}</td>
				<td class="formCenter">${order.shot.name}</td>
				<td class="formCenter">${order.syrup.name}</td>
				<td class="formCenter">${order.temperature.name}</td>
				<td class="formCenter">${order.cup.name}</td>
				<td class="formCenter">${order.size.name}</td>
			</tr>		
		</c:forEach>
	</tbody>
</table>
<p>

<input class="btn btn-default orderBtn" type="button" value="주문취소" onclick="orderCancle();">
<input class="btn btn-default orderBtn" type="submit" value="주문확인">
</p>
</div>
</form>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>