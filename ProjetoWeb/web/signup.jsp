<%-- 
    Document   : signup
    Created on : 15/05/2018, 16:10:15
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Gravity | SignUp"/>
</jsp:include>

<div class="header" style="height: 60px">
    <form action="SignUpServlet" method="POST">
        <legend class="title font text">Cadastro</legend><br><br>
        Nome de usuário:<br>
        <input type="text" name="usuario" value="">
        <br><br>
        Senha:<br>
        <input type="password" name="senha" value="">
        <br><br>
        Repetir Senha:<br>
        <input type="password" name="repetir_senha" value=""><br><br>
        <input type="submit" value="Cadastrar">

        <% String error = (String) request.getSession().getAttribute("error");
            if (error != null) {%>
                <p class="error"> <%=error%> </p>
            <%}
            request.getSession().removeAttribute("error"); //remove o atributo da session para não aparecer mais%>
    </form>
</div>
</body>
</html>
