/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.Account;
import com.btl.pojo.KhachHang;
import com.btl.quanlythuvien.DangKyKhachHangController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class KhachHangServices {
    public List<KhachHang> getListKhachHang(String kw) throws SQLException {
        List<KhachHang> KhachHangs = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM khachhang";
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE MaKH like concat('%', ?, '%') OR TenKH like concat('%', ?, '%') ";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
                stm.setString(2, kw);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                KhachHang s = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"), rs.getString("CMND"),
                         rs.getString("DiaChi"), rs.getString("GioiTinh"), rs.getInt("MaAcc"), rs.getString("SDT"));
                KhachHangs.add(s);
            }
        }
        return KhachHangs;
    }
    
    public int getMaxKhachHang()throws SQLException{
        int maxID=0;
        try(Connection conn= JdbcUtils.getConn()){
            String sql="SELECT MAX(MaKH) FROM khachhang";
            PreparedStatement stm=conn.prepareStatement(sql); 
            ResultSet rs = stm.executeQuery();
            while(rs.next())
                maxID=rs.getInt(1);
        }return (maxID+1);
    }
     public void addKhachHang(KhachHang a) throws SQLException{
        try(Connection conn= JdbcUtils.getConn()){
            PreparedStatement stm =conn.prepareStatement("INSERT INTO khachhang(MaKH, TenKH, GioiTinh, CMND, SDT, DiaChi, MaAcc)"
                    + "VALUES(?, ?, ?, ?,?,?,?)");
            stm.setInt(1, a.getMaKH());
            stm.setString(2, a.getTenKH());
            stm.setString(3, a.getGioiTinh());
            stm.setString(4, a.getCMND());           
            stm.setString(5, a.getSDT());
            stm.setString(6, a.getDiaChi());            
            stm.setInt(7, a.getMaAcc());            
            stm.executeUpdate();
        }
     }
     public KhachHang getKhachHangbyAcc(int maAcc) throws SQLException{
        KhachHang s = null;
        try(Connection conn = JdbcUtils.getConn()){
            String sql = "SELECT * FROM khachhang Where MaAcc = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(maAcc));  
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                s = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"),rs.getString("CMND")
                        , rs.getString("DiaChi"), rs.getString("GioiTinh"), rs.getInt("MaAcc"), rs.getString("SDT"));
            }
        }
        return s;
    }
    public void updateKhachhang (KhachHang k)throws SQLException{
        try(Connection conn= JdbcUtils.getConn()){
            PreparedStatement stm=conn.prepareStatement("UPDATE khachhang\n"
                    + "set TenKH = ?, GioiTinh = ?, CMND = ?, SDT = ?, DiaChi = ? "
                    + "where MaKH = ?" );
            stm.setString(1, k.getTenKH());       
            stm.setString(2, k.getGioiTinh());
            stm.setString(3, k.getCMND());
            stm.setString(4, k.getSDT());
            stm.setString(5, k.getDiaChi());
            stm.setInt(6, k.getMaKH());
            stm.executeUpdate();
             }
        }
    public void delKhachHang (int maKH) throws SQLException{
        try (Connection cnn = JdbcUtils.getConn()) {
            String sql = "DELETE FROM account WHERE (MaAccount = ?);";
            
            PreparedStatement stm2 = cnn.prepareStatement(sql);
            stm2.setInt(1, maKH);
            stm2.execute();
        }
    }
    
     public KhachHang getKhachHangByAccount(String userName) throws SQLException{
        KhachHang s = null;
        
        try(Connection conn = JdbcUtils.getConn()){
            String sql = "select kh.* from account ac, khachhang kh where  ac.Username = ? and ac.MaAccount = kh.MaAcc ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, userName);           
            ResultSet rs = stm.executeQuery();
           if(!rs.next()){
               return null;
           }
           else{
                s = new KhachHang(rs.getInt("MaKH"), rs.getString("TenKH"),rs.getString("CMND")
                        , rs.getString("DiaChi"), rs.getString("GioiTinh"), rs.getInt("MaAcc"), rs.getString("SDT"));
            }     
        }
        return s;
    }
}
