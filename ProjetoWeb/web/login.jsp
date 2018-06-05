<%-- 
    Document   : login
    Created on : 13/05/2018, 13:55:44
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if(request.getSession().getAttribute("logado")!=null){
            response.sendRedirect("principal.jsp");
        }
%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Gravity | Login"/>
</jsp:include>
    
        <div class="header" style="height: 60px">
        <form action="LoginServlet" method="POST">
            <legend class="title font text">Login</legend><br><br>
            <legend>Usuário</legend>
            <input type="text" name="usuario" value="">
            <legend>Senha</legend>
            <input type="password" name="senha" value="">
            <br><br>    
            <input type="submit" value="Entrar">
            
            <% String error = (String) request.getSession().getAttribute("error");
            if (error != null) {%>
                <p class="error"> <%=error%> </p>
            
            <%}
              request.getSession().removeAttribute("error");  //remove o atributo da session para não aparecer mais%>
            
        </form>
        </div>
    </body>
</html>
