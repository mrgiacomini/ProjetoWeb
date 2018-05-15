<%-- 
    Document   : signup
    Created on : 15/05/2018, 16:10:15
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <form action="SignUpServlet" method="POST">
            <fieldset>
                <legend>Cadastro</legend>
                Nome de usuário:<br>
                <input type="text" name="usuario" value=""><br><br>
                Senha:<br>
                <input type="password" name="senha" value=""><br><br>
                Repetir Senha:<br>
                <input type="password" name="repetir_senha" value=""><br><br>
                <input type="submit" value="Cadastrar">
            </fieldset>
        </form>
    </body>
</html>
