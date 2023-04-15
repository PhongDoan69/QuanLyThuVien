/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.conf.Utils;
import com.btl.pojo.CallCard;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author Admin
 */
public class BookServices {

    public int getMaxDatTiec() throws SQLException {
        int maxID = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT MAX(id) FROM call_card";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        }
        return maxID + 1;
    }

    public int addCallCard(CallCard c) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO dattiec(id, date_get_book, return_date, employee_id, reader_id)"
                    + " VALUES(?, CURDATE(),CURDATE()+2, ?, ?)");
            stm.setInt(1, c.getCallCardId());
            stm.setInt(2, c.getEmployeeId());
            stm.setInt(3, c.getReaderId());

            stm.executeUpdate();
            return 1;
        }
    }

    public void deleteCallCard(int callCardId) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM call_card\n"
                    + "           where id = ?");
            stm.setInt(1, callCardId);
            stm.executeUpdate();
        }
    }

    public CallCard FindCallCard(int callCardId) throws SQLException {
        CallCard c = new CallCard();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM call_card WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, callCardId);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                c.setCallCardId(rs.getInt("id"));
                c.setDateGetBook(rs.getDate("date_get_book"));
                c.setReturnDate(rs.getDate("return_date"));
                c.setEmployeeId(rs.getInt("employee_id"));
                c.setReaderId(rs.getInt("reader_id"));

            }
        }
        return c;
    }

    public List<CallCard> getListCallCard(String kw) throws SQLException {
        List<CallCard> ccs = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM call_card ";
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE id like concat('%', ?, '%')";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
                stm.setString(2, kw);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CallCard c = new CallCard();
                c.setCallCardId(rs.getInt("id"));
                c.setDateGetBook(rs.getDate("date_get_book"));
                c.setReturnDate(rs.getDate("return_date"));
                c.setEmployeeId(rs.getInt("employee_id"));
                c.setReaderId(rs.getInt("reader_id"));
                ccs.add(c);
            }
        }
        return ccs;
    }

    public List<CallCard> getListCallCardByReaderId(int c) throws SQLException {
        List<CallCard> listCC = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM call_card WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, c);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CallCard cc = new CallCard();
                cc.setCallCardId(rs.getInt("id"));
                cc.setDateGetBook(rs.getDate("date_get_book"));
                cc.setReturnDate(rs.getDate("return_date"));
                cc.setEmployeeId(rs.getInt("employee_id"));
                cc.setReaderId(rs.getInt("reader_id"));

                listCC.add(cc);
            }
        }
        return listCC;
    }



}
