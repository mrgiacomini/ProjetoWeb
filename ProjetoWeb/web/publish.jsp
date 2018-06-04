<%-- 
    Document   : publish
    Created on : Jun 3, 2018, 5:25:26 PM
    Author     : andrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Edit | New content"/>
</jsp:include>

        <div style="height: 50px; width: 400px; margin: auto; text-align: center; justify-content: center;">
            <form action="PublishServlet" method="post" id="publishform" ><!--enctype="multipart/form-data" >-->
                <br><br><br><legend>Title</legend>                    
                <input style="width: 100%" name="titulo" type="text" value="">
                <legend>Caption</legend>
                <input style="width: 100%" name="subtitulo" type="text" value="">
                <legend>Text</legend>
                <textarea name="texto" rows="10" style="width: 100%"></textarea>
                <input type="file" name="upload">
                <input type="submit" value="Submit">
                
            </form>
            
            <% String error = (String) request.getSession().getAttribute("error");
            if (error != null) {%>
                <p class="error"> <%=error%> </p>
            
            <%}
              request.getSession().removeAttribute("error");  //remove o atributo da session para não aparecer mais%>

        </div>
    </body>
</html>
