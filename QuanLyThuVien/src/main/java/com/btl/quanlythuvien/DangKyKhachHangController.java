/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.HashPassword;
import com.btl.conf.Utils;

import com.btl.pojo.Account;
import com.btl.pojo.KhachHang;

import com.btl.services.AccountServices;
import com.btl.services.KhachHangServices;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class DangKyKhachHangController implements Initializable  {

    @FXML
    TextField txtTenKH;
    @FXML
    TextField txtSDT;
    @FXML
    TextField txtCMND;
    @FXML
    TextField txtGT;
    @FXML
    TextField txtDiaChi;
    @FXML
    TextField txtUsername;
    @FXML
    TextField txtPassword;
    @FXML
    TextField txtXacNhanPass;
    @FXML
    Button btnDangKy;
    @FXML
    Button btnThoat;
    @FXML
    CheckBox ckbhienMatKhau;
    @FXML
    ComboBox cbGioiTinh;
    @FXML
    PasswordField apasss;

    private KhachHang khachHang;
    private Account account;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            ObservableList a = FXCollections.observableArrayList("Nam", "Nữ", "Khác");
            cbGioiTinh.setItems(a);
            cbGioiTinh.setValue(a.get(0));

        } catch (Exception ex) {
            Logger.getLogger(DangKyKhachHangController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void addKhachHangHandler(ActionEvent event) throws SQLException, ParseException, Exception {
        try {
            AccountServices as = new AccountServices();
            KhachHang k = new KhachHang();
            HashPassword mk = new HashPassword();
            String passHash = "";
            Account a = new Account();
            KhachHangServices s = new KhachHangServices();

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
                        k.setMaKH(s.getMaxKhachHang());
                        k.setCMND(Integer.toString(parseInt(this.txtCMND.getText())));
                        k.setTenKH(this.txtTenKH.getText());
                        k.setGioiTinh(this.cbGioiTinh.getValue().toString());
                        k.setDiaChi(this.txtDiaChi.getText());
                        k.setSDT(Integer.toString(parseInt(this.txtSDT.getText())));
                        k.setMaAcc(as.getMaAccount());
                        a.setUsername(this.txtUsername.getText());
                        passHash = mk.Hash_Password(this.txtPassword.getText());
                        a.setPassword(passHash);
                        a.setAccountId(as.getMaAccount());
                        a.setTypeUser("KH");
                        try {
                            as.addAccount(a);
                            s.addKhachHang(k);
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
    
    /**
     * @return the khachHang
     */
    public KhachHang getKhachHang() {
        return khachHang;
    }

    /**
     * @param khachHang the khachHang to set
     */
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }
}