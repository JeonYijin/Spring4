<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<c:import url="./temp/boot_head.jsp"></c:import>
	
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	HOME
</h1>
	<c:if test="${not empty member}">
		<h3>Login이 성공했을때 보이는 문장</h3>
	</c:if>
	
	<c:if test="${empty member}">
		<h3>Login 하기 전 보이는 문장</h3>
	</c:if>
	<h1>Conflict</h1>

	<button id="btn">Click</button>
	<div>
		<table id="r" class="table table-hover">
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>USERID</td>
			</tr>
				
		
		</table>
	</div>
	<script type="text/javascript">
		$('#btn').click(function(){
			$.ajax({
				type:"GET",
				url:"http://jsonplaceholder.typicode.com/posts",
				success:function(result){
					console.log(result);
					console.log(result[0]);
					console.log(result[0].title);
					
					for(v1 of result){
						let title = v1.title;
						let id = v1.id;
						let userid = v1.userId;
						
						$('#r').append('<tr><td>'+id+'</td><td>'+title+'</td><td>'+userid+'</td></tr>');
						
					}
					
				}
				
			});
		});
	
	</script>

	
</body>
</html>
