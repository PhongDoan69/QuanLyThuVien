/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.services;

import com.btl.conf.JdbcUtils;
import com.btl.pojo.Employee;
import java.math.BigDecimal;

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
public class EmployeeServices {
    

    public int getMaxEmployeeId() throws SQLException {
        int maxID = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT MAX(id) FROM employee";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        }
        return (maxID + 1);
    }

    public void addEmployee(Employee e) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO employee(id, employee_name, phone, cmnd,account_id)"
                    + "VALUES(?,?,?,?,?)");
            stm.setInt(1, e.getEmployeeId());
            stm.setString(2, e.getEmployeeName());
            stm.setString(3, e.getPhone());
            stm.setString(4, e.getCmnd());
            stm.setInt(5, e.getAccountId());
            
            stm.executeUpdate();
        }
    }

    public List<Employee> getListEmployee(String kw) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM employee  ";
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE id like concat('%', ?, '%') OR employee_name like concat('%', ?, '%') ";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
                stm.setString(2, kw);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("employee_name"),
                        rs.getString("phone"),
                        rs.getString("cmnd"),
                        rs.getInt("account_id"));
                employees.add(e);
            }
        }
        return employees;
    }
    
   

    public Employee getEmployee(int eId) throws SQLException {
        Employee e;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM employee Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(eId));
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                e = new Employee(
                        rs.getInt("id"),
                        rs.getString("employee_name"),
                        rs.getString("phone"),
                        rs.getString("cmnd"),
                        rs.getInt("account_id"));
            }
        }
        return e;
    }
    
    public Employee getEmployeeByAccount(int eId) throws SQLException {
        Employee e = null;
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM employee Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(eId));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
              e = new Employee(
                        rs.getInt("id"),
                        rs.getString("employee_name"),
                        rs.getString("phone"),
                        rs.getString("cmnd"),
                        rs.getInt("account_id"));
            }
        }
        return e;
    }
    public void deleteEmployee(int employeeId) throws SQLException {
        try (Connection cnn = JdbcUtils.getConn()) {
            String sql = "DELETE FROM employee WHERE (id = ?);";

            PreparedStatement stm2 = cnn.prepareStatement(sql);
            stm2.setInt(1, employeeId);
            stm2.execute();
        }
    }
    
    public Employee getReaderByUsername(String userName) throws SQLException {
        Employee e = null;

        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "select r.* from account ac, employee e where  ac.user_name = ? and ac.id = e.id ";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
               e = new Employee(
                        rs.getInt("id"),
                        rs.getString("employee_name"),
                        rs.getString("phone"),
                        rs.getString("cmnd"),
                        rs.getInt("account_id"));
            }
        }
        return e;
    }

     
     
}
