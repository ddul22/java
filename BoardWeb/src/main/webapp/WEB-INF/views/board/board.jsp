<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>상세화면(board.jsp)</h3>

<form action="modifyForm.do">
	<input type="hidden" name="bno" value="${board.boardNo }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><c:out value="${board.boardNo }"></c:out></td>
			<th>조회수</th>
			<td><c:out value="${board.viewCnt }"></c:out></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><c:out value="${board.title }"></c:out></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><c:out value="${board.content }"></c:out></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${board.writer }"></c:out></td>
			<th>작성일시</th>
			<td><c:out value="${board.writeDate }"></c:out></td>
		<tr><th><img src="images/${board.img }"></img></th></tr>
			<td colspan="4" align="center">
				<button class="btn btn-warning" type="submit">수정</button>
				<button class="btn btn-danger" type="button">삭제</button>
			</td>
		</tr>
		<c:if test="${msg !=null }">
			<tr><td align="center" colspan="4"><span style="color: red;">${msg }</span></td></tr>
		</c:if>
	</table>
</form>

<style>
  .reply .content ul{
    list-style-type: none;
  }
  .reply .content span {
  display: inline-block;
  }
</style>

<!-- 댓글관련. -->
<div class="container reply">
  <!-- 댓글등록 -->
<div class="header">
</div>
	<input type="text" id="reply" class="col-sm-9">
	<button id="addReply">댓글등록</button>
	<button id="button">댓글삭제</button>
<!-- 댓글목록 -->
<!-- 
<div class="content">
<ul>
   <li>
  <span class="col-sm-2">글번호</span>
  <span class="col-sm-5">글내용</span>
  <span class="col-sm-2">작성자</span>
  <span class="col-sm-2">삭제</span>
  </li>
</ul>
</div>
 -->

 <!-- 댓글페이징 -->
 <!-- 
 <div class="footer">
<nav aria-label="Page navigation example">
  <ul class="pagination pagination-sm justify-content-center">
    
  </ul>
</nav>
</div>
 -->
 <!-- 데이터테이블 활용 -->
 <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일시</th>
                
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일시</th>
                </tr>
        </tfoot>
    </table>
 
</div>

<script>
	let logid = "${loginId}"; // 자바의 변수값을 script 사용.
	const bno = "${board.boardNo }";
	console.log(bno);
	// 삭제버튼에 클릭이벤트 등록.
	document.querySelector('button.btn-danger').addEventListener('click',
			function(e) {
				let writer = document.querySelector('table.table>tbody>tr:nth-of-type(4)>td').innerHTML;
				let bno = document.querySelector('input[name="bno"]').value;
				if(writer == logid)
				location.href = "removeBoard.do?bno=" + bno;
				else
					alert("권한을 확인하세요.");
			});
</script>

<script src="js/replyService.js"></script>
<!-- <script src="js/reply.js"></script>-->
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
<script src="js/reply_dt.js"></script>
