<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" >
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/main.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/header.css"/>
<title>메인화면</title>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>
<div class="main" id="Index">

<div class="jumbotron">
  <div class="container">
    <h1>WELCOME!</h1>
    <p><strong>${loginName}</strong>&nbsp;님 로그인되었습니다.</p>
    <p>새로운 공지사항이 도착하였습니다.</p>
    <p><a class="btn btn-primary btn-lg" href="${ctx}/article/articles.do">Learn more</a></p>
  </div>
</div>

<%-- <p>${loginStoreName}<small>&nbsp;입니다.</small></p>
<p>${loginName}님<small>&nbsp;안녕하세요.</small></p> --%>
<br/>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>