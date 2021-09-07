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
<h1>${board} SELECT PAGE</h1>
	<div class="container-fluid">
		<div class="col-md-6 mx-auto">
			<table class="table table-striped table-hover">
			
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>CONTENTS</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HITS</th>
				</tr>
				<tr>
					<td>${dto.num}</td>
					<td>${dto.title}</td>
					<td>${dto.contents}</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hits}</td>

				</tr>

			</table>
			<a href="./delete?num=${dto.num}">DELETE</a>
			<a href="./update?num=${dto.num}">UPDATE</a>
			<c:if test="${board ne 'notice'}">
				<a href="./reply?num=${dto.num}">REPLY</a>
			</c:if>
			
		</div>	
	</div>

</body>
</html>
