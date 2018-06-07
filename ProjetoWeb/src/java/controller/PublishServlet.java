/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PostDAO;
import DAO.UserDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.User;

/**
 *
 * @author andrey
 */
@WebServlet(name = "PublishServlet", urlPatterns = {"/PublishServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class PublishServlet extends HttpServlet {

    int id = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PublishServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PublishServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("principal.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String caption = request.getParameter("caption");
        String text = request.getParameter("text");

        PostDAO newPost = new PostDAO();

        Part part = request.getPart("upload");
        String images_path = request.getServletContext().getRealPath("/uploads");

        String fileName = UUID.randomUUID().toString(); //nome aletorio para armazenamento
        String str[] = part.getContentType().split("/");
        String type = str[1];                           //ex: image/png returns png

        String filePath = "";
        if (!type.equals("octet-stream")) {
            filePath = "uploads/" + fileName + "." + type; //caminho no servidor

            InputStream in = part.getInputStream();
            Files.copy(in, Paths.get(images_path + "/" + fileName + "." + type), StandardCopyOption.REPLACE_EXISTING);
            //Files.copy(in, Paths.get("/uploads/" + name + "." + type), StandardCopyOption.REPLACE_EXISTING);
            //part.write(filePath);
            part.delete();

        }

        if (newPost.insertPost(title, caption, text, filePath, request.getSession().getAttribute("usuario").toString())) {
            response.sendRedirect("principal.jsp");
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            request.getSession().setAttribute("error", "Falha em publicar, tente novamente!");
            response.sendRedirect("publish.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
