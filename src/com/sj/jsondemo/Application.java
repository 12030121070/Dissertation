package com.sj.jsondemo;

import android.content.Context;

public class Application {
    private String name;
    private String email;
    private String username;
    private String password;
    Context c;
    
    Application(){
    	
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        //globalVariable.setName(this.name);
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String uname) {
        this.username = uname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String psswd) {
        this.password = psswd;
    }
}
