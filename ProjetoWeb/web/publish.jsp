<%-- 
    Document   : publish
    Created on : Jun 3, 2018, 5:25:26 PM
    Author     : andrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if(request.getSession().getAttribute("logado")==null){
            response.sendRedirect("principal.jsp");
        }
%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Gravity | Publish"/>
</jsp:include>
                
        <div style="height: 50px; width: 400px; margin: auto; text-align: center; justify-content: center;">
                   
            <form action="PublishServlet" method="post" id="publishform"  enctype="multipart/form-data" accept-charset="ISO-8859-1">
                <br><br><br>
                <legend class="title font text">Publicação</legend>
                
                <br><br><br><legend>Título</legend>                    
                <input style="width: 100%" name="title" type="text" value="">
                <br><br>
                <legend>Subtítulo (opcional)</legend>
                <input style="width: 100%" name="caption" type="text" value="">
                <br><br>
                <legend>Texto</legend>
                <textarea name="text" form="publishform" rows="10" style="width: 100%"></textarea>
                <br><br>
                <legend>Imagem (opcional)</legend>
                <input type="file" accept="image/*" name="upload"> 
                <br><br><br>
                <input type="submit" value="Publish">
                
            </form>
            
            <% String error = (String) request.getSession().getAttribute("error");
            if (error != null) {%>
                <p class="error"> <%=error%> </p>
            <%}%>
              <%request.getSession().removeAttribute("error");  //remove o atributo da session para não aparecer mais%>

        </div>
    </body>
</html>
