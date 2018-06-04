/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        lista.add(new Post("Titulo1", "Subtitulo", "textao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextaotextao\ntextao\ntextao"));
        return lista;
    }
    
    public void upload(String folder, String fileName, InputStream loadedFile) throws FileNotFoundException{
        String path = folder+"/"+fileName;
        File newFile = new File(path);
        FileOutputStream out = new FileOutputStream(newFile);
        toCopy(loadedFile, out);
    }
    
    public void toCopy(InputStream origem, OutputStream destino){
        int bytes = 0;
        byte[] maxSize = new byte[100*1024];
        try {
            while((bytes = origem.read(maxSize)) >= 0){
                destino.write(maxSize, 0, bytes);
            }
        } catch (IOException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    