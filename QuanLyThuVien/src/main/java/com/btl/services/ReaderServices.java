/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import java.util.Date;
import com.btl.conf.JdbcUtils;
import com.btl.pojo.Account;
import com.btl.pojo.Reader;
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
public class ReaderServices {

    public List<Reader> getListReader(String kw) throws SQLException {
        List<Reader> Readers = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM reader";
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE id like concat('%', ?, '%') OR reader_name like concat('%', ?, '%') ";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
                stm.setString(2, kw);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Reader s = new Reader(rs.getInt("readerId"), rs.getString("readerName"), rs.getString("gender"),
                        rs.getDate("dob"), rs.getString("role"), rs.getString("position"), rs.getDate("dateOfCallCard"),
                        rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getInt("borrowingAvailability"));
                Readers.add(s);
            }
            return Readers;
        }

    }

    /**
     *
     * @return @throws SQLException
     */
    public int getMaxReader() throws SQLException {
        int maxID = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT MAX(id) FROM reader";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        }
        return (maxID + 1);
    }

    public void addReader(Reader a) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO reader(id, reader_name, gender, date_of_birth, reader_role, position, date_of_call_card, email, address, phone, borrowing_availability, account_id)"
                    + "VALUES(?, ?, ?, ?,?,?,?,?,?,?,?,?)");
            stm.setInt(1, a.getReaderId());
            stm.setString(2, a.getReaderName());
            stm.setString(3, a.getGender());
            stm.setDate(4, (java.sql.Date) a.getDob());
            stm.setString(5, a.getRole());
            stm.setString(6, a.getPosition());
            stm.setDate(7, (java.sql.Date) a.getDateOfCallCard());
            stm.setString(8, a.getEmail());
            stm.setString(9, a.getAddress());
            stm.setString(10, a.getPhone());
            stm.setInt(11, a.getBorrowingAvailability());
            stm.setInt(12, a.getAccountId_Reader() );

            stm.executeUpdate();
        }
    }

    public Reader getReaderById(int readerId) throws SQLException {
        Reader s = null;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM reader Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(readerId));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
               s = new  Reader(rs.getInt("id"), rs.getString("reader_name"), rs.getString("gender"),
                        rs.getDate("date_of_birth"), rs.getString("reader_role"), rs.getString("position"), rs.getDate("date_of_call_card"),
                        rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getInt("borrowing_availability")); }
        }
        return s;
    }

    public Reader getKhachHangbyAcc(int maAcc) throws SQLException {
        Reader s = null;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM reader Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(maAcc));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
               s = new  Reader(rs.getInt("id"), rs.getString("reader_name"), rs.getString("gender"),
                        rs.getDate("date_of_birth"), rs.getString("reader_role"), rs.getString("position"), rs.getDate("date_of_call_card"),
                        rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getInt("borrowing_availability"));
            }
        }
        return s;
    }

    public void updateKhachhang(Reader k) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("UPDATE reader\n"
                    + "set id = ?, reader_name = ?, gender = ?, date_of_birth = ?, reader_role = ?, position = ? ,date_of_call_card = ?, email = ?, address = ?, phone = ?,borrowing_availability= ?, account_id =? ");
            stm.setInt(1, k.getReaderId());
            stm.setString(2, k.getReaderName());
            stm.setString(3, k.getGender());
            stm.setDate(4, (java.sql.Date) k.getDob());
            stm.setString(5, k.getRole());
            stm.setString(6, k.getPosition());
            stm.setDate(7, (java.sql.Date) k.getDateOfCallCard());
            stm.setString(8, k.getEmail());
            stm.setString(9, k.getAddress());
            stm.setString(10, k.getPhone());
            stm.setInt(11, k.getBorrowingAvailability());
            stm.setInt(12, k.getBorrowingAvailability());
            stm.executeUpdate();
        }
    }

    public void deleteReader(int readerId) throws SQLException {
        try (Connection cnn = JdbcUtils.getConn()) {
            String sql = "DELETE FROM account WHERE (id = ?);";

            PreparedStatement stm2 = cnn.prepareStatement(sql);
            stm2.setInt(1, readerId);
            stm2.execute();
        }
    }

    public Reader getReaderByUsername(String userName) throws SQLException {
        Reader s = null;

        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "select r.* from account ac, reader r where  ac.user_name = ? and ac.id = r.id ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                s = new  Reader(rs.getInt("id"), rs.getString("reader_name"), rs.getString("gender"),
                        rs.getDate("date_of_birth"), rs.getString("reader_role"), rs.getString("position"), rs.getDate("date_of_call_card"),
                        rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getInt("borrowing_availability"));
            }
        }
        return s;
    }
}
