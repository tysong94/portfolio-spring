<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
	<script
	  src="https://code.jquery.com/jquery-3.1.1.min.js"
	  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	  crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>
	
	<title>예약리스트</title>
</head>
<body>
	<div style="background-image: url('resources/background.jpg') ; background-size: cover; height: 100%;">
	<%@include file="top.jsp"%>
	<center>
		<h1>예약하기</h1>

		<form name='f' method='post' action='reservation' style='width: 300px;'>
		<table class="ui celled blue table" style="width: 700px">
			<tr>
				<td>예약자</td>
				<td>
					<select name="user">
						<c:forEach var="user" items="${all_users}">
					  		<option value="${user.id}">${user.name}</option>
					  	</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>예약날짜</td>
				<td>
					<select name="date">
						<c:forEach var="all_date" items="${all_dates}">
					  		<option value="${all_date}" <c:if test="${all_date eq reserve_date}">selected="selected"</c:if>>${all_date}</option>
					  	</c:forEach>
				  	</select>
				</td>
			</tr>
			<tr>
				<td>예약실</td>
				<td>
					<select name="room">
					  <c:forEach var="all_room" items="${all_rooms}">
					  	<option value="${all_room.type}" <c:if test="${all_room.type eq reserve_room}">selected="selected"</c:if>>
					  		<c:if test="${all_room.type == 1}">VIP룸</c:if>
					  		<c:if test="${all_room.type == 2}">일반룸</c:if>
					  		<c:if test="${all_room.type == 3}">합리적인룸</c:if>
					  	</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>남길 말</td>
				<td><input type='text' name='comment' style='width:300;' value=''></td>
			</tr>
		</table>
		<!-- 버튼 -->
	    <table border=0 width=300>
	        <tr align=right>
	            <td colspan=2>
	                <input type="button" class="ui blue button" value="예약목록" onclick="window.location='reservationList'">
	                <input type="button" class="ui blue button" value="예약하기" onclick="submit()">
	            </td>
	        </tr>        
	    </table>
		
		</form>
	</center>
	</div>
</body>
</html>
