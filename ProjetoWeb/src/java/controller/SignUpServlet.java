/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
 * @author mathe
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
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
        response.sendRedirect("signup.jsp");
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
        
        //upload 
        Part part = request.getPart("upload");
        //pega o caminho absoluto do projeto no servidor
        String images_path = request.getServletContext().getRealPath("");         
        images_path+="/uploads"; //adiciona no caminho a pasta uplaods

        File file = new File(images_path);    //verifica se a pasta existe, caso não, é criada
        if(!file.exists()){
            file.mkdir();
            images_path=file.getAbsolutePath();//retorna o caminho absoluto ja com a pasta criada
        }
        
        //gera nome aletorio para armazenamento
        String fileName = UUID.randomUUID().toString(); 
        String str[] = part.getContentType().split("/"); //pega o tipo do arquivo
        String type = str[1];                           //ex: image/png returns png

        String filePath = "";
        if (!type.equals("octet-stream")) {  //caso existir algum arquivo
            filePath = "uploads/" + fileName + "." + type; //caminho no servidor

            InputStream in = part.getInputStream();
            Files.copy(in, Paths.get(images_path + "/" + fileName + "." + type), StandardCopyOption.REPLACE_EXISTING);
            part.delete();
        }

        UserDAO userDao = new UserDAO();
        if (usuario.equals("")) {
            request.getSession().setAttribute("error", "Campo usuário está vazio!");
            response.sendRedirect("signup.jsp");

        } else if (userDao.searchUser(usuario)) { //consulta no banco se existe o mesmo nome de usuario
            request.getSession().setAttribute("error", "Usuário já cadastrado!");
            response.sendRedirect("signup.jsp");

        } else if (email.equals("")) {
            request.getSession().setAttribute("error", "Campo email está vazio!");
            response.sendRedirect("signup.jsp");

        } else if (userDao.searchEmail(email)) {
            request.getSession().setAttribute("error", "Email já cadastrado!");
            response.sendRedirect("signup.jsp");

        } else if (!validEmail(email)) {
            request.getSession().setAttribute("error", "Email inválido!");
            response.sendRedirect("signup.jsp");

        } else if (endereco.equals("")) {
            request.getSession().setAttribute("error", "Campo endereço está vazio!");
            response.sendRedirect("signup.jsp");

        } else if (senha.equals("") || repetir_senha.equals("")) {
            request.getSession().setAttribute("error", "Campo senha está vazio!");
            response.sendRedirect("signup.jsp");

        } else if (senha.length() < 6 || senha.length() > 10) {
            request.getSession().setAttribute("error", "Senha tem que ser de 6 a 10 dígitos!");
            response.sendRedirect("signup.jsp");

        } else if (!senha.equals(repetir_senha)) {
            request.getSession().setAttribute("error", "Senha não corresponde!");
            response.sendRedirect("signup.jsp");

        } else if (filePath == null || filePath.equals("")) {
            request.getSession().setAttribute("error", "Escolha uma foto de perfil!");
            response.sendRedirect("signup.jsp");

        }else if (userDao.insertUser(usuario, email, endereco, senha, filePath)) { //se inseriu no banco, cria a session e volta ao home
            request.getSession().setAttribute("logado", true);
            request.getSession().setAttribute("usuario", usuario);

            response.sendRedirect("principal.jsp");
        }else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                request.getSession().setAttribute("error", "Erro, tente novamente!");
                response.sendRedirect("signup.jsp");
            }

    }

    private boolean validEmail(String email) {
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
