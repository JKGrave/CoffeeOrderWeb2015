<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/header.css"/>
<title>회원목록</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">
<div class="contents-wrap-div" >
<div class="page-header">
  <h1>회원관리<small>&nbsp;회원목록조회</small></h1>
</div>
<div id="table-width">
<table class="table table-striped">
<thead>
	<tr>
		<th>no</th>
		<th>이름</th>
		<th>포인트</th>
		<th>마일리지</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="member" items="${pageResult.results}">
		<tr>
			<td class="formCenter">${member.id}</td>
			<td class="formCenter">${member.name}</td>
			<td class="formCenter">${member.point}</td>
			<td class="formCenter">${member.mileage}</td>
		</tr>
	</c:forEach>
</tbody>
</table>
	<ul class="pagination">
	   <c:if test="${pageResult.search.page != 1}">
	   		<li><a href="${ctx}/members.do?page=${pageResult.search.page-1}">«</a></li>
	   </c:if>
	   	<c:forEach var="page" begin="${pageResult.search.startPage}" end="${pageResult.search.endPage}">
	   		<li>
	   			<c:if test="${page == pageResult.search.page}">
		   			<a><strong>${page}</strong></a>
		   		</c:if>
		   		<c:if test="${page != pageResult.search.page}">
	   				<a href="${ctx}/members.do?page=${page}">${page}</a>
	   			</c:if>
	   		</li>
	   	</c:forEach>
	   <c:if test="${pageResult.search.page != pageResult.totalPage}">
	   		<li><a href="${ctx}/members.do?page=${pageResult.search.page+1}">»</a></li>
	   </c:if>
	</ul> 
</div>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>

</body>
</html>