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
</head>
<body>

<form class="col-md-5 mx-auto " id="frm" action="./myupdate" method="post" >
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">아이디</label>
	  <input type="text" readonly="readonly" value="${member.id}" name= "id"class="form-control not" id="id">
	  <div id="idResult"></div>
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
	  <input type="password"  value="${member.pw}" name="pw" class="form-control not pw" id="pw1">
	</div>

	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">비밀번호 확인</label>
	  <input type="password" class="form-control not pw" id="pw2" >
	</div>


	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">이름</label>
	  <input type="text"  value="${member.name}" name="name" class="form-control not " id="exampleFormControlInput1" >
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">전화번호</label>
	  <input type="tel"  value="${member.phone}" name="phone"class="form-control not" id="exampleFormControlInput1" >
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">이메일</label>
	  <input type="email"  value="${member.email}" name="email" class="form-control not" id="exampleFormControlInput1" placeholder="name@example.com">
	</div>
	<button id="btn" type="submit">수정하기</button>
</form>



<script type="text/javascript" src="../resources/js/join.js"></script>
</body>
</html>