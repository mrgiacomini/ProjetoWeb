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
public class User {
    private String username;
    private String email;
    private String password;
    private String adress;

    public User(String username, String email, String adress,  String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.adress = adress;
    }
    
    public User(String username) {
        this.username = username;
    }
    
    public User(){}
        
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAdress() {
        return adress;
    }
    
    
}
