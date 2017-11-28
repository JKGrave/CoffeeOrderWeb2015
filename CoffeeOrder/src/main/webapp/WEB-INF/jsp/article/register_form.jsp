<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/article.css"/>
<title>공지사항 등록폼</title>
<script type="text/javascript">
	function back(){
		location.href='${ctx}/article/articles.do';	
	}
	
	function validateArticle(){
		var title = document.getElementById('title').value.trim();
		var contents = document.getElementById('contents').value.trim();
		
		if(title.length == 0 || title==''){
			alert('제목을 입력하세요');
			return false;
		}
		if(contents.length == 0 || contents==''){
			alert('내용을 입력하세요');
			return false;
		}
		
		document.getElementById('table-width').submit();
	}
</script>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<jsp:include page="/common/menu.jsp"/>

<div id="Index">
<div class="contents-wrap-div">
<div class="page-header">
  		<h1>글쓰기<small>&nbsp;내용을 입력해주세요.</small></h1>
</div>
	<form action="${ctx}/article/register.do" method="post" id="table-width" onsubmit="validateArticle(); return false;">
		<table class="table">
			<tbody>
				<tr>
					<th>카테고리</th>
					<td><select class="form-control" name="category">
					<option selected="selected" value="1">추천메뉴</option>
					<option value="2">신메뉴알림</option>
					<option value="3">공지사항</option>
				</select></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input class="form-control" type="text" name="title" id="title"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="form-control" rows="10" name="contents" id="contents"></textarea></td>
				</tr>
			</tbody>
		</table>
		<input class="btn btn-default articleBtn" type="button" value="취소" onclick="back();"/>
		<input class="btn btn-default articleBtn" type="submit" value="등록"/>
	</form>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>