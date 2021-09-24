<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped">

<c:forEach items="${comments}" var="comment">
	<tr>
		<td>${comment.commentNum}</td>
		<td id="content${comment.commentNum}">
		 <%-- <textarea class="form-control" cols="" readonly="readonly" name="contents" id="" rows="">
		 		${comment.contents}
		 </textarea> --%>
		 <div>
		 	${comment.contents}
		 </div>
		 </td>
		<td>${comment.writer}</td>
		<td>${comment.regDate}</td>
		<td>
			<c:if test="${member.id eq comment.writer}">
				<button id="upbtn" data-comment-update="${comment.commentNum}"">UPDATE</button>
				<button id="delbtn" data-comment-del="${comment.commentNum}">DEL</button>
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>
<!-- paging하는데 앞뒤 버튼 넣기 -->
			<nav aria-label="Page navigation example">
			<ul class="pagination">
			    <li class="page-item">
			      <span class="page-link c1" data-comment-pn="1"aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </span>
			    </li>
			    
			     <li class="page-item">
			      <span class="page-link c1" data-comment-pn="${pager.startNum-1}"  aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </span>
			    </li>
			<!-- 버튼 사이에 반복될 페이지넘버 버튼 넣기 -->
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
				<li class="page-item"><span class="page-link c1" data-comment-pn="${n}" >${n}</span></li>
			</c:forEach>
			
			<li class="page-item">
			      <span class="page-link c1" data-comment-pn="${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </span>
			    </li>
			    
			    <li class="page-item">
			      <span class="page-link c1" data-comment-pn="${pager.totalPage}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </span>
			    </li>
			 </ul>  
		</nav>
	