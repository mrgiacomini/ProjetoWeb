/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.Post;

/**
 *
 * @author mathe
 */
public class PostDAO {
    public ArrayList listaPosts(){
        ArrayList<Post> lista = new ArrayList();
        lista.add(new Post("Titulo1", "Subtitulo", "textao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextao"));
        lista.add(new Post("Titulo1", "Subtitulo", "textao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextao"));
        return lista;
    }
}
