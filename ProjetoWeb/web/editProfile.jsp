<%-- 
    Document   : editProfile
    Created on : 05/06/2018, 10:37:27
    Author     : mathe
--%>

<%@page import="model.User"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  // if(request.getSession().getAttribute("logado")==null){
    //        response.sendRedirect("principal.jsp");
    //}//ta gerando erro     
%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Gravity | Edit Profile"/>
</jsp:include>


<div class="header" style="height: 60px">
    <%  UserDAO userDao = new UserDAO();
        User u = userDao.getUser(request.getSession().getAttribute("usuario").toString());
    %>
    
    <form action="EditProfileServlet" method="POST">
        <legend class="title font text">Editar Perfil</legend><br><br>
        Nome de usuário:*<br>
        <input type="text" name="usuario" value="<%=u.getUsername()%>" placeholder="">
        <br><br>
        Email:*<br>
        <input type="text" name="email" value="<%=u.getEmail()%>" placeholder="">
        <br><br>
        Endereço:*<br>
        <input type="text" name="endereco" value="<%=u.getAdress()%>" placeholder="">
        <br><br>
        Nova senha: (6 dígitos)<br>
        <input type="password" name="senha" value="">
        <br><br>
        Repetir senha:<br>
        <input type="password" name="repetir_senha" value=""><br><br>
        
        * Campos obrigatórios.<br><br>
        <input type="submit" value="Salvar">        
    </form>
        
        <form action="DeleteProfileServlet" method="POST">
            <br><br><br>
        <input type="submit" value="Excluir Perfil">
        </form>
    
        
    <% String error = (String) request.getSession().getAttribute("error");
            if (error != null) {%>
                <p class="error"> <%=error%> </p>
            <%}
            request.getSession().removeAttribute("error"); //remove o atributo da session para não aparecer mais%>
    
</div>
</body>
</html>
