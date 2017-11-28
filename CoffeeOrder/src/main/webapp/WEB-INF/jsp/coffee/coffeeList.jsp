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
<title>커피</title>
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

	function registerCoffee(){
		location.href = '${ctx}/coffee/register.do';
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
		alert('삭제하실 제품을 선택하세요');
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
  <h1>메뉴관리<small>&nbsp;등록 및 삭제가 가능합니다.</small></h1>
</div>
<form action="${ctx}/coffee/delete.do" method="post" id="table-width" onsubmit="checkPossible(); return false")>
	<table class="table table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="allCheck(this)"></th>
				<th>제품명</th>
				<th>가격</th>
				<th>제품설명</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="coffee" items="${coffeeList}">
				<tr>
					<td class="formCenter"><input type="checkbox" name="no" value="${coffee.id}"/></td>
					<td><a href="${ctx}/coffee/modify.do?id=${coffee.id}">${coffee.name}</a></td>
					<td class="formCenter">${coffee.price}</td>
					<td>${coffee.productInfo}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	<input class="btn btn-default orderBtn" type="submit" value ="삭제"/>
	<input class="btn btn-default orderBtn" type="button" value ="추가" onclick="registerCoffee();"/>
	</form>
	</div>
	</div>
	<jsp:include page="/common/footer.jsp"/>
</body>
</html>