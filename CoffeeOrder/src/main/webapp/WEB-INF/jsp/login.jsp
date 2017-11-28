<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<html lang="en">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/login.css">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.png">
<link type="text/css" rel="stylesheet" href="${ctx}/style/css/bootstrap.css" >
<title>로그인</title>
<script type="text/javascript">
	function invalidateLogin(){
		var id = document.getElementById('id').value.trim();
		var pw = document.getElementById('pw').value.trim();
		
		if(id.length == 0 || id == ''){
			alert('아이디를 입력하세요');
			return false;
		}
		if(pw.length == 0 || pw == ''){
			alert('패스워드를 입력하세요');
			return false;
		}
		return true;
	}

</script>
</head>
<body>
<div class="container">
<img src="${ctx}/style/img/font.png">
<form action="login.do" method="post" role="form" id = "loginForm" onsubmit="return invalidateLogin();">
<div class="col-md-6 col-md-offset-3">
<input type="text" class="form-control" name="id" id="id" placeholder="아이디" autofocus/><br/>
<input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호"/><br/>
<input type="submit" class="btn btn-lg btn-primary btn-block" value="로그인" />
</div>
</form>
</div>

</body>
</html>