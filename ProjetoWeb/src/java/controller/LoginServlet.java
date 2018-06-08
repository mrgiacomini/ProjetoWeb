/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author mathe
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.sendRedirect("login.jsp");
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

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        UserDAO userDao = new UserDAO();
        User user;

        if (usuario.equals("") && senha.equals("")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            
            request.getSession().setAttribute("error", "Login inválido, campo vazio!");
            response.sendRedirect("login.jsp");
        } else {
            user = userDao.getUser(usuario);

            if (user.getUsername().equals(usuario) && user.getPassword().equals(senha)) {

                request.getSession().setAttribute("logado", true);
                request.getSession().setAttribute("usuario", usuario);

                response.sendRedirect("principal.jsp");
         
            }else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                request.getSession().setAttribute("error", "Login Inválido");
                response.sendRedirect("login.jsp");
            }
            
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
