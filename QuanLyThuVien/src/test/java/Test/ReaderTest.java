///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Test;
//
//import com.btl.conf.HashPassword;
//import com.btl.conf.JdbcUtils;
//import com.btl.pojo.Account;
//import com.btl.pojo.Reader;
//import com.btl.services.AccountServices;
//import com.btl.services.ReaderServices;
//import org.junit.jupiter.api.Test;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//import org.junit.jupiter.api.Assertions;
//
///**
// *
// * @author Admin
// */
//public class ReaderTest {
//
//    private static Connection conn;
//    ReaderServices RS;
//    AccountServices AS;
//    HashPassword password;
//    LocalDate currentDate = LocalDate.now();
////    @Test
////    public void testUsernameUnique() throws SQLException {
////        Connection conn = JdbcUtils.getConn();
////        PreparedStatement stm = conn.prepareStatement("SELECT * FROM account");
////        ResultSet rs = stm.executeQuery();
////        List<String> s = new ArrayList<>();
////        while (rs.next()) {
////            String userName = rs.getString("user_name");
////            s.add(userName);
////        }
////        Set<String> kq = new HashSet<>(s);
////        Assertions.assertEquals(s.size(), kq.size());
////        if (conn != null) {
////            conn.close();
////        }
////    }
////    
////    @Test
////    public void testLogin() throws SQLException {
////        password = new HashPassword();
////        AS = new AccountServices();
////        String us = "phong123";
////        String p = password.Hash_Password("123123123");
////        Assertions.assertTrue(AS.CheckLogin(us, p));
////        
////    }
////
////    @Test//add khach hang
////    public void testAddReader() throws SQLException {
////        RS = new ReaderServices();
////        HashPassword hp = new HashPassword();
////        AS = new AccountServices();
////        Reader r = new Reader();
////        Account account = new Account();
////        
////        account.setAccountId(AS.getAccountId());
////        account.setUsername("huuducdz1234");
////        account.setPassword(hp.Hash_Password("12345678"));
////        account.setRole("KH");
////        
////        r.setReaderId(RS.getMaxReader());
////        r.setReaderName("Duke");
////        r.setGender("nam");
////        r.setRole("Student");
////        r.setPosition("Khoa CNTT");
////        r.setEmail("duc123@gmail.com");
////        r.setAddress("Quảng Nam");
////        r.setPhone("079964972");
////        r.setBorrowingAvailability(4);
////        r.setAccountId_Reader(account.getAccountId());
////        
////        int b = RS.getListReader(null).size();
////        int a = AS.getListAccount().size();
////        AS.addAccount(account);        
////        RS.addReader(r);
////        Assertions.assertEquals(a + 1, AS.getListAccount().size());
////        Assertions.assertEquals(b + 1, RS.getListReader(null).size());
////        
////    }
//   
//    
// 
//}
