<%-- 
    Document   : publish
    Created on : Jun 3, 2018, 5:25:26 PM
    Author     : andrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Edit | New content"/>
</jsp:include>

<!DOCTYPE html>

        <div style="height: 50px; width: 400px; margin: auto; text-align: center; justify-content: center;">
            <form action="PublishServlet" method="POST" enctype="multipart/form-data">
                <br><br><br><legend>Title</legend>                    
                <input style="width: 100%" name="titulo" type="text" value="">
                <legend>Caption</legend>
                <input style="width: 100%" name="subtitulo" type="text" value="">
                <legend>Text</legend>
                <textarea rows="10" style="width: 100%"></textarea>
                <input type="file" name="upload">
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
