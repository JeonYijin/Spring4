<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css" >
	.pw22{
		color : red;
	}

</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Join Page</h1>
<form class="col-md-5 mx-auto " id="frm" action="join" method="post" >
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">아이디</label>
	  <input type="text" name= "id"class="form-control not" id="id">
	  <button id="idCheck" type="button">id 중복체크</button>
	  <div id="idResult"></div>
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
	  <input type="text" name="pw" class="form-control not pw" id="pw1">
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">비밀번호 확인</label>
	  <input type="text" name="pwCheck" class="form-control not pw" id="pw2" >
	  <div class="pw22"></div>
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">이름</label>
	  <input type="text" name="name" class="form-control not " id="exampleFormControlInput1" >
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">전화번호</label>
	  <input type="tel" name="phone"class="form-control not" id="exampleFormControlInput1" >
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">이메일</label>
	  <input type="email" name="email" class="form-control not" id="exampleFormControlInput1" placeholder="name@example.com">
	</div>
	
	<div class="mb-3" id="files">
	 	<label class="form-label"></label>
	 	<button id="add" type="button" class="btn btn-info">File Add</button>
	</div>
	<!-- input file 추가 영역 -->
	
	<div id= "addResult">
	
	
	</div>
	
	<div class="mb-3 my-4">
    	<label class="form-label"></label>
  		<button id="btn" type="button" class="btn btn-primary">Join</button>
  	</div>
	
	<!-- <button id="btn" type="button">회원가입</button> -->
</form>
	<div class="mb-3" id ="f">
	  <label for="photo" class="form-label">Photo</label>
	  <input type="file" name="photo" class="form-control not" id="photo"><br>
	 </div>
<script type="text/javascript" src="../resources/js/join.js"></script>
<script type="text/javascript" src="../resources/js/file.js"></script>
</body>
</html>