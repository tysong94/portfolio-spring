<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	  function requestJson() {
	      $.ajax({
	          type  : "GET",
	          url   : "https://openapi.gg.go.kr/Sidoatmospolutnmesure",
	          async : false,
	          contentType : "application/json; charset=utf-8",
	          dataType : 'text',
	          data : {
	          	"KEY" : "a5cb41819c7346fd9d6f5c8e086e00ef",
	          	"TYPE" : "json",
	          	"pIndex" : 1,
	          	"pSize" : 100,
	          	"SIGUN_CD" : 41130
	          },
	          // jquery의 ajaㅌ 요청을 서버로 보내고, 응답이 다 오면 이 함수가 호출(callback). 여기가 custom하다.
	          success : function(json) {
	          	var obj = JSON.parse(json); // string을 json으로 parsing함.
	              console.log(obj);
	              console.log(obj.Sidoatmospolutnmesure);
	              $('#target').text("abcd");
	          }
	      });    
	  }
	  
	function requestXml() {
	      $.ajax({
	          type  : "GET",
	          url   : "http://www.kma.go.kr/repositary/xml/fct/mon/img/fct_mon3rss_108_20180823.xml",
	          async : false,
	          contentType : "appllication/xml; charset=utf-8",
	          success : function(xml) {
	             var obj = XML.parse(xml);
	             console.log(obj);
	          }
	      });
	  }
	  
	</script>
</head>
<body>
	<%@include file="top.jsp"%>
	<center>
	    <img src="/resources/resort.jpg" width="400" height="350"><br>
	    <h1>태양 리조트에 놀러오세요!</h1>
		
		<button onclick="requestJson()">requestJson</button>
		<button onclick="requestXml()">requestXml</button>
	    
	    <div id="target">target</div>
    </center>
</body>
</html>