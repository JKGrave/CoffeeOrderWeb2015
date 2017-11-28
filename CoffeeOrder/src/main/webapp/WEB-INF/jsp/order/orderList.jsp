<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" >
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/header.css"/>
<title>주문내역</title>
<script type="text/javascript">

	function allCheck(el){
		var ischecked = el.checked;
		
		var nodes = document.getElementsByTagName('input');
		
		for( var i = 0; i<nodes.length;i++){
			var node= nodes[i];
			if(node.name == 'no' && node.disabled == false){
				if(ischecked == true){
					node.checked = true;
				}else{
					node.checked = false;
				}
			}
		}
	}


	function checkPossible(){
		var nodes = document.getElementsByTagName('input');
		
		for( var i = 0; i<nodes.length;i++){
			var node= nodes[i];
			if(node.name == 'no' && node.disabled == false){
				if(node.checked == true){
					document.getElementById('table-width').submit();
					return true;
				}
			}
		}
		alert('제조완료된 주문을 선택하세요');
		return false;
	}
</script>
</head>

<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">

<div class="contents-wrap-div">
<div class="page-header">
  <h1>주문내역<small>&nbsp;판매현황</small></h1>
</div>

<form action="${ctx}/order/recieveCheck.do" method="post" id="table-width" onsubmit="checkPossible(); return false;">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="allCheck(this)"/></th>
				<th>제품</th>
				<th>주문자</th>
				<th>휘핑양</th>
				<th>샷수</th>
				<th>시럽양</th>
				<th>HOT/ICE</th>
				<th>컵종류</th>
				<th>음료양</th>
				<th>주문구분</th>
				<th>주문시간</th>		
			</tr>
		</thead>
		<tbody>
			<c:forEach var="orderList" items="${orderLists}">
				<tr>
					<td class="formCenter"><input type="checkbox" name="no" value="${orderList.id}"/></td>
					<td class="formCenter">${orderList.coffee.name}</td>
					<td class="formCenter">${orderList.member.name}</td>
					<td class="formCenter">${orderList.whipping.name}</td>
					<td class="formCenter">${orderList.shot.name}</td>
					<td class="formCenter">${orderList.syrup.name}</td>
					<td class="formCenter">${orderList.temperature.name}</td>
					<td class="formCenter">${orderList.cup.name}</td>
					<td class="formCenter">${orderList.size.name}</td>
					<td class="formCenter">${orderList.payment.name}</td>
					<td class="formCenter"><fmt:formatDate value="${orderList.receiveTime}" pattern="MM/dd HH:mm:ss"/> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	<input class="btn btn-default orderBtn" type="submit" value="제조완료"> 
</form>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>

</body>
</html>