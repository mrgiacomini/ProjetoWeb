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
<%@page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8"%>

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
            <%}else{%>
                <p class="title1 font">FAÇA LOGIN OU CADASTRE-SE!</p>
                <p class="caption1 font minor_text">FAÇA PUBLICAÇÕES EM NOSSO BLOG.</p>
            <%}%>
                
            <div class="container2">
               <% PostDAO postDao = new PostDAO();
                  ArrayList<Post> lista = postDao.listPosts();
                  if(lista!=null){
               %>
               <form method="GET" action="SearchPostServlet" style="margin-bottom: 2em;">
                        <input type="text" name="query" value="">
                        <button class="font info_caption btn_search">Pesquisar</button>
               </form>
                <%} String query = (String)request.getSession().getAttribute("query");
                    //String query = request.getParameter("query").toString();
                    if (query != null) {
                        lista = postDao.listPosts(query);
                        request.getSession().removeAttribute("query");
                    }
                    if (lista != null) {
                        for (Post p : lista) {
                %> 
               
                <hr style="width: auto; "> 
                
                <div class="posts">
                    
                    <img src="<%=p.getUserFile()%>" class="profile"/>
                    <p class="font"><%=p.getUsername()%></p>  <!-- posicionar no css -->                  
                    
                    <div class="info">
                        <p class="font info_title text"><%=p.getTitle()%></p>
                        <p class="font info_caption minor_text"><%=p.getCaption()%></p>
                        <p class="font info_txt"><%=p.getText()%></p>
                        <%if(!p.getFile().equals("")){%>
                            <img src="<%=p.getFile()%>" width="400"></img>
                        <%}%>
                    </div>
                    
                    <% if (request.getSession().getAttribute("logado") != null && request.getSession().getAttribute("usuario").equals(p.getUsername())){  //se o usuario esta logado %>
                    <form method="POST" action="DeletePostServlet">
                        <input type="hidden" name="id" value="<%=p.getId()%>">
                        <button class="font info_caption btn_delete">Excluir</button>
                    </form>
                    <%}%>
                </div>
                <%    }
                    }
                %>

            </div>

        </div>
    </body>
</html>