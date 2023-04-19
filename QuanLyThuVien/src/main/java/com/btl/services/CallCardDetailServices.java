/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.CallCard;
import com.btl.pojo.CallCardDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DTS
 */
public class CallCardDetailServices {
    public int getMaxCallCardDetail() throws SQLException {
        int maxID = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT MAX(id) FROM call_card_detail";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        }
        return maxID + 1;
    }
    
    public void addCallCardDetail(CallCardDetail c) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO call_card_detail(id, quantity, book_id, call_card_id)"
                    + " VALUES(?, ?,?, ?)");
            stm.setInt(1, c.getCallCardDetailId());
            stm.setInt(2, c.getQuantity());
            stm.setInt(3, c.getBookId());
            stm.setInt(4, c.getCallCardId());
            stm.executeUpdate();
        }
    }
    
    public void updateCallCardDetail(CallCardDetail c) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("UPDATE call_card_detail\n" +
            " set quantity = ?, book_id = ?" +
            " where id = ? AND call_card_id = ?");
            stm.setInt(3, c.getCallCardDetailId());
            stm.setInt(1, c.getQuantity());
            stm.setInt(2, c.getBookId());
            stm.setInt(4, c.getCallCardId());
            stm.executeUpdate();    
        }
    }
    
    public List<CallCardDetail> getListCallCardDetail(int callCardId) throws SQLException
    {
        List<CallCardDetail> ccds = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            String sql = "SELECT * FROM call_card_detail WHERE call_card_id = ? ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, callCardId);     
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                CallCardDetail ccd = new CallCardDetail();
                ccd.setCallCardDetailId(rs.getInt("id"));
                ccd.setQuantity(rs.getInt("quantity"));
                ccd.setBookId(rs.getInt("book_id"));
                ccd.setCallCardId(rs.getInt("call_card_id"));
                ccds.add(ccd);
            }
        }
        return ccds;
    }
    
    public CallCardDetail getCallCardDetail(int callCardId, int bookId) throws SQLException
    {
        CallCardDetail ccd = new CallCardDetail();
        try(Connection conn = JdbcUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM call_card_detail WHERE call_card_id = ?, book_id");
            stm.setInt(1, callCardId);
            stm.setInt(2, bookId);
            ResultSet rs = stm.executeQuery();
            if(!rs.next()){
                return null;
            }
            else{
                ccd.setCallCardDetailId(rs.getInt("id"));
                ccd.setQuantity(rs.getInt("quantity"));
                ccd.setBookId(rs.getInt("book_id"));
                ccd.setCallCardId(rs.getInt("call_card_id"));
            }
        }
        return ccd;
    }
    
    public int getTongSoSach(int maCC) throws SQLException {
        int soLuong = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("SELECT SUM(quantity) AS TongSach FROM call_card_detail");        
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                soLuong = rs.getInt("TongSach");
            }
        }
        return soLuong;
    }
}
