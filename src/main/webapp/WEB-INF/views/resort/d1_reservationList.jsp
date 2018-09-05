<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

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
	     	
			<c:forEach var="reservationVO" items="${reservationVOs}" >
				<tr align=center>
					<td width=100>
						<c:choose>
							<c:when test="${fn:contains(reservationVO.date, '토')}"><font color="blue">${reservationVO.date}</font></c:when>
							<c:when test="${fn:contains(reservationVO.date, '일')}"><font color="red">${reservationVO.date}</font></c:when>
							<c:otherwise>${reservationVO.date}</c:otherwise>
						</c:choose>
					</td>
					<td width=100>
						<c:choose>
							<c:when test="${reservationVO.vip == '예약가능'}"><a href="reservationForm?date=${reservationVO.date}&room=1">예약가능</a></c:when>
							<c:otherwise>${reservationVO.vip}</c:otherwise>
						</c:choose>
					</td>
					<td width=100>
						<c:choose>
							<c:when test="${reservationVO.common == '예약가능'}"><a href="reservationForm?date=${reservationVO.date}&room=2">예약가능</a></c:when>
							<c:otherwise>${reservationVO.common}</c:otherwise>
						</c:choose>
					</td>
					<td width=100>
						<c:choose>
							<c:when test="${reservationVO.reasonable == '예약가능'}"><a href="reservationForm?date=${reservationVO.date}&room=3">예약가능</a></c:when>
							<c:otherwise>${reservationVO.reasonable}</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
	</div>
</body>
</html>
