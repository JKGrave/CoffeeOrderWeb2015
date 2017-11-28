<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- <link type="text/css" rel="stylesheet" href="${ctx}/style/css/footer.css"/> --%>

<div id="Footer">Copyright&nbsp;<span class="glyphicon glyphicon-copyright-mark"></span>&nbsp;<strong class="text-info">team4.</strong>&nbsp;All Right Reserved.</div>

<script>
   // 반드시 본문 내용 중에 id : Index, Footer가 있어야 함.
   var Height_Index = Number(document.getElementById("Index").clientHeight); // Min-Height를 지정해 주기 위해 기존 Default Height를 저장
   window.onload  = changeContentSize;          // Window 창 로드시
   window.onresize  = changeContentSize;          // Window 창 크기를 조정할때마다
   function changeContentSize() {
    var Height_Window   = Number(document.documentElement.clientHeight);   // Window 창 높이
    var Height_Footer   = Number(document.getElementById("Footer").clientHeight); // Footer 높이 구하기
    var ContentTop = Height_Window - Height_Footer - 86;          // 5 = Margin + Padding + Border of Top, Bottom
    document.getElementById("Index").style.minHeight = Height_Index + 'px';     // Index에 Min-Height 적용
    document.getElementById("Index").style.height = ContentTop + "px";      // Index 높이 변경
   }
</script>