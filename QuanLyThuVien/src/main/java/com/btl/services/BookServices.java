/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author DTS
 */
public class BookServices {

    public List<Book> getListBook(String kw) throws SQLException {
        List<Book> Books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM book";
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE (book_name LIKE CONCAT('%', ?, '%') OR author LIKE CONCAT('%', ?, '%') OR publish_year LIKE CONCAT('%', ?, '%') OR book_category LIKE CONCAT('%', ?, '%'))";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
                stm.setString(2, kw);
                stm.setString(3, kw);
                stm.setString(4, kw);

            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("id"));
                b.setBookName(rs.getString("book_name"));
                b.setBookCategory(rs.getString("book_category"));
                b.setPublish(rs.getString("publish"));
                b.setPublishYear(rs.getInt("publish_year"));
                b.setEntryDate(rs.getDate("entry_date"));
                b.setBookPosition(rs.getString("book_position"));
                b.setBookDescription(rs.getString("book_description"));
                b.setInStock(rs.getInt("instock"));
                b.setAuthor(rs.getString("author"));

                Books.add(b);
            }
        }
        return Books;
    }

    public int getCountBook(String kw) throws SQLException {
        int count = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT COUNT(*) FROM book";

            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE book_name LIKE ? OR author LIKE ?";
            }

            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, "%" + kw + "%");
                stm.setString(2, "%" + kw + "%");
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
        return count;
    }

    public Book getBookByBookId(int bookId) {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE id = ?");
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Book b = new Book();
                b.setBookId(rs.getInt("id"));
                b.setBookName(rs.getString("book_name"));
                b.setBookCategory(rs.getString("book_category"));
                b.setPublish(rs.getString("publish"));
                b.setPublishYear(rs.getInt("publish_year"));
                b.setEntryDate(rs.getDate("entry_date"));
                b.setBookPosition(rs.getString("book_position"));
                b.setBookDescription(rs.getString("book_description"));
                b.setInStock(rs.getInt("instock"));
                b.setAuthor(rs.getString("author"));
                return b;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
//    public void updateBook(int bookId){
//        try (Connection cnn = JdbcUtils.getConn()) {
//            
//            String sql = "DELETE FROM book WHERE (id = ?);";
//            PreparedStatement stm1 = cnn.prepareStatement("call delete_account(?)");
//            PreparedStatement stm2 = cnn.prepareStatement(sql);
//             stm1.setInt(1, maAcc);
//            stm2.setInt(1, maAcc);
//            
//           
//            stm1.executeUpdate();
//            stm2.executeUpdate();
//        }
//    }
}
