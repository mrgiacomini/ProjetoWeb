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
            <p class="caption font text minor_text">O NOSSO BLOG</p>
            <img src="menu_icon.png" class="menu_icon"/>
        </div>
        <div class="container">
            <img class="backImg" src="landscape.jpg" alt="landscape"/>
            
            <% if (request.getSession().getAttribute("logado") != null){  //se o usuario esta logado %>
                <p class="title1 font"><%= request.getSession().getAttribute("usuario").toString().toUpperCase() %></p>
                <p class="caption1 font minor_text">SEJA BEM VINDO!</p>
                <p class="learn_more font minor_text">EDITAR PERFIL</p>
            <%}else{%>
                <p class="title1 font">FAÇA LOGIN OU CADASTRE-SE!</p>
                <p class="caption1 font minor_text">FAÇA PUBLICAÇÕES EM NOSSO BLOG.</p>
            <%}%>
               
            <div class="container2">

                <%  PostDAO postDAO = new PostDAO();
                    ArrayList<Post> lista = postDAO.listPosts();
                    
                    if (lista != null) {
                        for (Post p : lista) {
                %> 
                <div class="posts">
                    <img src="casa_perfil.jpg" class="profile"/>
                    <div class="info">
                        <p class="font info_title text"><%=p.getTitle()%></p>
                        <p class="font info_caption minor_text"><%=p.getCaption()%></p>
                        <p class="font info_txt"><%=p.getText()%></p>
                    </div>
                    <% if (request.getSession().getAttribute("logado") != null){  //se o usuario esta logado %>
                        <div style="position: absolute;">
                            <a href="EditPostServlet" style="text-decoration: underline; color: inherit;">editar</a>
                            <a href="DeletePostServlet" style="text-decoration: underline; color: inherit;">excluir</a>
                        </div>
                    <%}%>
                </div>
                <%    }
                    }
                %>

<!--                <p class="learn_more1 font minor_text">LEARN MORE</p> -->
            </div>

        </div>
    </body>
</html>
