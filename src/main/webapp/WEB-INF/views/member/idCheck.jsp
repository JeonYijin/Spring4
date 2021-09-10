<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Id Check Page</h1>
	
	<div>
		${param.id}는
		<c:if test="${empty dto}">
			사용 가능한 ID 입니다
		</c:if>
		
		<c:if test="${not empty dto}">
			사용 불가능한 ID 입니다
		</c:if>
	</div>
	
	<form class="col-md-3 mx-auto " id="frm" action="idCheck" method="get" >	
	
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">아이디</label>
		  <input type="text" name="id" value="${param.id}" class="form-control not" id="id">
		  <button id="idCheck" type="submit">id 중복체크</button>
		  <c:if test="${empty dto}">
			 <button type="button" id="useId">ID 사용</button>	
		  </c:if>
		 	  
		</div>
	
	</form>
<script type="text/javascript">
	const useId = document.getElementById("useId");
	useId.addEventListener('click', function(){
		let id = window.document.getElementById('id').value;
		opener.document.getElementById('id').value= id;
		close();
	});

</script>
</body>
</html>