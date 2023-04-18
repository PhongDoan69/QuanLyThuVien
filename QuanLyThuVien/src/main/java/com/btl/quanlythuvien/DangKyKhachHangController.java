/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.HashPassword;
import com.btl.conf.Utils;

import com.btl.pojo.Account;
import com.btl.pojo.Reader;

import com.btl.services.AccountServices;
import com.btl.services.ReaderServices;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class DangKyKhachHangController implements Initializable {

    @FXML
    private TextField txtTenKH;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtCMND;
    @FXML
    private ComboBox cbGioiTinh;
    @FXML
    private TextField txtDiaChi;
    @FXML
    private ComboBox cbDoiTuong;
    @FXML
    private TextField txtBoPhan;
    @FXML
    private Label lbHanThe;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtXacNhanPass;
    @FXML
    private Button btnDangKy;
    @FXML
    private Button btnThoat;
    @FXML
    private CheckBox ckbhienMatKhau;

    @FXML
    private PasswordField apasss;

    private Reader reader;
    private Account account;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            ObservableList a = FXCollections.observableArrayList("Nam", "Nữ", "Khác");
            cbGioiTinh.setItems(a);
            cbGioiTinh.setValue(a.get(0));

            ObservableList b = FXCollections.observableArrayList("Sinh Viên", "Giảng Viên", "Viên Chức");
            cbDoiTuong.setItems(b);
            cbDoiTuong.setValue(b.get(0));

            LocalDate now = LocalDate.now();
            LocalDate oneMonthLater = now.plusMonths(1);
            this.lbHanThe.setText(oneMonthLater.toString());
        } catch (Exception ex) {
            Logger.getLogger(DangKyKhachHangController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void addReaderHandler(ActionEvent event) throws SQLException, ParseException, Exception {
        try {
            AccountServices as = new AccountServices();
            Reader r = new Reader();
            HashPassword mk = new HashPassword();
            String passHash = "";
            Account a = new Account();
            ReaderServices rs = new ReaderServices();

            if (txtTenKH.getText().trim().equals("")
                    || txtDiaChi.getText().trim().equals("") || txtUsername.getText().trim().equals("")
                    || txtPassword.getText().trim().equals("") || txtXacNhanPass.getText().trim().equals("")
                    || txtCMND.getText().trim().equals("") || txtSDT.getText().trim().equals("")) {
                Utils.getBox("Vui lòng nhập đủ thông tin cần đăng ký!", Alert.AlertType.WARNING).show();
            } else {
                if (!txtPassword.getText().toString().equals(txtXacNhanPass.getText().toString())) {
                    Utils.getBox("Mật khẩu và xác nhận mật khẩu phải trùng nhau", Alert.AlertType.WARNING).show();
                } else {
                    if (txtPassword.getText().length() < 6 || txtUsername.getText().length() < 6) {
                        Utils.getBox("Tên tài khoản và mật khẩu không được dưới 6 ký tự", Alert.AlertType.WARNING).show();
                    } else if (txtUsername.getText().contains(" ") || txtPassword.getText().contains(" ")) {
                        Utils.getBox("Vui lòng nhập mật khẩu và tài khoản không có khoảng trắng!", Alert.AlertType.WARNING).show();
                    } else if (parseInt(txtSDT.getText()) <= 0 || parseInt(txtCMND.getText()) <= 0) {
                        throw new NumberFormatException();
                    } else {
                        r.setReaderId(rs.getMaxReader());
                        r.setReaderName(this.txtTenKH.getText());
                        r.setGender(this.cbGioiTinh.getValue().toString());
                        r.setRole(this.cbGioiTinh.getValue().toString());
                        r.setAddress(this.txtDiaChi.getText());
                        r.setPosition(this.txtBoPhan.getText());
                        r.setEmail(this.txtEmail.getText());
                        r.setBorrowingAvailability(5);
                        // Xử lí hạn thẻ
                        Date currentDate = new Date(System.currentTimeMillis());
                        LocalDate localDate = currentDate.toLocalDate().plusMonths(6);
                        Date next6MonthDate = Date.valueOf(localDate);
                        r.setDateOfCallCard(next6MonthDate);

                        r.setPhone(this.txtSDT.getText());
                        r.setAccountId_Reader(as.getAccountId());
                        
                        a.setUsername(this.txtUsername.getText());
                        passHash = mk.Hash_Password(this.txtPassword.getText());
                        
                        a.setPassword(passHash);
                        a.setAccountId(as.getAccountId());
                        a.setRole("DG");
                        try {
                            as.addAccount(a);
                            rs.addReader(r);
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

    public void btnThoat(ActionEvent event) {
        Stage stage = (Stage) btnThoat.getScene().getWindow();
        stage.close();
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
