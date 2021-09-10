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
	<h1>Login Page</h1>
	
	<form class="col-md-5 mx-auto " id="frm" action="login" method="post" >
	
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">아이디</label>
		  <input type="text" name ="id" class="form-control not" id="id">
		</div>
		
		<div class="mb-3 ">
		  <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
		  <input type="text" name="pw" class="form-control not pw" id="pw1">
		  <button id="btn" type="submit">Login</button>
		</div>
	
	</form>
</body>
</html>