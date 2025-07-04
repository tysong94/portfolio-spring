<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>폰 목록</h1>
		
		<!-- 사용자 내용 -->
		<table border=1 width=700>
			<tr align=center>
				<td>사용자 id</td>
				<td>사용자 이름</td>
			</tr>
			<tr align=center>
				<td>${user.id}</td>
				<td>${user.name}</td>
			</tr>
		</table>
		
		<!-- 사용자 수정 -->
	    <table border=0 width=700>
	        <tr align=right>
	            <td colspan=2>
	            	<input type='button' value='목록' onclick="location.href='list'">
	                <input type='button' value='수정' onclick="location.href='editForm?id=${user.id}'">
	                <input type='button' value='삭제' onclick="location.href='delete?id=${user.id}'">
	            </td>
	        </tr>        
	    </table>
		
		<br>
		<br>
		
		<!-- 폰 목록 -->	 
		<table border=1 width=700>
			<tr align=center>
	            <td width=100>폰 id</td>
	            <td width=100>폰 user_id</td>
	            <td width=100>폰 number</td>
	            <td width=100>수정</td>
	            <td width=100>삭제</td>
	        </tr>
	        
			<c:forEach var="phone" items="${user.phoneList}">	
				<tr align=center>
					<td>${phone.id}</td>
					<td>${phone.user.id}</td>
					<td>${phone.number}</td>
					<td><input type='button' value='수정' onclick="location.href='editPhone?id=${phone.id}'"></td>
	                <td><input type='button' value='삭제' onclick="location.href='deletePhone?id=${phone.id}'"></td>
				</tr>			
			</c:forEach>
		</table>
		
	</center>
</body>
</html>