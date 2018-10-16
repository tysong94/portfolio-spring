<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<h1>전화기 수정</h1>
	   
	    <form class="ui form" name='f' method='post' action='savePhone' style='width: 300px;' align="center">
	    	<!-- 내용 -->
	    	<div class="field">
            	<label align="left">폰 id</label>	
	            <input type='text' name='phoneid' style='width:200;' value='${phone.id}' readonly>
	        </div>
	    	<div class="field">
	            <label align="left">사용자 id</label>
	            <input type='text' name='userid' style='width:200;' value='${phone.user.id}' readonly>
	        </div>
         	<div class="field">
	            <label align="left">통신사</label>
            	<select name="carrier" class="ui search dropdown">
					<option value="KT" <c:if test="${phone.carrier eq 'KT'}">selected="selected"</c:if>>KT</option>
					<option value="LGT" <c:if test="${phone.carrier eq 'LGT'}">selected="selected"</c:if>>LGT</option>
					<option value="SKT" <c:if test="${phone.carrier eq 'SKT'}">selected="selected"</c:if>>SKT</option>
				</select>
	        </div>
	        <div class="field">
	            <label align="left">번호</label>
	            <input type='text' name='number' style='width:200;' value='${phone.number}' required>
	        </div>
		
		    <!-- 버튼 -->
		    <table border=0 width=300>
		        <tr align=right>
		            <td colspan=2>
		                <input class="ui blue button" type='button' value='취소' onclick="window.location='list'">
		                <input class="ui blue button" type='button' value='수정' onclick="submitform()">
		            </td>
		        </tr>        
		    </table>
	    </form>
    
	    <script>
	 	// 공백만 있을 때 체크 함수
	    function checkBlank(obj) {
	        var obj2 = obj.replace(/ /gi, "");    // 모든 공백을 제거
	        if(!(obj2 == '') && !(obj2 == null)) {
	            return true;
	        } else {
	            alert('번호 항목을 입력하세요.');
	        }
	    }
	    
	 	// 폰 번호 유효성 체크 함수
	    function checkPhone(obj) {
		    var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		    if ( !regExp.test(obj) ) {
		        alert("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
		  	} else {
		        return true;
		  	}
	    }
	    
	    
	 	// 제출 함수
	    function submitform() {
	        var number = f.number.value;

       		if(checkBlank(number) && checkPhone(number)) { 
	        	f.submit(); 
	        }
	    }
	    </script>
    
    </center>
</body>
</html>