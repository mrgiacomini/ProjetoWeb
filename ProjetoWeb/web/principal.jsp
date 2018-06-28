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

            <script>
                function exibePostagens(){        
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "PostagensServlet", true);

                    xhr.onreadystatechange = function(){
                        if(xhr.readyState < 4){
                            document.getElementById("progressbar").style.display = "block";
                        }
                        if(xhr.readyState === 4 && xhr.status === 200){
                            document.getElementById("progressbar").style.display = "none";
                            var json = JSON.parse(xhr.responseText);
                            if(json.length===0){
                                document.getElementById("form_query").style.display = "none";
                            }
                            //var fonte = $('#postagens-template').html();
                            var fonte = document.getElementById("postagens-template").innerHTML;
                            var template = Handlebars.compile(fonte);
                            var wrapper = {postagem:json};
                            //$('#container2').append(template(wrapper));
                            document.getElementById("container2").innerHTML+=template(wrapper);
                        }

                    };
                    xhr.send();
                }
            </script>
    
        <div class="header">
            <p class="title font text">GRAVITY</p>
            <p class="caption font text minor_text">O NOSSO BLOG</p>
            <img src="images/menu_icon.png" class="menu_icon"/>
        </div>
        <div class="container">
            <img class="backImg" src="images/landscape.jpg" alt="landscape"/>
            
            <% if (request.getSession().getAttribute("logado") != null){  //se o usuario esta logado %>
                <p class="title1 font"><%= request.getSession().getAttribute("usuario").toString().toUpperCase() %></p>
                <p class="caption1 font minor_text">SEJA BEM VINDO!</p>
            <%}else{%>
                <p class="title1 font">FAÇA LOGIN OU CADASTRE-SE!</p>
                <p class="caption1 font minor_text">FAÇA PUBLICAÇÕES EM NOSSO BLOG.</p>
            <%}%>
            
            <div id="container2" class="container2">
                <img id="progressbar" src="images/progressbar1.gif"  width="70rem" />
                
                <script>exibePostagens();</script>
                
                <script id="postagens-template" type="text/x-handlebars-template">   
                    <form id="form_query" method="GET" action="SearchPostServlet" style="margin-bottom: 2em;">
                                    <input type="text" name="query" value="">
                                    <button class="font info_caption btn_search">Pesquisar</button>
                    </form>

                    {{#each postagem}}

                    <hr style="width: auto; "> 

                    <div class="posts">

                        <img src="{{{ userFile }}}" class="profile"/>
                        <p class="font">{{ username }}</p>                  

                        <div class="info">
                            <p class="font info_title text">{{ title }}</p>
                            <p class="font info_caption minor_text">{{ caption }}</p>
                            <p class="font info_txt">{{ text }}</p>
                            <img src="{{{ file }}}" width="400"></img>
                        </div>
                       
                        <button id="btn_delete" onclick="deletarPost();" class="font info_caption btn_delete">Excluir</button>
                        
                    </div>
                    {{/each}}
                </script>
                                
                <% //String query = (String)request.getSession().getAttribute("query");
                    //String query = request.getParameter("query").toString();
                    //if (query != null) {
                    //    lista = postDao.listPosts(query);
                    //    request.getSession().removeAttribute("query");
                    //}
                    //if (lista != null) {
                    //    for (Post p : lista) {
                %> 
               
            </div>
                
        </div>
    </body>
    
    
</html>