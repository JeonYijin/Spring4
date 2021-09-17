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
		<div class="col-md-5">
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
			
			<c:forEach items="${dto.files}" var="f">
				<div>
					<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
				</div>
			</c:forEach>
			<hr>
			<div>
				<div class="mb-6 mx-auto">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" readonly="readonly" value="${member.id}" class="form-control" name="writer" id="writer" placeholder="작성자를 입력하세요">
				</div>
				
				<div class="mb-6 mx-auto">
				   <label for="contents" class="form-label">Contents</label>
		  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="6"></textarea>
				  </div>	
				
				<button id="comment" type="button">write</button>
				
			</div>
			
			
			<hr>
			

			<c:if test="${not empty member and member.id eq dto.writer}">

				<a href="./delete?num=${dto.num}">DELETE</a>
				<a href="./update?num=${dto.num}">UPDATE</a>
			
			</c:if>
			<c:if test="${board ne 'notice'}">
				<a href="./reply?num=${dto.num}">REPLY</a>
			</c:if>
			
		</div>	
	</div>
<script type="text/javascript">
	$('#comment').click(function(){
		//작성자, 내용 콘솔에 출력
		let contents = $('#contents').val();
		let writer = $('#writer').val();
		$.post('./comment',{num:'${dto.num}',writer:writer, contents:contents},function(result){
			console.log(result.trim());
		});
	});

</script>
</body>
</html>