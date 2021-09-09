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
	<h1>Check Page</h1>
	
	<div class="container-fluid " >
		<div class="form-check ">
		  <input class="form-check-input " type="checkbox" value="" id="all">
		  <label class="form-check-label" for="flexCheckDefault">
		    Check All
		  </label>
		</div>
		
		<div class="form-check  "  >
		  <input class="form-check-input c1 c2" type="checkbox" value="" id="id1"   >
		  <label class="form-check-label" for="flexCheckDefault">
		    약관 1
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input c1 c2" type="checkbox" value="" id="id2"  >
		  <label class="form-check-label" for="flexCheckDefault">
		   약관 2
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input c1 c2" type="checkbox" value="" id="id3">
		  <label class="form-check-label" for="flexCheckDefault">
		    약관 3
		  </label>
		</div>
		
		<div class="form-check ">
		  <input class="form-check-input c1" type="checkbox" value="" id="id4" >
		  <label class="form-check-label" for="flexCheckDefault">
		    약관 4 (광고성)
		  </label>
		</div>		
		<button id="btn">회원가입</button>
		<!-- <a href="./join" id="btn">회원가입</a> 조건이 맞지 않아도 넘어감 사용 불가 -->
	</div>
<script type="text/javascript" src="../resources/js/member.js"></script>
</body>
</html>