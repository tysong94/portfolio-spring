<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
	<title>예약하기</title>
</head>
<body onload="itemChange()">
	<%@include file="top.jsp"%>
	<center>
		<h1>예약하기</h1>

		<form name='f' method='post' action='reservationCreate'>
		<table class="ui celled teal table" style="width: 500px">
			<tr>
				<td>예약자</td>
				<td>
					<c:choose>
						<%-- 관리자일 때 --%>
						<c:when test="${sessionUser.auth eq 'admin'}">
						<select name="user">
							<c:forEach var="user" items="${users}">
						  		<option value="${user.id}">${user.name}</option>
						  	</c:forEach>
						</select>
						</c:when>
						<%-- 사용자일 때 --%>
						<c:otherwise>
						<select name="user">
							<option value="${sessionUser.id}">${sessionUser.name}</option>
						</select>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>예약날짜</td>
				<td>
					<select name="date" id="select1" onchange="itemChange()">
						<c:forEach var="rVO" items="${rVOs}">
					  		<option date="${rVO.date}" 
					  				vip="${rVO.vip}" 
					  				common="${rVO.common}" 
					  				reasonable="${rVO.reasonable}" 
					  				<c:if test="${rVO.date eq reserve_date}">selected="selected"</c:if>>
					  		${rVO.date}
					  		</option>
					  	</c:forEach>
				  	</select>
				</td>
			</tr>
		
			<tr>
				<td>예약실</td>
				<td><select name="room" id="select2"></select></td>
			</tr>

			<script>
			function itemChange(){
				var select1 = $("#select1 option:selected");
				var date = select1.attr('date');                   //  id1234 추출
				var vip = select1.attr('vip');    // 010-1234-1234 추출
				var common = select1.attr('common');    // 010-1234-1234 추출
				var reasonable = select1.attr('reasonable');    // 010-1234-1234 추출
				 
				$('#select2').empty();
				
				if(vip == null || vip == "") {
					var option = $("<option value=1 <c:if test='${reserve_room == 1}'>selected='selected'</c:if>>VIP룸</option>");
		            $('#select2').append(option);
				} else {
					var option = $("<option value=1 disabled>VIP룸(예약됨)</option>");
		            $('#select2').append(option);
				}
				
				if(common == null || common == "") {
					var option = $("<option value=2 <c:if test='${reserve_room == 2}'>selected='selected'</c:if>>일반룸</option>");
		            $('#select2').append(option);
				} else {
					var option = $("<option value=2 disabled>일반룸(예약됨)</option>");
		            $('#select2').append(option);
				}
				
				if(reasonable == null || reasonable == "") {
					var option = $("<option value=3 <c:if test='${reserve_room == 3}'>selected='selected'</c:if>>합리적인룸</option>");
		            $('#select2').append(option);
				} else {
					var option = $("<option value=3 disabled>합리적인룸(예약됨)</option>");
		            $('#select2').append(option);
				}
			}
			</script>
			
			<tr>
				<td>남길 말</td>
				<td><input type='text' name='comment' style='width:300;' value=''></td>
			</tr>
		</table>
		
		<!-- 버튼 -->
	    <table border=0 style="width: 500px">
	        <tr align=right>
	            <td colspan=2>
	                <input type="button" class="ui teal button" value="예약목록" onclick="window.location='reservationList'">
	                <input type="button" class="ui teal button" value="예약하기" onclick="submit()">
	            </td>
	        </tr>        
	    </table>
		
		</form>
		
	</center>

</body>
</html>
