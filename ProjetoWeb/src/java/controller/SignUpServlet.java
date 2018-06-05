/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

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
        processRequest(request, response);
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
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String senha = request.getParameter("senha");
        String repetir_senha = request.getParameter("repetir_senha");

        UserDAO userDao = new UserDAO();
        if(usuario.equals("")){
            request.getSession().setAttribute("error", "Campo suário está vazio!");
            response.sendRedirect("signup.jsp");
            
        }else if(userDao.searchUser(usuario)) { //consulta no banco se existe o mesmo nome de usuario
            request.getSession().setAttribute("error", "Usuário já cadastrado!");
            response.sendRedirect("signup.jsp");
        
        }else if(email.equals("")){
            request.getSession().setAttribute("error", "Campo email está vazio!");
            response.sendRedirect("signup.jsp");
            
        }else if(userDao.searchEmail(email)){
            request.getSession().setAttribute("error", "Email já cadastrado!");
            response.sendRedirect("signup.jsp");
          
        }else if(!validEmail(email)){
            request.getSession().setAttribute("error", "Email inválido!");
            response.sendRedirect("signup.jsp");
            
        }else if(endereco.equals("")){
            request.getSession().setAttribute("error", "Campo endereço está vazio!");
            response.sendRedirect("signup.jsp");
        
        }else if(senha.equals("") || repetir_senha.equals("")){
            request.getSession().setAttribute("error", "Campo senha está vazio!");
            response.sendRedirect("signup.jsp");
         
        }else if(senha.length() != 6){
            request.getSession().setAttribute("error", "Senha tem que ser de 6 dígitos!");
            response.sendRedirect("signup.jsp");
        
        } else if (!senha.equals(repetir_senha)) {
            request.getSession().setAttribute("error", "Senha não corresponde!");
            response.sendRedirect("signup.jsp");

        } else if (userDao.insertUser(usuario, email, endereco, senha)) { //se inseriu no banco, cria a session e volta ao home
            request.getSession().setAttribute("logado", true);
            request.getSession().setAttribute("usuario", usuario);

            response.sendRedirect("principal.jsp");
        }

    }
    
    private boolean validEmail(String email){
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);

	return m.matches(); 
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
