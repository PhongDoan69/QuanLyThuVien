/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.Account;
import com.btl.services.AccountServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
/**
 *
 * @author Admin
 */
public class AccountTest {

    AccountServices accountReader;
    int accountId = 1;
    
    @Test
    public void testUsername() throws SQLException{
        Connection conn = JdbcUtils.getConn();
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM account");
        ResultSet rs = stm.executeQuery();
        List<String> s = new ArrayList<>();
        while(rs.next()){
        String name = rs.getString("user_name");
            s.add(name);
        System.out.println(name);
        }
        Set<String> kq = new HashSet<>(s);
        Assertions.assertEquals(s.size(), kq.size());
        if(conn != null)
            conn.close();    }
        
    
     @Test
    public void testGetAccountByUserName() throws SQLException{
        AccountServices s = new AccountServices();
        Assertions.assertNotNull(s.FindAccountByUsername("phong123"));
        Assertions.assertNull(s.FindAccountByUsername("duc123"));
    }
            
}
