/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.Utils;
import com.btl.pojo.Reader;
import com.btl.services.ReaderServices;
import com.btl.services.DatSachServices;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class GiaoDienKhachHangController implements Initializable {

    @FXML
    private ImageView imgDatSach;
    @FXML
    private ImageView imgThongTinDatSach;
    private Reader r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReaderServices rs = new ReaderServices();
        imgDatSach.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            DatSachServices ds = new DatSachServices();
            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("DatSach.fxml"));
                Parent d = loader.load();
                Scene scene = new Scene(d);
                DatSachController controller = loader.getController();
                try {
                    controller.LoadTabDatSach(r);
                } catch (SQLException ex) {
                    Logger.getLogger(GiaoDienKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(scene);
            } catch (IOException ex) {
                Logger.getLogger(GiaoDienKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
//        imgThongTinDatSach.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
//            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("FTiecDaDat.fxml"));
//            try {
//                Parent d = loader.load();
//                Scene scene = new Scene(d);
//                FTiecDaDatController controller = loader.getController();
//                controller.LoadTabDatTiec(k);
//                stage.setScene(scene);
//            } catch (IOException ex) {
//                Logger.getLogger(FGiaoDienKHController.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex) {
//                Logger.getLogger(FGiaoDienKHController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
    }

    public Reader getR() {
        return r;
    }

    public void setR(Reader r) {
        this.r = r;
    }

}
