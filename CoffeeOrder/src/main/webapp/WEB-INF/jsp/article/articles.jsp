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
<title>공지사항</title>
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
	
	function registerArticle(){
		location.href='${ctx}/article/register.do';
	}
	
	function change(value){
		var e = document.getElementById("category");
		var category = e.options[e.selectedIndex].value;
		
		location.href='${ctx}/article/articles.do?category='+category;
		
	}
	
	function checkPossible(){
		
		var nodes = document.getElementsByTagName('input');
		
		for( var i = 0; i<nodes.length;i++){
			var node= nodes[i];
			if(node.name == 'no' && node.disabled == false){
				if(node.checked == true){
					document.getElementById('deleteArticle').submit();
					return true;
				}
			}
		}
		alert('삭제하실 글을 체크하세요');
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
  <h1>공지사항<small>&nbsp;공지합니다.</small></h1>
</div>
	<div id="table-width">
	<select name="category" id="category" onchange="change(this);">
		<option value="0" >전체</option>
		<option value="1" <c:if test="${category==1}">SELECTED</c:if>>추천메뉴</option>
		<option value="2" <c:if test="${category==2}">SELECTED</c:if>>신메뉴알림</option>
		<option value="3" <c:if test="${category==3}">SELECTED</c:if>>공지사항</option>
	</select><br/>
	<form id="deleteArticle" action="${ctx}/article/delete.do" method="post" onsubmit="checkPossible(); return false">
	<table class="table table-striped">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="allCheck(this)"></th>
				<th>종류</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="articles" items="${pageResult.results}">
			<tr>
				<td class="formCenter"><input type="checkbox" name="no" value="${articles.id}"/></td>
				<td class="formCenter">${articles.boardName}</td>
				<td><a href="${ctx}/article/detail.do?id=${articles.id}&page=${pageResult.search.page}&category=${category}">${articles.title}</a></td>
				<td class="formCenter"><fmt:formatDate value="${articles.createDate}" pattern="yyyy-MM-dd"/></td>
				<td class="formCenter">${articles.writer.name}</td>
				<td class="formCenter">${articles.readCount}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<input class="hidden" name="page" value="${pageResult.search.page}"/>
	<input class="hidden" name="category" value="${category}"/>
	<input class="btn btn-default orderBtn" type="submit" value="글삭제" />
	<input class="btn btn-default orderBtn" type="button" value="글쓰기" onclick="registerArticle();"/>
	</form>
	<!-- 하단 페이지이동 -->
	
	<ul class="pagination">
	  <c:if test="${pageResult.search.page != 1}">
	  		<li><a href="${ctx}/article/articles.do?page=${pageResult.search.page-1}&category=${category}">«</a></li>
	  </c:if>
	  <c:forEach var="page" begin="${pageResult.search.startPage}" end="${pageResult.search.endPage}">
   			<li>
		   		<c:if test="${page == pageResult.search.page}">
		   				<a><strong>${page}</strong></a>
		   		</c:if>
		   		<c:if test="${page != pageResult.search.page}">
			   			<a href="${ctx}/article/articles.do?page=${page}&category=${category}">${page}</a>
			   	</c:if>
	   		</li>
	   </c:forEach>
	   <c:if test="${pageResult.search.page != pageResult.totalPage}">
	   		<li><a href="${ctx}/article/articles.do?page=${pageResult.search.page+1}&category=${category}">»</a></li>
	   </c:if>
	</ul> 
	</div>
</div>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>