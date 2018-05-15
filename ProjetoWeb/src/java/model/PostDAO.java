/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class PostDAO {
    public ArrayList listaPosts(){
        ArrayList<Post> lista = new ArrayList();
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
//            PreparedStatement ps = c.prepareStatement("SELECT * FROM posts");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Post post = new Post(rs.getString("title"),rs.getString("subtitle"),rs.getString("text"));
//                lista.add(post);
//            }
//            c.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(PostsServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
        lista.add(new Post("Titulo1", "Subtitulo", "textao\ntextao\ntextao"));
        //lista.add(new Post("Titulo2", "Subtitulo", "textao\ntextao\ntextao"));
        return lista;
    }
}
