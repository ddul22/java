
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:include page="includes/header.jsp"></jsp:include>
	
	<!-- html주석문. -->

	<h3>게시글 목록(boardList.jsp)</h3>
  <form action="boardList.do">
  <div class="center">
    <div class="row">
      <div class="col-sm-4">
        <select class="form-control" name="searchCondition">
          <option value="">선택하세요</option>
          <option value="T" ${searchCondition == "T" ? "selected" : ""}>제목</option>
          <option value="W" ${searchCondition == "W" ? "selected" : ""}selected>작성자</option>
          <option value="TW" ${searchCondition == "TW" ? "selected" : ""}>제목&작성자</option>
        </select>
      </div>
      <div class="col-sm-5">
        <input type="text" class="form-control" name="keyword" value="${keyword }">
      </div>
      <div class="col-sm-2">
        <input closs="btn btn-primary" type="submit" value="조회">
      </div>
    </div>
  </div>
  </form>
	<table class="table table-striped">
		<ul>
		<tbody>
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
		</tr>		
		<c:forEach var="board" items="${list }">
			<tr>
			    <td>${board.boardNo}</td>
				<td><a href="board.do?bno=${board.boardNo }"><c:out value="${board.title }"></c:out></a></td>
				<td><c:out value="${board.writer }"></c:out></td>
				<td><c:out value="${board.writeDate }"></c:out></td>
				<td><c:out value="${board.viewCnt }"></c:out></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<!-- paging 시작 -->
	<nav aria-label="...">
  <ul class="pagination">
  	<!-- 이전 페이지 여부. -->
  	<c:choose>
  	<c:when test="${paging.prev }">
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=${paging.startPage - 1 }">Previous</a>
    </li>
    </c:when>
    <c:otherwise>
    <li class="page-item disabled">
      <span class="page-link">Previous</span>
    </li>
    </c:otherwise>
    </c:choose>
    
    <!-- 페이지 start ~ end 반복-->
	<c:forEach var="p" begin="${paging.startPage }" end="${paging.endPage }">
    <c:choose>
      <c:when test="${p == paging.currentPage }">
    <li class="page-item active" aria-current="page">
      <span class="page-link"><c:out value="${p }" ></c:out></span>
    </li>
    </c:when>
    <c:otherwise>
    <li class="page-item"><a class="page-link" href="boardList.do?page=${p }&searchCondition=${searchCondition}&keyword=${keyword}">${p }</a></li>
    </c:otherwise>
    </c:choose>
    </c:forEach>
    
    	<!-- 이후 페이지 여부. -->
	<c:choose>
	  <c:when test="${paging.next }">
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=${paging.endPage + 1 }&searchCondition=${searchCondition}&keyword=${keyword}">Next</a>
    </li>
      </c:when>
      <c:otherwise>
    <li class="page-item disabled">
      <span class="page-link">Next</span>
    </li>
    </c:otherwise>
	</c:choose>
  </ul>
</nav>
    <!-- paging 끝 -->
	</ul>
<jsp:include page="includes/footer.jsp"></jsp:include>