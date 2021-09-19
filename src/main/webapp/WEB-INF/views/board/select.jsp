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
			<!-- comment 입력 -->
			<div>
				<div class="mb-6 mx-auto">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" readonly="readonly" value="${member.id}" class="form-control" name="writer" id="writer" placeholder="작성자를 입력하세요">
				</div>
				
				<div class="mb-6 mx-auto">
				   <label for="contents" class="form-label">Contents</label>
		  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="3"></textarea>
				  </div>	
				
				<button id="comment" type="button">write</button>
				
			</div>
			<!-- comment 출력 -->
			<c:forEach items="${comment}" var="c">
			<c:if test="${dto.num eq c.num}">
			<div>
				<div class=" mx-auto">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" readonly="readonly" value="${c.writer}" class="form-control" name="writer" id="writer">
				  <input type="text" readonly="readonly" value="${c.contents }" class="form-control" name="contents" id="contents">
				</div>
		
			</div>
			</c:if>
			
			</c:forEach>
			<hr>
			
			<!-- paging하는데 앞뒤 버튼 넣기 -->
			<nav aria-label="Page navigation example">
			<ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./select?num=${dto.num}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			     <li class="page-item">
			      <a class="page-link" href="./select?pn=${pager.startNum-1}&num=${dto.num}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			<!-- 버튼 사이에 반복될 페이지넘버 버튼 넣기 -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
				<li class="page-item"><a class="page-link" href="./select?pn=${n}&num=${dto.num}">${n}</a></li>
			</c:forEach>
			
			<li class="page-item">
			      <a class="page-link" href="./select?pn=${pager.lastNum+1}&num=${dto.num}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./select?pn=${pager.totalPage}&num=${dto.num}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			 </ul>  
		</nav>

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
		let num = ${dto.num};
		$.post('./comment',{num:num ,writer:writer, contents:contents},function(result){
			result = result.trim();
			console.log(result);
			
			
		}); 
		/* $.get('./comment?num='+num+'&writer='+writer+'&contents='+contents, function(result){
			console.log(result.trim());
			
		}) */
		
	});

</script>
</body>
</html>