<%-- 
    Document   : login
    Created on : 13/05/2018, 13:55:44
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="POST">
            <fieldset>
                <legend>Login</legend>
                <input type="text" name="usuario" value="">
                <input type="password" name="senha" value="">
                <input type="submit" value="Entrar">
            </fieldset>
        </form>
    </body>
</html>
