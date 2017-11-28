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
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/order.css"/>
<title>결 제</title> 
<script type="text/javascript">
	function findMember(){
		var memberNum = documemt.getElementById('memberNum').value.trim();
		
		if(memberNum.length == 0 || memberNum == ''){
			alert('회원번호를 입력하세요');
			return false;
		}
		
		document.getElementById('findMemberForm').submit();
	}
	
	function invalidatePayment(){
		var paymentMethod = document.getElementsByName('paymentMethod');
		var checkPossible =false;
		for(i=0 ; i<paymentMethod.length;i++){
			checkPossible = false;
			if(paymentMethod[i].checked == true){
				checkPossible = true;
				break;
			}
		}
		
		
		if(checkPossible == true){
			return true;
		}else {
			alert('결제방법을 선택하세요');
			return false;
		}
		
		
	}

</script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>
	
<div id="Index" class="contents-wrap-div">
<div class="page-header">
  <h1>주문확인<small>&nbsp;한번 더 확인해주세요.</small></h1>
</div>
<div class = "left">
	<form class="form-inline" action="${ctx}/order/payCoffee/searchMember.do" method="post" id ="findMemberForm" onsubmit="findMember();return false;">
		<div class="form-group">
			<label class="sr-only" for="memberNum">회원 전화번호</label>
			<input class ="form-control" type="text" id="memberNum" name="memberNum" placeholder="회원 전화번호"/>
		</div>
		<button type="submit" class="btn btn-default">검색</button>
	</form>
	<table class="table">
	<thead>
		<tr>
			<th>회원 이름</th>
			<th>포인트</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="formCenter">${memberName}</td>
			<td class="formCenter">${point}</td>
			<td class="formCenter">${mileage}</td>
		</tr>
	</tbody>
	</table></div>
	<div class="right">
	<form action="${ctx}/order/payCoffee.do" method="post" id="paycheck" onsubmit="return invalidatePayment();">
	<p>결제수단</p>
	<table class="table">
	<tbody>
		<c:forEach var="payment" items="${payment}">
			<tr>
				<td><input type="radio" name="paymentMethod" value="${payment.id}">${payment.name}</td>
			<tr>
		</c:forEach>
		<tr>
			<td id="totalPrice">결제금액 :&nbsp;&nbsp;<strong>${price}</strong> 원</td>
		</tr>
		</tbody>
	</table>
		<input class="btn btn-default orderBtn" type="submit" value="결제확인"/>
		<input type="hidden" value="${price}" name="price"/>
		<input type="hidden" value="${memberNum}" name="memberNum"/>
	</form></div>
</div>
	<jsp:include page="/common/footer.jsp"/>
</body>
</html>