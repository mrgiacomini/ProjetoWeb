/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

/**
 *
 * @author mathe
 */
public class Post {
    String title;
    String subtitle;
    String text;
    File img;    

    public Post(String title, String subtitle, String text) {
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
