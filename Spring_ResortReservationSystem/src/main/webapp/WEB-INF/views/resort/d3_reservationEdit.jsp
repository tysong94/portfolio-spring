<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<title>예약 변경</title>
</head>
<body>
	<%@include file="top.jsp"%>
	<center>
		<h1>예약 변경</h1>

		<form name='f' method='post' action='reservationUpdate'>
		<table class="ui celled teal table" style="width: 500px">
			<tr>
				<td>예약번호</td>
				<td><input name='id' type='text' style='width:300;' value='${rsvn.id}' readonly='readonly'></td>
			</tr>
			<tr>
				<td>예약자</td>
				<td>
					<c:choose>
					<%-- 관리자일 때 --%>
					<c:when test="${sessionUser.auth eq 'admin'}">
						<select name="user">
							<c:forEach var="u" items="${users}">
						  		<option value="${u.id}" <c:if test="${u.id eq rsvn.user.id}">selected="selected"</c:if>>${u.name}</option>
						  	</c:forEach>
						</select>
					</c:when>
					<%-- 사용자일 때 --%>
					<c:when test="${sessionUser.auth eq 'user'}">
						<select name="user">
				  			<option value="${rsvn.user.id}" selected="selected">${rsvn.user.name}</option>
						</select>
					</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>예약날짜</td>
				<td>
					<select name="date">
						<c:forEach var="d" items="${dates}">
							<fmt:formatDate value="${rsvn.date}" var="dd" pattern="yyyy-MM-dd(E)"/>
					  		<option value="${d}" <c:if test="${d eq dd}">selected="selected"</c:if>>${d}</option>
					  	</c:forEach>
				  	</select>
				</td>
			</tr>
			<tr>
				<td>예약실</td>
				<td>
					<select name="room">
					  <c:forEach var="r" items="${rooms}">
					  	<option value="${r.id}" <c:if test="${r.id eq rsvn.room.id}">selected="selected"</c:if>>
					  		<c:if test="${r.id == 1}">VIP룸</c:if>
					  		<c:if test="${r.id == 2}">일반룸</c:if>
					  		<c:if test="${r.id == 3}">합리적인룸</c:if>
					  	</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>남길 말</td>
				<td><input name='comment' type='text' style='width:300;' value=''></td>
			</tr>
		</table>
		<!-- 버튼 -->
	    <table border=0 width="500">
	        <tr align=right>
	            <td colspan=2>
	                <input type="button" class="ui teal button" value="예약목록" onclick="window.location='reservationList'">
	                <input type="button" class="ui teal button" value="수정" onclick="submit()">
	            </td>
	        </tr>        
	    </table>
		
		</form>
	</center>
	</div>
</body>
</html>
