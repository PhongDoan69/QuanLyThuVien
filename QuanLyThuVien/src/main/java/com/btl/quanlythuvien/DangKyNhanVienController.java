/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.HashPassword;
import com.btl.conf.Utils;
import com.btl.pojo.Account;
import com.btl.pojo.Employee;

import com.btl.services.AccountServices;
import com.btl.services.EmployeeServices;
import com.btl.services.ReaderServices;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DangKyNhanVienController implements Initializable {

    @FXML
    private TextField txtTenNhanVien;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtSoCMND;
    @FXML
    private TextField txtTenTK;
    @FXML
    private TextField txtMatKhau;
    @FXML
    private TextField txtXacNhanMK;
    @FXML
    private Button btnThoatDKNV;
    @FXML
    private Button btnDangKyNhanVien;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private Employee employee;
    private Account account;

//    public void addEmployeeHandler(ActionEvent event) throws SQLException, ParseException {
//        try {
//            AccountServices as = new AccountServices();
//            Employee e = new Employee();
//            HashPassword mk = new HashPassword();
//            String pass = "";
//            Account a = new Account();
//            EmployeeServices es = new EmployeeServices();
//
//            if (txtTenNhanVien.getText().trim().equals("")
//                    || txtSDT.getText().trim().equals("") || txtSoCMND.getText().trim().equals("")
//                    ||  txtTenTK.getText().trim().equals("")
//                    || txtMatKhau.getText().trim().equals("") || txtXacNhanMK.getText().trim().equals(""))  {
//                throw new Exception("Không được để trống thông tin");
//            }
//            if (!txtMatKhau.getText().equals(txtXacNhanMK.getText())) {
//                throw new Exception("Mật khẩu và xác nhận mật khẩu phải trùng nhau");
//            }
//            if (txtTenTK.getText().contains(" ") || txtTenTK.getText().length() < 6) {
//                throw new Exception("Vui lòng nhập tên tài khoản ít nhất 6 kì tự và không có khoảng trắng!");
//            }
//            if (txtMatKhau.getText().length() < 6 || txtMatKhau.getText().contains(" ")) {
//                throw new Exception("Vui lòng nhập mật khẩu ít nhất 6 kì tự và không có khoảng trắng!");
//            }
//            if (parseInt(txtSDT.getText()) <= 0 || parseInt(txtSoCMND.getText()) <= 0) {
//                throw new NumberFormatException();
//            }
//            if (as.FindAccountByUsername(this.txtTenTK.getText()) != null) {
//                throw new Exception("Tên tài khoản đã tồn tại");
//            }
//            e.setEmployeeId(es.getMaxEmployeeId());
//            e.setEmployeeName(this.txtTenNhanVien.getText());
//            e.setPhone(Integer.toString(parseInt(this.txtSDT.getText())));
//            e.setCmnd(Integer.toString(parseInt(this.txtSoCMND.getText())));         
//            e.setAccountId(as.getAccountId());
//
//            pass = mk.Hash_Password(this.txtMatKhau.getText());
//
//            a.setAccountId(as.getAccountId());
//            a.setUsername(this.txtTenTK.getText());
//            a.setPassword(pass);
//            a.setRole("NV");
//            as.addAccount(a);
//            es.addEmployee(e);
//            Utils.getBox("Thêm thành công", Alert.AlertType.INFORMATION).show();
//        } catch (NumberFormatException ex) {
//            Utils.getBox("Vui lòng nhập đúng kiểu dữ liệu!", Alert.AlertType.INFORMATION).show();
//        } catch (Exception ex) {
//            Utils.getBox(ex.getMessage(), Alert.AlertType.INFORMATION).show();
//        }
//    }
    public void addEmployeeHandler(ActionEvent event) throws SQLException, ParseException, Exception {
        try {
            AccountServices as = new AccountServices();
            Employee e = new Employee();
            HashPassword mk = new HashPassword();
            String passHash = "";
            Account a = new Account();
            EmployeeServices es = new EmployeeServices();

            if (txtTenNhanVien.getText().trim().equals("")
                    || txtTenTK.getText().trim().equals("")
                    || txtMatKhau.getText().trim().equals("") || txtXacNhanMK.getText().trim().equals("")
                    || txtSDT.getText().trim().equals("") || txtSDT.getText().trim().equals("")) {
                Utils.getBox("Vui lòng nhập đủ thông tin cần đăng ký!", Alert.AlertType.WARNING).show();
            } else {
                if (!txtMatKhau.getText().toString().equals(txtXacNhanMK.getText().toString())) {
                    Utils.getBox("Mật khẩu và xác nhận mật khẩu phải trùng nhau", Alert.AlertType.WARNING).show();
                } else {
                    if (txtMatKhau.getText().length() < 6 || txtTenTK.getText().length() < 6) {
                        Utils.getBox("Tên tài khoản và mật khẩu không được dưới 6 ký tự", Alert.AlertType.WARNING).show();
                    } else if (txtTenTK.getText().contains(" ") || txtMatKhau.getText().contains(" ")) {
                        Utils.getBox("Vui lòng nhập mật khẩu và tài khoản không có khoảng trắng!", Alert.AlertType.WARNING).show();
                    } else if (parseInt(txtSDT.getText()) <= 0 || parseInt(txtSoCMND.getText()) <= 0) {
                        throw new NumberFormatException();
                    } else {
                        //tao Employee moi
                        e.setEmployeeId(es.getMaxEmployeeId());
                        e.setEmployeeName(this.txtTenNhanVien.getText());
                        e.setCmnd(this.txtSoCMND.getText());
                        e.setPhone(this.txtSDT.getText());
                        e.setAccountId(as.getAccountId());

                        //Tao account
                        a.setUsername(this.txtTenTK.getText());
                        passHash = mk.Hash_Password(this.txtMatKhau.getText());
                        a.setPassword(passHash);
                        a.setAccountId(as.getAccountId());
                        a.setRole("NV");

                        try {
                            as.addAccount(a);
                            es.addEmployee(e);
                            Utils.getBox("Thêm thành công", Alert.AlertType.INFORMATION).show();
                        } catch (SQLException ex) {
                            Utils.getBox("Tên tài khoản tồn tại!", Alert.AlertType.INFORMATION).show();
                            Logger.getLogger(DangKyKhachHangController.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                }
            }
        } catch (NumberFormatException ex) {
            Utils.getBox("Vui lòng nhập đúng kiểu dữ liệu!", Alert.AlertType.INFORMATION).show();
        }
    }

    public void btnThoatDKNV(ActionEvent event) {
        Stage stage = (Stage) btnThoatDKNV.getScene().getWindow();
        stage.close();
    }

    public Employee getReader() {
        return employee;
    }

    public void setReader(Employee employee) {
        this.employee = employee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
