/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.Utils;
import com.btl.pojo.CallCard;
import com.btl.pojo.CallCardDetail;
import com.btl.pojo.Reader;
import com.btl.services.CallCardDetailServices;
import com.btl.services.ReaderServices;
import com.btl.quanlythuvien.DatSachController;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.btl.services.DatSachServices;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ThongTinDatSachController implements Initializable {

    @FXML
    private Label lbTenDocGia;
    @FXML
    private Label lbMaDocGia;
    @FXML
    private Label lbMaPhieuMuon;

    @FXML
    private TableView tvSachDaDat;

    Reader r = App.getCurR();
    private Reader reader;
    CallCard cc = new CallCard();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (this.r == null) {
            this.r = new Reader();
        }
        Reader r = App.getCurR();
        try {
            this.LoadTabThongTinPhieuMuon(r);
        } catch (SQLException ex) {
            Logger.getLogger(DatSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadTabThongTinPhieuMuon(Reader reader) throws SQLException {
        this.loadTvSachDaChonTTDS();
        this.lbTenDocGia.setText(reader.getReaderName());
        this.lbMaDocGia.setText(String.valueOf(reader.getReaderId()));
        

        loadTvSachDaChonTTDS();

        tvSachDaDat.setRowFactory((tv) -> {
            TableRow<CallCard> row = new TableRow<>();
            row.setOnMouseClicked((event) -> {
                if (event.getClickCount() != 0 && (!row.isEmpty())) {
                    CallCard rowData = row.getItem();
                    this.lbMaPhieuMuon.setText(String.valueOf(rowData.getCallCardId()));
                }
            });
            return row;
        });
    }

    public void quayLaiHandler(ActionEvent event) throws SQLException, ParseException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FGiaoDienKH.fxml"));
        Parent d = loader.load();
        Scene scene = new Scene(d);
        GiaoDienKhachHangController controller = loader.getController();;
        controller.setR(this.reader);
        stage.setScene(scene);
    }

    private void loadTvSachDaChonTTDS() {

        
        
        TableColumn colBookID = new TableColumn("Mã sách");
        colBookID.setCellValueFactory(new PropertyValueFactory("maSach"));
        colBookID.setPrefWidth(200);

        TableColumn colBookName = new TableColumn("Tên sách");
        colBookName.setCellValueFactory(new PropertyValueFactory("tenSach"));
        colBookName.setPrefWidth(200);

        TableColumn colQuantity = new TableColumn("Số lượng");
        colQuantity.setCellValueFactory(new PropertyValueFactory("soLuong"));
        colQuantity.setPrefWidth(200);

        this.tvSachDaDat.getColumns().addAll(colBookID,colBookName, colQuantity);
    }

    private void loadTvDatSachData(int ma) throws SQLException {
        DatSachServices s = new DatSachServices();
        this.tvSachDaDat.setItems(FXCollections.observableList(s.getListCallCard(ma)));
    }
}