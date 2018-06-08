<%-- 
    Document   : signup
    Created on : 15/05/2018, 16:10:15
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if(request.getSession().getAttribute("logado")!=null){
            response.sendRedirect("principal.jsp");
        }
%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Gravity | SignUp"/>
</jsp:include>

<div class="header" style="height: 60px">
    <form action="SignUpServlet" method="POST" enctype="multipart/form-data"accept-charset="ISO-8859-1">
        <legend class="title font text">Cadastro</legend><br><br>
        Nome de usuário:<br>
        <input type="text" name="usuario" value="">
        <br><br>
        Email:<br>
        <input type="text" name="email" value="">
        <br><br>
        Endereço:<br>
        <input type="text" name="endereco" value="">
        <br><br>
        Senha: (6 a 10 dígitos)<br>
        <input type="password" name="senha" value="">
        <br><br>
        Repetir senha:<br>
        <input type="password" name="repetir_senha" value=""><br><br>
        
        <br>
        <legend>Foto de perfil:</legend><br>
        <input type="file" accept="image/*" name="upload"> 
        <br><br><br>
        
        *Todos os campos são obrigatórios.<br><br>
                
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
