<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./temp/boot_head.jsp"></c:import>
	
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	HOME
</h1>
	<c:if test="${not empty member}">
		<h3>Login이 성공했을때 보이는 문장</h3>
	</c:if>
	
	<c:if test="${empty member}">
		<h3>Login 하기 전 보이는 문장</h3>
	</c:if>
	
	
</body>
</html>
