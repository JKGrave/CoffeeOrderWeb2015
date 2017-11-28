<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%-- <link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" > --%>

<div id="menu">
<ul class="nav nav-pills nav-stacked">
	<c:forEach var="menus" items="${menus}">
		<li ><a href="${ctx}${menus.url}">${menus.name}</a></li>
	</c:forEach>
</ul>
</div>
