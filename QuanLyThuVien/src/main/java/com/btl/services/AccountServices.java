/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.Account;
import com.btl.pojo.KhachHang;
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
            String sql = "SELECT * FROM Account";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account s = new Account();
                s.setAccountId(rs.getInt("MaAccount"));
                s.setUsername(rs.getString("Username"));
                s.setPassword(rs.getString("PassWord"));
                s.setTypeUser(rs.getString("TypeUser"));
                Accounts.add(s);
            }
        }
        return Accounts;
    }

    public int getMaAccount() throws SQLException {
        int maxID = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT ifnull(MAX(MaAccount),0) FROM account";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        }
        return (maxID + 1);
    }

    public void addAccount(Account a) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO account(MaAccount, Username, PassWord, TypeUser)"
                    + "VALUES(?, ?, ?, ?)");
            stm.setInt(1, a.getAccountId());
            stm.setString(3, a.getPassword());
            stm.setString(2, a.getUsername());
            stm.setString(4, a.getTypeUser());
            stm.executeUpdate();
        }

    }

    public boolean CheckLogin(String user, String pass) throws SQLException {
        boolean b = false;
        Connection conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from account where Username = \'" + user + "\'");
        String hashPass = "";
        while (rs.next()) {
            hashPass = rs.getString("PassWord");
        }
        if (hashPass.equals(pass)) {
            b = true;
        }
        conn.close();
        return b;
    }

    public int checkACCOUNT(Account a) {
        int kq = 0;
        if (a.getTypeUser() == "KH") {
            kq = 1;
        } else if (a.getTypeUser() == "NV") {
            kq = -1;
        }
        return kq;
    }

    public void delAccount(int maAcc) throws SQLException {
        try (Connection cnn = JdbcUtils.getConn()) {
            String sql = "DELETE FROM account WHERE (MaAccount = ?);";
            PreparedStatement stm1 = cnn.prepareStatement("call update_SoLuongNV()");
            PreparedStatement stm2 = cnn.prepareStatement(sql);
            stm2.setInt(1, maAcc);
            stm2.executeUpdate();
            stm1.executeUpdate();
        }
    }

    public Account FindAccount(String userName) throws SQLException {
        Account d = new Account();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM Account WHERE Username = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                d.setAccountId(rs.getInt("MaAccount"));
                d.setPassword(rs.getString("PassWord"));
                d.setTypeUser(rs.getString("TypeUser"));
                d.setUsername(rs.getString("Username"));
            }
        }
        return d;
    }
}
