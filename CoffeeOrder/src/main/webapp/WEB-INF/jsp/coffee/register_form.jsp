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
<title>제품 등록</title>
<script type="text/javascript">
	
	function validateCoffee(){
		var name = document.getElementById('name').value.trim();
		var price = document.getElementById('price').value.trim();
		var productInfo = document.getElementById('productInfo').value.trim();
		
		if(name.length==0 || name==''){
			alert('제품이름을 입력하세요');
			return false;
		}
		if(price.length==0 || price==''){
			alert('제품가격을 입력하세요');
			return false;
		}
		if(productInfo.length==0 || productInfo==''){
			alert('제품정보를 입력하세요');
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
  		<h1>제품등록<small>&nbsp;신제품을 등록해주세요.</small></h1>
	</div>
	<form action="${ctx}/coffee/register.do" method="post" id="form" onsubmit="validateCoffee(); return false;">
		<div class="form-group">
		<label for="name">제품명</label>
		<input class ="form-control" type="text" name="name" id="name" />
		</div>		
		<div class="form-group">
		<label for="price">가격</label>
		<input class ="form-control" type="text" name="price" id="price"/>
		</div>
		<div class="form-group">		
		<label for="productInfo">제품설명</label>
		<input type="text" class ="form-control" name="productInfo" id="productInfo">
		</div>
			
		<input type="hidden" name="id" value="${coffee.id}"/>
		<input class="btn btn-default orderBtn" type="submit" value="등록"/>
	</form>
	</div>
	</div>
	<jsp:include page="/common/footer.jsp"/>
</body>
</html>