<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE jsp>

<jsp>
<html>
<head>
    <meta http-equiv='content-type' content='text/jsp; charset=utf-8' />

    <!-- css(cascading style sheets) -->
    <style type='text/css'>
        jsp { background: url(/board/resources/background.jpg) no-repeat center center fixed; -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;}
        td { font-size: 12; }
        a:link { text-decoration: none; }
        a:visited { text-decoration: none; }
        a:hover { text-decoration: none; }
        a:active { text-decoration: none; }
    </style>
    <!-- 메뉴 선택적으로 보이게 하기 -->
    <script language='javascript' type='text/javascript'> //<![CDATA[
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
    //]]></script>    
</head>
<body>
    <center>
        <!-- 전체 테이블 -->
        <table cellpadding='0' style='text-align: center;' cellspacing='1' border='0' width='1000' height='100'>
            <tr height='50'>
                <!-- 로고 -->
                <td rowspan='2' width='150'><a href='0_2_main.jsp' ><img src="/board/resources/sun.png" width='150' height='100'></a></td>
                <!-- 메인메뉴 -->
                <td width='150' onmouseover="fncShow(0);" id='m0'>리조트소개</td>
                <td width='150' id='m1' onmouseover="fncShow(1);">찾아오기</td>
                <td width='150' id='m2' onmouseover="fncShow(2);">주변여행지</td>
                <td width='150' id='m3' onmouseover="fncShow(3);">예약하기</td>
                <td width='150' id='m4' onmouseover="fncShow(4);">리조트소식</td>
            </tr>
            <tr height='50'>
                <td colspan='5'>
                    <table id='menu0' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='0' width='850'>
                        <tr>
                            <td align='left'>
                                <a href='main'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|조아 리조트</span>
                                </a>
                                <a href='vip'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|VIP룸</span>
                                </a>
                                <a href='common'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|일반룸</span>
                                </a>
                                <a href='reasonable'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|합리적인룸|</span>
                                </a>
                            </td>
                        </tr>
                    </table>
                    <table id='menu1' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='0' width='850'>
                        <tr>
                            <td width='150'></td>
                            <td>
                                <a href='way'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|찾아오는길</span>
                                </a>
                                <a href='publicc'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|대중교통이용</span>
                                </a>
                                <a href='own'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|자가용이용|</span>
                                </a>
                            </td>
                        </tr>
                    </table>
                    <table id='menu2' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='0' width='850'>
                        <tr>
                            <td width='300'></td>
                            <td>
                                <a href='attractions1'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|높아산</span>
                                </a>
                                <a href='attractions2'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|조아해수욕장</span>
                                </a>
                                <a href='attractions3'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|따끈온천|</span>
                                </a>
                            </td>
                        </tr>
                    </table>
                    <table id='menu3' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='0' width='850'>
                        <tr>
                            <td width='450'></td>
                            <td>
                                <a href='reservationList'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|예약상황</span>
                                </a>
                                <a href='reservationForm'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|예약하기</span>
                                </a>
                                <a href='main'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|관리자페이지</span>
                                </a>
                                <a href='main'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|관리자로그아웃|</span>
                                </a>
                            </td>
                        </tr>
                    </table>
                    <table id='menu4' style='display: none; text-align: left;' cellpadding='0' cellspacing'0' border='0' width='850'>
                        <tr>
                            <td width='600'></td>
                            <td>
                                <a href='main'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|리조트소식</span>
                                </a>
                                <a href='main'>
                                <span onmouseover=this.style.color='#ff0000' onmouseout=this.style.color='#000000'>|이용후기|</span>
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>  
            </tr>
        </table>
    </center>
    
</body>
</jsp>