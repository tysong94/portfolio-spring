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
		<h1>사용자 추가</h1>
		
	    <form class="ui form" name='f' method='post' action='save' style='width: 300px;'>
		    <!-- 내용 -->
	    	<input type='hidden' name='id' style='width:300;' value='0'>
		    
		    <div class="field">
				<label align="left">이름</label>
		        <input type="text" name="name" placeholder="이름을 입력하세요." style='width:200;' value='' required></td>
	       	</div>
	       	
		    <div class="inline fields">
	            <label for="sex" align="left">성별</label>
	            <div class="ui radio check">
		           	<input type="radio" name="sex" value="남자" checked="checked" class="hidden">
		           	<label>남자</label>
		        </div>
		        <div class="ui radio check">
					<input type="radio" name="sex" value="여자" class="hidden">
					<label>여자</label>
				</div>
			</div>
			
			<div class="field">
		       <label align="left">나이</label>
		       <input type='text' name='age' placeholder="나이를 입력하세요." style='width:200;' value='' required>
			</div>
			
			<div class="field">
		      <label align="left">주소</label>
		      <input type='text' name='address' placeholder="주소를 입력하세요." style='width:200;' value='' required>
			</div>

		    <!-- 버튼 -->
		    <table border=0 width=300>
		        <tr align=right>
		            <td colspan=2>
		                <input type="button" class="ui blue button" value="목록" onclick="window.location='list'">
		                <input type="button" class="ui blue button" value="추가" onclick="submitform()">
		            </td>
		        </tr>        
		    </table>
	    </form>
    </center>
	    
	    <script>
	 	// 공백만 있을 때 체크 함수
	    function checkBlank(obj) {
	        var obj2 = obj.replace(/ /gi, "");    // 모든 공백을 제거
	        if(!(obj2 == '') && !(obj2 == null)) {
	            return true;
	        } else {
	            alert('항목을 입력하세요.');
	        }
	    }
	    
		// 이름 한글 체크 함수
	    function checkKor(obj) { 
	        var pattern = /^[가-힣]*$/;
	        if (pattern.test(obj)) { 
	            return true;
	        } else {
	            alert('이름은 한글만 가능합니다.');
	        }
	    }
		 
	 	// 나이 숫자 체크 함수
	    function checkNum(obj) { 
	        var pattern = /^[0-9]*$/;
	        if (pattern.test(obj)) { 
	            return true;
	        } else {
	            alert('나이는 숫자만 가능합니다.');
	        }
	    }  
	 	
	 	// 나이 숫자 체크 함수
	    function checkAge(obj) { 
	        if (obj <= 150) { 
	            return true;
	        } else {
	            alert('나이는 150살 까지만 가능합니다.');
	        }
	    }  
		
	 	// 길이 체크 함수
	    function checkLength(obj, objname, leng) {
	        if(obj.length <= leng) {
	            return true;
	        } else {
	            alert(objname+' 최대 '+leng+'글자만 입력 가능합니다.');
	        }
	    }
	 	
	 	// 제출 함수
	    function submitform() {
	        var name = f.name.value;
	        var age = f.age.value;
	        var address = f.address.value;

       		if(checkBlank(name) && checkKor(name) && checkLength(name, '이름은', 4)  
	            && checkBlank(age) && checkNum(age) && checkAge(age)   
	            && checkBlank(address) && checkLength(address, '주소는', 30)  
	        ) { 
	        	f.submit(); 
	        }
	    }
	    </script>
	    
    
</body>
</html>