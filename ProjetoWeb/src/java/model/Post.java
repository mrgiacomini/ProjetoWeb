/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathe
 */
public class Post {
    int id;
    String title;
    String caption;
    String text;  
    String file;
    String username;
    String userFile;

    
    public Post(String title, String caption, String text, String file, String username, String userFile) {
        this.title = title;
        this.caption = caption;
        this.text = text;
        this.file = file;
        this.username = username;
        this.userFile = userFile;
    }

    public Post(int id, String title, String caption, String text, String file, String username, String userFile) {
        this.id = id;
        this.title = title;
        this.caption = caption;
        this.text = text;
        this.file = file;
        this.username = username;
        this.userFile = userFile;
    }
    
    
    public Post(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
