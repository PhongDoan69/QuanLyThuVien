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
    public List<Book> getListBook() throws SQLException
    {
        List<Book> Books = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            String sql = "SELECT * FROM book";
            
            PreparedStatement stm = conn.prepareStatement(sql);
//            if(kw != null && !kw.isEmpty())
//            {
//                stm.setString(1, kw);
//                stm.setString(2, kw);
//            }        
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Book b = new Book();
                b.setBookId(rs.getInt("id"));
                b.setBookName(rs.getString("book_name"));
                b.setBookCategory(rs.getString("book_category"));
                b.setPublish(rs.getString("publish"));
                b.setPublishYear(rs.getInt("publish_year"));
                b.setEntryDate(rs.getDate("entry_date"));
                b.setBookPosition(rs.getString("book_position"));
                b.setBookDescription(rs.getString("book_description"));
                Books.add(b);
            }
        }
        return Books;
    }
}
