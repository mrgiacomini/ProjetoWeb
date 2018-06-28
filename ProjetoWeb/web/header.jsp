<%-- 
    Document   : header
    Created on : 23/05/2018, 19:31:31
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><%= request.getParameter("title") %></title>
        <link type="text/css" rel="stylesheet" href="projeto1.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="handlebars-v4.0.11.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
                
                
    </head>
    <body>

        <div class="menu">
            <ul class="font text">
                <li><a href="principal.jsp" style="text-decoration: none; color: inherit;">HOME</a></li>
                <% if (request.getSession().getAttribute("logado") != null){  //se o usuario esta logado %>
                <li><a href="publish.jsp" style="text-decoration: none; color: inherit;">PUBLISH</a></li>
                <li><a href="LogoutServlet" style="text-decoration: none; color: inherit;">LOGOUT</a></li>
                <%} else {  //se nao estiver logado%>
                <li><a href="login.jsp" style="text-decoration: none; color: inherit;">LOGIN</a></li>
                <li class="bordered"><a href="signup.jsp" style="text-decoration: none; color: inherit;">SIGN UP</a></li>
                <%}%>
               
            </ul>
        </div>
