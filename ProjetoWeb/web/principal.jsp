<%-- 
    Document   : index
    Created on : 11/05/2018, 18:43:28
    Author     : mathe
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gravity</title>
        <link type="text/css" rel="stylesheet" href="projeto1.css"/>
    </head>
    <body>

        <%
            if (request.getSession().getAttribute("logado") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <div class="menu">
            <ul class="font text">
                <li><a href="" style="text-decoration: none; color: inherit;">HOME</a></li>
                <li><a href="" style="text-decoration: none; color: inherit;">LAYOUTS</a></li>
                <li><a href="LogoutServlet" style="text-decoration: none; color: inherit;">LOGOUT</a></li>
                <li class="bordered">SIGN UP</li>

            </ul>
        </div>
        <div class="header">
            <p class="title font text">GRAVITY</p>
            <p class="caption font text minor_text">LOREM IPSUM DOLOR SIT AMET</p>
            <img src="menu_icon.png" class="menu_icon"/>
        </div>
        <div class="container">
            <img class="backImg" src="landscape.jpg" alt="landscape"/>
            <p class="title1 font">MAGNA SED IPSUM DOLOR DOLOR</p>
            <p class="caption1 font minor_text">SED VEROEROS LOREM MAGNA TEMPUS TEMPUS ET AMET LOREM CURSUS.</p>
            <p class="learn_more font minor_text">LEARN MORE</p>   
            <div class="container2">
                <div>
                    <img src="casa_perfil.jpg" class="house_profile"/>
                </div>    
                <div class="info">
                    <p class="font info_title text">DONEC NEC JUSTO EGET</p>
                    <p class="font info_caption minor_text">ALIQUAM COMMODO SED MAGNA</p>
                    <p class="font info_txt">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
                </div> 

              
                
                <p class="learn_more1 font minor_text">LEARN MORE</p>
            </div>

        </div>
    </body>
</html>
