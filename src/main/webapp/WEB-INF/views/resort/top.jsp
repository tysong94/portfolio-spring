<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv='content-type' content='text/jsp; charset=utf-8' />

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
	<script
	  src="https://code.jquery.com/jquery-3.1.1.min.js"
	  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	  crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>
	
	<style type="text/css">
	body { background: url(resources/background.jpg) no-repeat center center fixed; 
	-webkit-background-size: cover; 
	-moz-background-size: cover; 
	-o-background-size: cover; 
	background-size: cover; }
	</style>
	
</head>
<body>
	<div class="ui right aligned container">
		<c:if test="${sessionUser eq null}"><a href="loginForm">로그인</a></c:if>
	    <c:if test="${sessionUser ne null}">${sessionUser.name}님, 환영합니다.<a href="logout">|로그아웃</a></c:if>
	</div>
	
	<div class="ui center aligned container">
		<div class="ui teal fluid six item inverted menu" >
			<a href="main" class="header item"><img class="logo" src="resources/logo2.jpg">&nbsp태양리조트</a>
			
			<div class="ui simple dropdown item">리조트소개<i class="dropdown icon"></i>
				<div class="menu">
				<a class="item" href="main">태양리조트</a>
				<a class="item" href="vip">VIP룸</a>
				<a class="item" href="common">일반룸</a>
				<a class="item" href="reasonable">합리적인룸</a>
				</div>
			</div>
			
			<div class="ui simple dropdown item">찾아오기<i class="dropdown icon"></i>
				<div class="menu">
				<a class="item" href="way">찾아오는길</a>
				<a class="item" href="publicc">대중교통이용</a>
				<a class="item" href="own">자가용이용</a>
				</div>
			</div>
			
			<div class="ui simple dropdown item">주변여행지<i class="dropdown icon"></i>
				<div class="menu">
				<a class="item" href="attractions1">높아산</a>
				<a class="item" href="attractions2">조아해수욕장</a>
				<a class="item" href="attractions3">따끈온천</a>
				</div>
			</div>
	
			<div class="ui simple dropdown item">예약하기<i class="dropdown icon"></i>
				<div class="menu">
				<a class="item" href="reservationList">예약상황</a>
				<a class="item" href="reservationNew">예약하기</a>
				</div>
			</div>
			        
		</div>
	</div>
	
</body>
</html>
<!-- 			<div class="ui simple dropdown item">리조트소개<i class="dropdown icon"></i> -->
<!-- 				<div class="menu"> -->
<!-- 				<a class="item" href="#">리조트소식</a> -->
<!-- 				<a class="item" href="#">이용후기</a> -->
<!-- 				</div> -->
<!-- 			</div> -->

    <!-- css(cascading style sheets) -->
<!--     <style type='text/css'>
	     html { background: url(/resources/background.jpg) no-repeat center center fixed; 
	     -webkit-background-size: cover;
	     -moz-background-size: cover;
	     -o-background-size: cover;
	     background-size: cover;}
	     td { font-size: 15; }
	     a:link { text-decoration: none; }
	     a:visited { text-decoration: none; }
	     a:hover { text-decoration: none; }
	     a:active { text-decoration: none; }
    </style> -->

    <!-- 메뉴 선택적으로 보이게 하기 -->
    <!-- <script language='javascript' type='text/javascript'> 
    //<![CDATA[
		function fncShow(pos) {
		    var i = 0;
		    var muCnt = 5;
		    for(i; i<muCnt; i++) {
		        var m = document.getElementById("m" + i);
		        var menu = document.getElementById("menu" + i);
		        if(i == pos) {
		            m.style.color = '#ff0000';
		            menu.style.display = '';
		        } else {
		            m.style.color = '#000000';
		            menu.style.display = 'none';
		        }
		    }
		}
        function fncHide(pos) {
            var obj = document.getElementById('menu'+pos);
            obj.style.display = 'none';
        }
    //]]>
    </script>     -->

