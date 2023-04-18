/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.Account;
import com.btl.pojo.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class AccountServices {

    public List<Account> getListAccount() throws SQLException {
        List<Account> Accounts = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM account";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account s = new Account();
                s.setAccountId(rs.getInt("id"));
                s.setUsername(rs.getString("user_name"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
                Accounts.add(s);
            }
        }
        return Accounts;
    }
     
 
    public int getAccountId() throws SQLException {
        int accId = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT ifn    ull(MAX(id),0) FROM account";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                accId = rs.getInt(1);
            }
        }
        return (accId + 1);
    }

    public void addAccount(Account a) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO account(id, user_name, password, role)"
                    + "VALUES(?, ?, ?, ?)");
            stm.setInt(1, a.getAccountId());
            stm.setString(2, a.getUsername());
            stm.setString(3, a.getPassword());
            stm.setString(4, a.getRole());
            stm.executeUpdate();
        }

    }

        public boolean CheckLogin(String user, String pass) throws SQLException {
        boolean b = false;
        Connection conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from account where user_name = \'" + user + "\'");
        String hashPass = "";
        while (rs.next()) {
            hashPass = rs.getString("password");
        }
        if (hashPass.equals(pass)) {
            b = true;
        }
        conn.close();
        return b;
    }

    public int checkAccountRole(Account a) {
        int kq = 0;
        if (a.getRole() == "DG") {
            kq = 1;
        } else if (a.getRole() == "NV") {
            kq = -1;
        }
        return kq;
    }

 
    
    
    public Account FindAccountByUsername(String userName) throws SQLException {
        Account d = new Account();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM account WHERE user_name = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                d.setAccountId(rs.getInt("id"));
                d.setUsername(rs.getString("user_name"));
                d.setPassword(rs.getString("password"));
                d.setRole(rs.getString("role"));
                
            }
        }
        return d;
    }
}
