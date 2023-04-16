/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.pojo.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DTS
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        BookServices sv = new BookServices();
        List<Book> books = new ArrayList<>();
        books = sv.getListBook();
        for(int i = 0; i < books.size(); i++)
            System.out.println(books.get(i).getBookDescription());
    }
}
