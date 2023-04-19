/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import com.btl.conf.HashPassword;
import com.btl.conf.JdbcUtils;
import com.btl.pojo.Account;
import com.btl.pojo.Employee;
import com.btl.services.AccountServices;
import com.btl.services.EmployeeServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Admin
 */
public class EmployeeTest {

    private static Connection conn;
    EmployeeServices ES;
    AccountServices AS;
    HashPassword HP;
    int accountId = 3;
    int accountEmployeeId = 3;
//    @Test
//     public void testUniqueUsernameEmployee() throws SQLException{
//        Connection conn = JdbcUtils.getConn();
//        PreparedStatement stm = conn.prepareStatement("SELECT * FROM account");
//        ResultSet rs = stm.executeQuery();
//        List<String> s = new ArrayList<>();
//        while(rs.next()){
//         String name = rs.getString("user_name");
//            s.add(name);
//        }
//        Set<String> kq = new HashSet<>(s);
//        Assertions.assertEquals(s.size(), kq.size());
//        if(conn != null)
//            conn.close();
//    }

//    @Test 
//    public void testDangNhap()throws  SQLException{
//        HP= new HashPassword();
//        AS= new AccountServices();
//        String us="phong123";
//        String p=HP.Hash_Password("123123123");
//        Assertions.assertTrue(AS.CheckLogin(us, p));
//        
//    }
//    @Test
//    public void testAddEmployee() throws SQLException{
//        ES = new EmployeeServices();
//        AS = new AccountServices();
//        Employee emp = new Employee();
//        Account acc = new Account();
//        emp.setEmployeeId(accountEmployeeId);
//        emp.setEmployeeName("Nguyễn Văn A");
//        emp.setCmnd("12345678");
//        emp.setPhone("1234585");
//        emp.setAccountId(ES.getMaxEmployeeId());
//
//        
//        
//        acc.setAccountId(16);
//        acc.setUsername("nguyenvana");
//        acc.setPassword("12345678");
//        acc.setRole("NV");
//        
//        int a = ES.getListEmployee(null).size();
//        int b = AS.getListAccount().size();
//        AS.addAccount(acc);
//        ES.addEmployee(emp);
//        Assertions.assertNotNull(ES.getEmployee(3));
//        Assertions.assertEquals(a + 1, ES.getListEmployee(null).size());
//        Assertions.assertEquals(b + 1, AS.getListAccount().size());
//    }
    //Test xoá nhân viên
//    @Test
//    public void testAddEmployee() throws SQLException {
//        AS = new AccountServices();
//        ES = new EmployeeServices();
//
//        Employee nv = ES.getEmployee(accountId);
//        int a = ES.getListEmployee(null).size();
//        ES.deleteEmployee(4);
//        AS.deleteAccount(21);
//        Assertions.assertNull(ES.getEmployee(4));
//        Assertions.assertEquals(a - 1, ES.getListEmployee(null).size());
//
//    }
//    

}
