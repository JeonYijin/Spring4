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
	<h1> ${board} Board List Page</h1>
	
	<div class="container-fluid">
		<div class="col-md-8 mx-auto">
		<!-- search form -->
		<form action="./list" method="get">
						
			 <div class="input-group mb-3" >
			  <select name="kind" class="form-select form-select-sm" aria-label=".form-select-sm example">
				  <option value="title">Title</option>
				  <option value="contents">Contents</option>
				  <option value="writer">Writer</option>
				</select>
			  
			  <input type="text" name="search" class="form-control" aria-label="Text input with dropdown button">
			  <button type="submit" class="btn btn-outline-secondary">Serach</button>
			</div>
			
		
		</form>
		<!-- search form -->
		
			<table class="table table-striped table-hover">
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>CONTENTS</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HITS</th>
				</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./select?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.contents}</td>
				<td>${dto.writer}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hits}</td>
			</tr>
			</c:forEach>
			</table>
			
			<!-- paging하는데 앞뒤 버튼 넣기 -->
			<nav aria-label="Page navigation example">
			<ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list?kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			     <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			<!-- 버튼 사이에 반복될 페이지넘버 버튼 넣기 -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
				<li class="page-item"><a class="page-link" href="./list?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
			</c:forEach>
			
			<li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			 </ul>  
		</nav>
			
		</div>
	
	
	</div>
	
	
</body>
</html>