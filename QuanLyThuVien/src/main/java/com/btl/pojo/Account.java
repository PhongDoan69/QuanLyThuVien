/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojo;

/**
 *
 * @author Admin
 */
public class Account {
    private int accountId;
    private String password;
    private String typeUser;
    private String username;
    
    public Account(){
       
    }

    public int getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getUsername() {
        return username;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
