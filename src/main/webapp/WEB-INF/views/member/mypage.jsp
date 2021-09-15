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
	<h1>MyPage</h1>

<form class="col-md-5 mx-auto " id="frm" action="myupdate" method="post" >

	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">아이디</label>
	  <input type="text" readonly="readonly" value="${member.id}" name= "id"class="form-control not" id="id">
	  <div id="idResult"></div>
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">비밀번호</label>
	  <input type="password" readonly="readonly" value="${member.pw}" name="pw" class="form-control not pw" id="pw1">
	</div>

	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">이름</label>
	  <input type="text" readonly="readonly" value="${member.name}" name="name" class="form-control not " id="exampleFormControlInput1" >
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">전화번호</label>
	  <input type="tel" readonly="readonly" value="${member.phone}" name="phone"class="form-control not" id="exampleFormControlInput1" >
	</div>
	
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">이메일</label>
	  <input type="email" readonly="readonly" value="${member.email}" name="email" class="form-control not" id="exampleFormControlInput1" placeholder="name@example.com">
	</div>
	<div>
		<img alt="" src="../resources/upload/member/${files.fileName}">
	</div>
	
	<a href="./myupdate?id=${member.id}&pw=${pw}">회원정보수정</a>
	<%-- <a id = "del" href="./delete?id=${member.id}">회원탈퇴</a> --%>
	<a href="#" id="del">탈퇴</a>
	<!-- <button id= "del" type="button">회원탈퇴</button> -->
</form>

<script type="text/javascript">
/* const  del = document.getElementById('del'); */
const del = document.querySelector("#del");
 del.addEventListener('click', function(){
	let result= confirm("정말로 탈퇴하시나요?");
	if(result){
		location.href="./delete";
	}
});

</script>
<!-- <script type="text/javascript">
	let del = document.getElementById('del');
	let frm = document.getElementById('frm');
	del.addEventListener('click', function(){
		location.href="./delete"+${member.id};
	let real= confirm("정말로 탈퇴하시나요?");
	if(!real){
		frm.method="get";
	}
	
	});
	

</script> -->
</body>
</html>