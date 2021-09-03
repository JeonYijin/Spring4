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
<h1>UPDATE PAGE</h1>

	<div class="container-fluid">
		<form class="col-md-6 mx-auto" action="./update" method="post">
			<input type="hidden" readonly="readonly" name="num" value="${dto.num}">
		<div class="mb-3">
		  <label for="title" class="form-label">Title</label>
		  <input type="text" class="form-control" name="title"  value="${dto.title}"id="title" placeholder="제목을 입력하세요">
		</div>
		
			
		<div class="mb-3">
		  <label for="contents" class="form-label">Contents</label>
		  <input type="textarea" class="form-control" name="contents" value="${dto.contents}" id="contents" placeholder="내용을 입력하세요">
		</div>
		
		<div class="mb-3">
		  <label for="writer" class="form-label">Writer</label>
		  <input type="text" class="form-control" name="writer" readonly="readonly" value="${dto.writer}" id="writer" placeholder="작성자를 입력하세요">
		</div>
		
		<button type="submit" class="btn btn-success">UPDATE</button>
		</form>



	</div>
</body>
</html>