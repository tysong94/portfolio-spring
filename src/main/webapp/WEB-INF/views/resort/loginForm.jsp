<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
</head>
<body>
	<%@include file="top.jsp"%>
	<center>
		<h1>로그인 페이지</h1>
	</center>
	<div class="page-login">
	  <div class="ui centered grid container">
	    <div class="nine wide column">
<!-- 	      <div class="ui icon warning message"> -->
<!-- 	          <i class="lock icon"></i> -->
<!-- 	          <div class="content"> -->
<!-- 	            <div class="header"> -->
<!-- 	              Login failed! -->
<!-- 	            </div> -->
<!-- 	            <p>You might have misspelled your username or password!</p> -->
<!-- 	          </div> -->
<!-- 	        </div> -->
	      <div class="ui fluid card">
	        <div class="content">
	        <form class="ui form" method="POST" action='login'>
	          <div class="field">
	            <label>사용자ID</label>
	            <input type="text" name="userid" placeholder="User">
	          </div>
	          <div class="field">
	            <label>비밀번호</label>
	            <input type="password" name="password" placeholder="Password">
	          </div>
	          <button class="ui teal primary labeled icon button" type="submit">
	            <i class="unlock alternate icon"></i>
				로그인
	          </button>
	        </form>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>