<%--     <center> --%>
<!--         전체 테이블 -->
<!--         <table cellpadding='0' style='text-align: center;' cellspacing='1' border='1' width='1000' height='100'> -->
<!--             <tr height='50'> -->
<!--                 로고 -->
<!--                 <td rowspan='2' width='150'><a href='0_2_main.jsp' ><img src="/resources/sun.png" width='150' height='100'></a></td> -->
<!--                 메인메뉴 -->
<!--                 <td width='150' onmouseover="fncShow(0);" id='m0'>리조트소개</td> -->
<!--                 <td width='150' id='m1' onmouseover="fncShow(1);">찾아오기</td> -->
<!--                 <td width='150' id='m2' onmouseover="fncShow(2);">주변여행지</td> -->
<!--                 <td width='150' id='m3' onmouseover="fncShow(3);">예약하기</td> -->
<!--                 <td width='150' id='m4' onmouseover="fncShow(4);">리조트소식</td> -->
<!--                 <td width='100' rowspan='2'> -->
<%--                 	<c:if test="${auth eq null}">고객님, 환영합니다.<button onclick="location.href='loginForm'">로그인</button></c:if> --%>
<%--                 	<c:if test="${auth ne null}">${userid}님, 환영합니다.<button onclick="location.href='logout'">로그아웃</button></c:if> --%>
<!--                 </td> -->
<!--             </tr> -->
<!--             <tr height='50'> -->
<!--                 <td colspan='5'> -->
<!--                     <table id='menu0' style='display: none; text-align: left;' cellpadding='0' cellspacing='0' border='1' width='850'> -->
<!--                         <tr> -->
<!--                             <td align='left'> -->
<!--                                 <a href='main'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|조아 리조트</span> -->
<!--                                 </a> -->
<!--                                 <a href='vip'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|VIP룸</span> -->
<!--                                 </a> -->
<!--                                 <a href='common'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|일반룸</span> -->
<!--                                 </a> -->
<!--                                 <a href='reasonable'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|합리적인룸|</span> -->
<!--                                 </a> -->
<!--                             </td> -->
<!--                         </tr> -->
<!--                     </table> -->
<!--                     <table id='menu1' style='display: none; text-align: left;' cellpadding='0' cellspacing='0' border='1' width='850'> -->
<!--                         <tr> -->
<!--                             <td width='150'></td> -->
<!--                             <td> -->
<!--                                 <a href='way'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|찾아오는길</span> -->
<!--                                 </a> -->
<!--                                 <a href='publicc'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|대중교통이용</span> -->
<!--                                 </a> -->
<!--                                 <a href='own'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|자가용이용|</span> -->
<!--                                 </a> -->
<!--                             </td> -->
<!--                         </tr> -->
<!--                     </table> -->
<!--                     <table id='menu2' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='1' width='850'> -->
<!--                         <tr> -->
<!--                             <td width='300'></td> -->
<!--                             <td> -->
<!--                                 <a href='attractions1'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|높아산</span> -->
<!--                                 </a> -->
<!--                                 <a href='attractions2'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|조아해수욕장</span> -->
<!--                                 </a> -->
<!--                                 <a href='attractions3'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|따끈온천|</span> -->
<!--                                 </a> -->
<!--                             </td> -->
<!--                         </tr> -->
<!--                     </table> -->
<!--                     <table id='menu3' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='1' width='850'> -->
<!--                         <tr> -->
<!--                             <td width='450'></td> -->
<!--                             <td> -->
<!--                                 <a href='reservationList'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|예약상황</span> -->
<!--                                 </a> -->
<!--                                 <a href='reservationNew'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|예약하기</span> -->
<!--                                 </a> -->
<!--                                 <a href='admin'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|관리자페이지</span> -->
<!--                                 </a> -->
<!--                             </td> -->
<!--                         </tr> -->
<!--                     </table> -->
<!--                     <table id='menu4' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='1' width='850'> -->
<!--                         <tr> -->
<!--                             <td width='600'></td> -->
<!--                             <td> -->
<!--                                 <a href='main'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|리조트소식</span> -->
<!--                                 </a> -->
<!--                                 <a href='main'> -->
<!--                                 <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|이용후기|</span> -->
<!--                                 </a> -->
<!--                             </td> -->
<!--                         </tr> -->
<!--                     </table> -->
<!--                 </td>   -->
<!--             </tr> -->
<!--         </table> -->