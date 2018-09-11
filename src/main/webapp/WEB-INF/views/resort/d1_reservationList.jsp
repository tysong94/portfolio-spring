<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<title>예약리스트</title>
</head>

<body>
	<%@include file="top.jsp"%>
	
	<center>
		<h1>예약리스트</h1>
		
		<!-- 리스트 -->	 
		<table class="ui celled blue table" style="width: 700px">
			<thead>
			<tr align=center>
				<th width=100>날짜</th>
				<th width=100>VIP룸</th>
				<th width=100>일반룸</th>
				<th width=100>합리적인룸</th>
			</tr>
			</thead>
	     	
			<c:forEach var="rVO" items="${reservationVOs}">
				<tr align=center>
					<!-- 날짜 -->
					<td width=100>
						<c:choose>
							<c:when test="${fn:contains(rVO.date, '토')}"><font color="blue">${rVO.date}</font></c:when>
							<c:when test="${fn:contains(rVO.date, '일')}"><font color="red">${rVO.date}</font></c:when>
							<c:otherwise>${rVO.date}</c:otherwise>
						</c:choose>
					</td>
					<!-- vip룸 -->
					<td width=100>
						<c:choose>
							<c:when test="${rVO.vip eq null}"><a href="reservationNew?date=${rVO.date}&room=1">예약가능</a></c:when>
							<%-- 관리자일 때 --%>
							<c:when test="${sessionUser.auth eq 'admin'}">
								${rVO.vip.user.name}
								<a href="reservationEdit?rid=${rVO.vip.id}">[수정]</a>
								<a href="reservationDelete?rid=${rVO.vip.id}">[삭제]</a>
							</c:when>
							<%-- 사용자의 예약일 때 --%>
							<c:when test="${rVO.vip.user.id eq sessionUser.id}">
								${rVO.vip.user.name}
								<a href="reservationEdit?rid=${rVO.vip.id}">[수정]</a>
								<a href="reservationDelete?rid=${rVO.vip.id}">[삭제]</a>
							</c:when>
							<%-- 사용자의 예약이 아닐 때, 손님일 때 --%>
							<c:otherwise>${rVO.vip.user.name}</c:otherwise>
						</c:choose>
					</td>
					<!-- 일반룸 -->
					<td width=100>
						<c:choose>
							<c:when test="${rVO.common eq null}"><a href="reservationNew?date=${rVO.date}&room=2">예약가능</a></c:when>
							<%-- 관리자일 때 --%>
							<c:when test="${sessionUser.auth eq 'admin'}">
								${rVO.common.user.name}
								<a href="reservationEdit?rid=${rVO.common.id}">[수정]</a>
								<a href="reservationDelete?rid=${rVO.common.id}">[삭제]</a>
							</c:when>
							<%-- 사용자의 예약일 때 --%>
							<c:when test="${rVO.common.user.id eq sessionUser.id}">
								${rVO.common.user.name}
								<a href="reservationEdit?rid=${rVO.common.id}">[수정]</a>
								<a href="reservationDelete?rid=${rVO.common.id}">[삭제]</a>
							</c:when>
							<%-- 사용자의 예약이 아닐 때, 손님일 때 --%>
							<c:otherwise>${rVO.common.user.name}</c:otherwise>
						</c:choose>
					</td>
					<!-- 합리적인룸 -->
					<td width=100>
						<c:choose>
							<c:when test="${rVO.reasonable eq null}"><a href="reservationNew?date=${rVO.date}&room=3">예약가능</a></c:when>
							<%-- 관리자일 때 --%>
							<c:when test="${sessionUser.auth eq 'admin'}">
								${rVO.reasonable.user.name}
								<a href="reservationEdit?rid=${rVO.reasonable.id}">[수정]</a>
								<a href="reservationDelete?rid=${rVO.reasonable.id}">[삭제]</a>
							</c:when>
							<%-- 사용자의 예약일 때 --%>
							<c:when test="${rVO.reasonable.user.id eq sessionUser.id}">
								${rVO.reasonable.user.name}
								<a href="reservationEdit?rid=${rVO.reasonable.id}">[수정]</a>
								<a href="reservationDelete?rid=${rVO.reasonable.id}">[삭제]</a>
							</c:when>
							<%-- 사용자의 예약이 아닐 때, 손님일 때 --%>
							<c:otherwise>${rVO.reasonable.user.name}</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
