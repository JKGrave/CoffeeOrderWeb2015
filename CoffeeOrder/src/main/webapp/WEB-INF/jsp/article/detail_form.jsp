<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/menu.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" >
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/>
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/header.css"/>
<title>글 상세보기</title>
<script type="text/javascript">
	function back(){
		location.href='${ctx}/article/articles.do?page=' +${page} + '&category='+${category};
	}
</script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">
<div class="contents-wrap-div">
<div class="page-header">
  		<h1>상세보기<small>&nbsp;상세내용</small></h1>
</div>
<form action="${ctx}/article/modifyForm.do" method="post" id="table-width">
<table class="table">
	<tbody>
	<tr>
	<th>카테고리</th><td>${article.boardName}</td>
	</tr>
	<tr>
	<th>제목</th><td>${article.title}</td>
	</tr>
	<tr>
	<th>작성자</th><td>${article.writer.name}</td>
	</tr>
	<tr>
	<th>작성시간</th><td><fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd"/></td>
	</tr>
	<tr>
	<th>조회수</th><td>${article.readCount}</td>
	</tr>
	<tr>
	<th>내용</th><td>${article.contents}</td>
	</tr>
	</tbody>
</table>
	<input type="hidden" name="page" value="${page}"/>
	<input type="hidden" name="startCategory" value="${category}"/>
	<input type="hidden" name="id" value="${article.id}"/>
	
	<input class="btn btn-default articleBtn orderBtn" type="button" value="뒤로가기" onclick="back();"/>
	<input class="btn btn-default articleBtn orderBtn" type="submit" value="수정"/>
</form>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>