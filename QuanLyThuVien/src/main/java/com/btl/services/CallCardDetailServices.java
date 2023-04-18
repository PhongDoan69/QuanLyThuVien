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
    
    public int addCallCardDetail(CallCardDetail c) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO call_card_detail(id, quantity, book_id, call_card_id)"
                    + " VALUES(?, ?,?, ?)");
            stm.setInt(1, c.getCallCardId());
            stm.setInt(2, c.getQuantity());
            stm.setInt(3, c.getBookId());
            stm.setInt(4, c.getCallCardId());
            stm.executeUpdate();
            return 1;
        }
    }
    
    public List<CallCardDetail> getListCallCardDetail(int id) throws SQLException
    {
        List<CallCardDetail> ccds = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            String sql = "SELECT * FROM call_card_detail WHERE id = ? ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);     
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
}
