<%-- 
    Document   : index
    Created on : 11/05/2018, 18:43:28
    Author     : mathe
--%>

<%@page import="DAO.PostDAO"%>
<%@page import="model.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Gravity"/>
</jsp:include>

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
                <div class="posts">
                    <img src="casa_perfil.jpg" class="profile"/>
                    <div class="info">
                        <p class="font info_title text">DONEC NEC JUSTO EGET</p>
                        <p class="font info_caption minor_text">ALIQUAM COMMODO SED MAGNA</p>
                        <p class="font info_txt">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
                    </div>
                </div> 

                <div class="posts">
                    <img src="casa_perfil.jpg" class="profile"/>
                    <div class="info">
                        <p class="font info_title text"><%=p.getTitle()%></p>
                        <p class="font info_caption minor_text"><%=p.getSubtitle()%></p>
                        <p class="font info_txt"><%=p.getText()%></p>
                    </div>
                </div>
                <%    }
                    }
                %>


                <p class="learn_more1 font minor_text">LEARN MORE</p>
            </div>

        </div>
    </body>
</html>
