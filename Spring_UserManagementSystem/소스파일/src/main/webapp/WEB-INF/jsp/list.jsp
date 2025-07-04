<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
	<script
	  src="https://code.jquery.com/jquery-3.1.1.min.js"
	  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	  crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>
	
	
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>사용자 목록</h1>
		
		<!-- 검색 버튼 -->
		<form name="f" method='post'>
			<table border="0" width="1300">
				<tr>
					<td align="left">
						<!-- 사용자명 검색 -->
						<div class="ui action input">
							<input type='text' placeholder="사용자명을 입력하세요." name='name' style='width:100;' value='' required>
							<button class="ui blue button" onclick="submitname()">사용자 검색</button>
						</div>
						
						<!-- 폰번호로 검색 -->
						<div class="ui action input">
							<input type='text' placeholder="전화번호를 입력하세요." name='number' style='width:100;' value='' required>
							<button class="ui blue button" onclick="submitnumber()">번호로 검색</button>
						</div>
					</td>
					
					<td align="right">
						<!-- 목록 돌아가기 -->
						<button class="ui blue button" onclick="location.href='list'">전체 목록</button>
					</td>	
				</tr>
			</table>
		</form>
		
		<script>
		// 제출 함수
	    function submitname() {
			f.action = "userSearch"
			f.submit();
		}
		function submitnumber() {
			f.action = "phoneSearch"
			f.submit();
		}
		function submitcarrier() {
			f.action = "carrierSearch"
			f.submit();
		}
	    </script>
		
		<!-- 사용자 목록 -->	 
		<table class="ui large blue celled table" style="width: 1300px">
			<thead>
				<tr align=center>
		            <th width=50>id</th>
		            <th width=100>이름</th>
		            <th width=50>성별</th>
		            <th width=50>나이</th>
		            <th width=200>주소</th>
		            <th width=200>사용자 작업</th>
		            <th width=100>통신</th>
		            <th width=120>전화번호</th>
		            <th width=100>전화작업</th>
		        </tr>
	        <thead>
	        
			<c:forEach var="user" items="${users}">
				<!-- 폰이 없을 때 -->
				<c:if test="${fn:length(user.phoneList) == 0}">
					<tr align=center>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.sex}</td>
						<td>${user.age}</td>
						<td>${user.address}</td>
						<td>
							<div class="ui buttons">
							  <button class="ui button" onclick="location.href='userEdit?id=${user.id}'">수정</button>
							  <button class="ui button" onclick="location.href='userDelete?id=${user.id}'">삭제</button>
							  <button class="ui button" onclick="location.href='phoneNew?id=${user.id}'">전화추가</button>
							</div>
							</td>
						<td colspan="3"class="error"><i class="attention icon"></i>전화기를 등록하세요.</td>
					</tr>
				</c:if>
				
				<!-- 폰이 있을 때 -->
				<c:if test="${fn:length(user.phoneList) != 0}">
					<c:forEach var="phone" items="${user.phoneList}" varStatus="status">
						
						<!-- 첫줄일 때 -->
						<c:if test="${status.first eq true}">
							<tr align=center>
								<td rowspan="${fn:length(user.phoneList)}">${user.id}</td>
								<td rowspan="${fn:length(user.phoneList)}">${user.name}</td>
								<td rowspan="${fn:length(user.phoneList)}">${user.sex}</td>
								<td rowspan="${fn:length(user.phoneList)}">${user.age}</td>
								<td rowspan="${fn:length(user.phoneList)}">${user.address}</td>
								<td rowspan="${fn:length(user.phoneList)}">
									<div class="ui buttons">
									  <button class="ui button" onclick="location.href='userEdit?id=${user.id}'">수정</button>
									  <button class="ui button" onclick="location.href='userDelete?id=${user.id}'">삭제</button>
									  <button class="ui button" onclick="location.href='phoneNew?id=${user.id}'">전화추가</button>
									</div>
								</td>
								<td>${phone.carrier}</td>
								<td>${phone.number}</td>
								<td>
									<div class="ui buttons">
										<button class="ui button" onclick="location.href='phoneEdit?id=${phone.id}'">수정</button>
										<button class="ui button" onclick="location.href='deletePhone?id=${phone.id}'">삭제</button>
									</div>
								</td>
							</tr>
						</c:if>
						
						<!-- 나머지 줄일 때 -->
						<c:if test="${status.first eq false}">
	   						<tr align=center>
	   							<td>${phone.carrier}</td>
								<td>${phone.number}</td>
								<td>
									<div class="ui buttons">
										<button class="ui button" onclick="location.href='phoneEdit?id=${phone.id}'">수정</button>
										<button class="ui button" onclick="location.href='deletePhone?id=${phone.id}'">삭제</button>
									</div>
								</td>
							</tr>
						</c:if>
					
					</c:forEach>
				</c:if>
			</c:forEach>
		</table>
		
		<!-- 버튼 -->	 
		<table border="0" width="1300">
			<tr>
				<td align=right>
					<button class="ui blue button" onclick="location.href='userNew'">사용자 추가</button>
				</td>
			</tr>
		</table>
		
	</center>
	
	
</body>
</html>