<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <!-- css(cascading style sheets) -->
    <style type='text/css'>
        html { background: url(/board/resources/background.jpg) no-repeat center center fixed; -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;}
        td { font-size: 12; text-align: center}
        a:link { text-decoration: none; }
        a:visited { text-decoration: none; }
        a:hover { text-decoration: none; }
        a:active { text-decoration: none; }
    </style>
</head>
<body>
	<%@include file="top.jsp"%>
	
    <center>
    <h1>찾아오는길<h1>
    <!--
	* Daum 지도 - 약도서비스
	* 한 페이지 내에 약도를 2개 이상 넣을 경우에는
	* 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
    -->
    <!-- 1. 약도 노드 -->
    <div id="daumRoughmapContainer1533183054931" class="root_daum_roughmap root_daum_roughmap_landing"></div>

    <!-- 2. 설치 스크립트 -->
    <script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>

    <!-- 3. 실행 스크립트 -->
    <script charset="UTF-8">
        new daum.roughmap.Lander({
            "timestamp" : "1533183054931",
            "key" : "pbvi",
            "mapWidth" : "520",
            "mapHeight" : "300"
        }).render();
    </script>
    </center>
</body>
</html>