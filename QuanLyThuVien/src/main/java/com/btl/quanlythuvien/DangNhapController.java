/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.HashPassword;
import com.btl.conf.Utils;
import com.btl.pojo.Account;

import com.btl.services.AccountServices;
import com.btl.services.KhachHangServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class DangNhapController implements Initializable {

    @FXML
    private ComboBox<String> cbQuyenTruyCap;
    @FXML
    private TextField tfTaiKhoan;
    @FXML
    private TextField tfMatKhau;
    @FXML
    Label quyen;

    public static String taikhoan;
    public static boolean login = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList a = FXCollections.observableArrayList("Khách Hàng", "Nhân Viên");
            cbQuyenTruyCap.setItems(a);

        } catch (Exception ex) {
            Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void btnDangKy(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("DangKyKhachHang.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Đăng Ký");
        stage.show();
    }
    
    public void btnDangNhap (ActionEvent event)throws SQLException,  IOException{
       HashPassword hp= new HashPassword();
       KhachHangServices ks=new KhachHangServices();
       Account a= new Account();       
       AccountServices s= new AccountServices();
        
           String u= (this.tfTaiKhoan.getText());
           String p=hp.Hash_Password(this.tfMatKhau.getText()); 
           boolean check=false;
           check=s.CheckLogin(u, p);      
           taikhoan=this.tfTaiKhoan.getText();   
      
       

        if(!(tfTaiKhoan).getText().isEmpty() || !(tfMatKhau).getText().isEmpty()||tfMatKhau.getText().equals("")||tfTaiKhoan.getText().equals(""))
        { 
          if(cbQuyenTruyCap.getValue()=="Khách Hàng"){
            a.setTypeUser("KH");              
        if(!((tfTaiKhoan).getText().isEmpty() || (tfMatKhau).getText().isEmpty()||tfMatKhau.getText().equals("")||tfTaiKhoan.getText().equals(""))){
                      if(check && s.checkACCOUNT(a)==1){
                             login=true;
                             KhachHangServices kh = new KhachHangServices();
                             Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                             FXMLLoader loader = new FXMLLoader();
                             loader.setLocation(getClass().getResource("FGiaoDienKH.fxml"));
                             Parent d = loader.load();
                             Scene scene = new Scene(d);
                             GiaoDienKhachHangController controller = loader.getController();
                             controller.setK(kh.getKhachHangByAccount(u));
                             stage.setScene(scene); 
                      } 
             else 
                 Utils.getBox("Sai tài khoản, mật khảu!", Alert.AlertType.WARNING).show();
         }
         else
                 Utils.getBox("Chưa nhập đủ thông tin!", Alert.AlertType.WARNING).show();


        }
        else  if(cbQuyenTruyCap.getValue()=="Nhân Viên"){
            a.setTypeUser("NV");


        if(!((tfTaiKhoan).getText().isEmpty() || (tfMatKhau).getText().isEmpty()||tfMatKhau.getText().equals("")||tfTaiKhoan.getText().equals("")))
        {
            if(check && s.checkACCOUNT(a) == -1){
                login=true;
                success_NV();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
            else 
                Utils.getBox("Sai tài khoản, mật khảu!", Alert.AlertType.WARNING).show();
        }
        else
                Utils.getBox("Chưa nhập đủ thông tin!", Alert.AlertType.WARNING).show();      

        }else
            Utils.getBox("Chưa chọn quyền truy cập!", Alert.AlertType.WARNING).show();
        }
        else
            Utils.getBox("Chưa nhập đủ thông tin!", Alert.AlertType.WARNING).show();
    }
  

    public void success_NV ()throws IOException{
        FXMLLoader fxmlLoader= new FXMLLoader(App.class.getResource("FQuanLy.fxml"));
        
        Scene scene= new Scene(fxmlLoader.load());
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.setTitle("Quản Lý");
        stage.show();
    }
}
