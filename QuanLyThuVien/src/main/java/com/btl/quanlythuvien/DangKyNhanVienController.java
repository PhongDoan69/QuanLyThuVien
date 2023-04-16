/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.btl.quanlythuvien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DangKyNhanVienController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtCMND;
    @FXML
    private TextField txtChucVu;
    @FXML
    private TextField txtAccount;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtConfirmPW;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void btnDangKyNV(ActionEvent event)
    {
        
    }

}
