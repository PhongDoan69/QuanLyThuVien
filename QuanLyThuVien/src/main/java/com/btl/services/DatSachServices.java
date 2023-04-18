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
public class DatSachServices {

    public int getMaxCallCard() throws SQLException {
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
            PreparedStatement stm = conn.prepareStatement("INSERT INTO call_card(id, date_get_book, return_date, employee_id, reader_id)"
                    + " VALUES(?, ?,?, null, ?)");
            stm.setInt(1, c.getCallCardId());
            stm.setDate(2, (Date) c.getDateGetBook());
            stm.setDate(3, (Date) c.getReturnDate());
            stm.setInt(4, c.getReaderId());
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


    public List<CallCard> getListCallCard(int madat) throws SQLException {
        List<CallCard> CallCards = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM datmonan WHERE id = ?");
            stm.setInt(1, madat);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CallCard cc = new CallCard();
                cc.setCallCardId(rs.getInt("callCardId"));
                cc.setDateGetBook(rs.getDate("dateGetBook"));
                cc.setReturnDate(rs.getDate("returnDate"));
                cc.setEmployeeId(rs.getInt("employeeId"));
                cc.setReaderId(rs.getInt("readerId"));
                CallCards.add(cc);
            }
        }
        return CallCards;
    }

    public CallCard getCallCard(int maCC) throws SQLException {
        CallCard cc = new CallCard();
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM call_card WHERE id = ?");
            stm.setInt(1, maCC);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                cc.setCallCardId(rs.getInt("id"));
                cc.setDateGetBook(rs.getDate("date_get_book"));
                cc.setReturnDate(rs.getDate("return_date"));
                cc.setEmployeeId(rs.getInt("employee_id"));
                cc.setReaderId(rs.getInt("reader_id"));
            }
        }
        return cc;
    }

}
