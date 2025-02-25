<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Ajax연습페이지</h3>
<!-- 등록화면 -->
<table class="table">
  <tr>
  	<th>회원ID</th><td><input type="text" name="mid"></td>
  </tr>
  <tr>
  	<th>비밀번호</th><td><input type="text" name="mpw"></td>
  </tr>
  <tr>
  	<th>회원이름</th><td><input type="text" name="mname"></td>
  </tr>
  <tr>
  	<td colspan="2" align="center">
  	  <button id="addMember">추가</button>
    </td>
  </tr>
</table>

이름: <input type="text" name="name"><br>
나이: <input type="number" name="age">

<h3>회원목록</h3>
<table class="table">
  <thead>
    <tr><th>아이디</th><th>비번</th><th>이름</th><th>권한</th></tr>
  </thead>
  <tbody id="list">
    <!-- <tr><td>user01</td><td>1111</td><td>홍길동</td><td>User</td></tr> -->
  </tbody>
</table>

<script src="js/member.js"></script>