<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Join Page</h1>
<div class="col-md-6 mx-auto">
	<div class="input-group mb-3">
	  <span class="input-group-text" id="inputGroup-sizing-default">아이디</span>
	  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
	</div>
	
	<div class="input-group mb-3 ">
	  <span class="input-group-text" id="inputGroup-sizing-default">비밀번호</span>
	  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
	</div>

	<div class="input-group mb-3 ">
	  <span class="input-group-text" id="inputGroup-sizing-default">비밀번호 확인</span>
	  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
	</div>

	<div class="input-group mb-3 ">
	  <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
	  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
	</div>
		
	<div class="input-group mb-3 ">
	  <span class="input-group-text" id="inputGroup-sizing-default">전화번호</span>
	  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
	</div>
	
	<div class="input-group mb-3 ">
	  <input type="text" class="form-control" placeholder="Username" aria-label="Username">
	  <span class="input-group-text">@</span>
	  <input type="text" class="form-control" placeholder="Server" aria-label="Server">
	</div>	
</div>
</body>
</html>