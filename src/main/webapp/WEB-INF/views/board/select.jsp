<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.c1{
		cusor:pointer;
	}
</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>${board} SELECT PAGE</h1>

	<div class="container-fluid col-md-8">
		<div class="col-md-8">
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
			
			<!-- comment 출력 -->
			<div id="commentList" data-board-num="${dto.num}">
			
			</div>			
			
			<!-- comment 입력 -->
			<div>
				<div class="mb-8 mx-auto">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" readonly="readonly" value="${member.id}" class="form-control" name="writer" id="writer" placeholder="작성자를 입력하세요">
				</div>
				
				<div class="mb-8 mx-auto">
				   <label for="contents" class="form-label">Contents</label>
		  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="3"></textarea>
				  </div>	
				
				<button id="comment" type="button">write</button>
				
			</div>

		<%-- 	<c:forEach items="${comment}" var="c">
			<c:if test="${dto.num eq c.num}">
			<div>
				<div class=" mx-auto">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" readonly="readonly" value="${c.writer}" class="form-control" name="writer" id="writer">
				  <input type="text" readonly="readonly" value="${c.contents }" class="form-control" name="contents" id="contents">
				</div>
		
			</div>
			</c:if>
			
			</c:forEach> --%>
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

	//up click event
	let content='';
	$('#commentList').on('click','#upbtn',function(){
		console.log('up');
		
		let num = $(this).attr("data-comment-update");
		content = $('#content'+num).text().trim();
		$('#content'+num).children().css('display','none');
		let ta = '<textarea class="form-control" cols=""  name="contents" id="contents" rows="3">';
		ta =ta+ content.trim() + '</textarea>';
		ta= ta + '<button id="" class="btn btn-primary up" type="button">update</button>';
		ta = ta+ '<button id="" class="btn btn-danger can" type="button">cancel</button>';
		$('#content'+num).append(ta);
		
	});

	//취소버튼 누르면 돌아가기
	//let cancel = $('#content'+num).attr('.can');
	$('#commentList').on('click', ".can", function(){
		console.log(content);
		$(this).parent().children('div').css('display','block');
		$(this).parent().children('textarea').remove();
		$(this).parent().children('button').remove();
		//ta=content.trim();
		//$('#content'+num).html(ta);
	})
	//update 버튼 누르면 update
	$('#commentList').on('click', ".up", function(){
		let contents = $(this).prev().val();
		let cn= $(this).parent().prev().text().trim();
		$.ajax({
			type: "POST",
			url: './commentUpdate',
			data:{
				contents:contents,
				commentNum:cn
				},
			success:function(result){
				if(result.trim()>0){
					alert('성공');
					//getCommentList(1);
					selector.parent().children('div').text(contents);
					selector.parent().children('div').css('display','block');
					selector.parent().children('textarea').remove();
					selector.parent().children('button').remove(); 
				}else{
					alert('실패');
				}
			},
			erorr: function(){
				alert('수정 실패');
			}
		});
	});


	getCommentList(1);

	//del click event
	
	$('#commentList').on('click', '#delbtn', function(){
		let commentNum = $(this).attr('data-comment-del');
		//url ./commentDel
		$.ajax({
			type: "POST",
			url: "./commentDel",
			data : {
				commentNum:commentNum
			},
			success: function(result){
				result=result.trim();

				if(result>0){
					alert('삭제 성공');
				}else{
					alert('삭제실패');
				}
				
				getCommentList(1);
			},
			error: function() {
				alert('삭제 실패');
			}
		})
		
	})
	
	$('#commentList').on("click",".c1", function(){
		//data-comment-pn
	 	let pn	= $(this).attr('data-comment-pn');
		//console.log(pn)
		getCommentList(pn);
	})

	
	function getCommentList(pageNumber) {
		let num = $("#commentList").attr("data-board-num");
		$.ajax({
			type: "GET",
			url: "./getCommentList",
			data: {
				num:num,
				pn: pageNumber
				},
			success: function(result){
				//result = result.trim();
				console.log(result);
				$('#commentList').html(result);
			},
			error:function(xhr, status, error){
				console.log(error);
			}
		})
		
		
	}
	$('#comment').click(function(){
		//작성자, 내용 콘솔에 출력
	 	let contents = $('#contents').val();
		let writer = $('#writer').val();
		let num = ${dto.num};
		$.post('./comment',{num:num ,writer:writer, contents:contents},function(result){
			alert(result);
			console.log(result);
			
			$('#contents').val(''); // 댓글을 작성한 후 제출하면 contents 내용 비우기
			getCommentList(); //댓글을 추가하고 바로 다시 리스트를 불러들이기
		}); 

		
	});

</script>
</body>
</html>