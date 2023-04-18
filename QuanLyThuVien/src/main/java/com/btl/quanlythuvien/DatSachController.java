/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.conf.Utils;
import com.btl.pojo.Book;
import com.btl.pojo.CallCard;
import com.btl.pojo.CallCardDetail;
import com.btl.pojo.Reader;
import com.btl.services.BookServices;
import com.btl.services.CallCardDetailServices;
import com.btl.services.DatSachServices;
import static java.lang.Integer.parseInt;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DatSachController implements Initializable {

    @FXML
    TextField txtTongSoSach;
    @FXML
    TextField txtMaSach;
    @FXML
    TextField txtSoLuong;
    @FXML
    TextField txtFindBook;
    @FXML
    private TableView<Book> tvSach;
    @FXML
    TableView tvSachDaChon;
    @FXML
    TextField txtNgayDat;
    @FXML
    TextField txtHanTra;

    Reader r = App.getCurR();
    public boolean flag = false;
    private int macc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadTvSach();
//            this.LoadTabDatSach(r);
    }

    //TabDatSach
    private void loadTvSach() {
        TableColumn colBookID = new TableColumn("Mã sách");
        colBookID.setCellValueFactory(new PropertyValueFactory("bookId"));
        colBookID.setPrefWidth(50);

        TableColumn colBookName = new TableColumn("Tên sách");
        colBookName.setCellValueFactory(new PropertyValueFactory("bookName"));
        colBookName.setPrefWidth(100);

        TableColumn colBookCategory = new TableColumn("Thể loại");
        colBookCategory.setCellValueFactory(new PropertyValueFactory("bookCategory"));
        colBookCategory.setPrefWidth(100);

        TableColumn colBookDescription = new TableColumn("Mô tả");
        colBookDescription.setCellValueFactory(new PropertyValueFactory("bookDescription"));
        colBookDescription.setPrefWidth(100);

        TableColumn colAuthor = new TableColumn("Tác giả");
        colAuthor.setCellValueFactory(new PropertyValueFactory("author"));
        colAuthor.setPrefWidth(100);

        TableColumn colPublish = new TableColumn("NXB");
        colPublish.setCellValueFactory(new PropertyValueFactory("publish"));
        colPublish.setPrefWidth(100);

        TableColumn colPublishYear = new TableColumn("Năm xuất bản");
        colPublishYear.setCellValueFactory(new PropertyValueFactory("publishYear"));
        colPublishYear.setPrefWidth(100);

        TableColumn colEntryDate = new TableColumn("Ngày Nhập");
        colEntryDate.setCellValueFactory(new PropertyValueFactory("entryDate"));
        colEntryDate.setPrefWidth(100);

        TableColumn colBookPosition = new TableColumn("Vị trí");
        colBookPosition.setCellValueFactory(new PropertyValueFactory("bookPosition"));
        colBookPosition.setPrefWidth(100);

        TableColumn colInstock = new TableColumn("Số lượng");
        colInstock.setCellValueFactory(new PropertyValueFactory("inStock"));
        colInstock.setPrefWidth(100);
        this.tvSach.getColumns().addAll(colBookID, colBookName, colBookCategory, colBookDescription, colAuthor, colPublish, colPublishYear, colEntryDate, colBookPosition, colInstock);
    }

    private void loadTvSachData(String kw) throws SQLException {
        BookServices b = new BookServices();

        this.tvSach.setItems(FXCollections.observableList(b.getListBook(kw)));

    }

    private void loadTvSachDaChon() {
        
        TableColumn colCallCardDetail = new TableColumn("Mã chi tiet phieu muon");
        colCallCardDetail.setCellValueFactory(new PropertyValueFactory("callCardDetailId"));
        colCallCardDetail.setPrefWidth(100);
        
        TableColumn colIstock = new TableColumn("Số lượng");
        colIstock.setCellValueFactory(new PropertyValueFactory("quantity"));
        colIstock.setPrefWidth(100);
        
        TableColumn colBookID = new TableColumn("Mã sách");
        colBookID.setCellValueFactory(new PropertyValueFactory("bookId"));
        colBookID.setPrefWidth(100);        
        
        TableColumn colCallCardID = new TableColumn("Số lượng");
        colCallCardID.setCellValueFactory(new PropertyValueFactory("callCardID"));
        colCallCardID.setPrefWidth(100);
        
        this.tvSachDaChon.getColumns().addAll(colBookID, colIstock);
        
    }

    private void loadTvSachDaChonData(int id) throws SQLException {
        CallCardDetailServices b = new CallCardDetailServices();
        this.tvSachDaChon.setItems(FXCollections.observableList(b.getListCallCardDetail(id)));
    }

    private void MouseClickTvSach() {
        tvSach.setRowFactory((tv) -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked((event) -> {
                if (event.getClickCount() != 0 && (!row.isEmpty())) {
                    Book rowData = row.getItem();
                    this.txtMaSach.setText(String.valueOf(rowData.getBookId()));
                }
            });
            return row;
        });
    }

    private void MouseClickTvSachDaChon() {
        tvSachDaChon.setRowFactory((tv) -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked((event) -> {
                if (event.getClickCount() != 0 && (!row.isEmpty())) {
                    Book rowData = row.getItem();
                    this.txtMaSach.setText(String.valueOf(rowData.getBookId()));
                    this.txtSoLuong.setText(String.valueOf(rowData.getInStock()));
                }
            });
            return row;
        });
    }

    public void LoadTabDatSach(Reader r) throws SQLException {
        this.loadTvSach();
        this.MouseClickTvSach();
        MouseClickTvSachDaChon(); 
        DatSachServices ds = new DatSachServices();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        this.txtNgayDat.setText(d.format(java.sql.Date.valueOf(LocalDate.now())));
        this.macc = ds.getMaxCallCard();
        this.txtHanTra.setText(d.format(java.sql.Date.valueOf(LocalDate.now().plusDays(30))));
        try {
            this.loadTvSachData(null);
        } catch (SQLException ex) {
            Logger.getLogger(DatSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtFindBook.textProperty().addListener((evt) -> {

            try {
                this.loadTvSachData(this.txtFindBook.getText().trim());
            } catch (SQLException ex) {
                Logger.getLogger(DatSachController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    public void addSach(ActionEvent event) throws SQLException, ParseException, Exception {
        CallCard cc = new CallCard();
        DatSachServices dds = new DatSachServices();
        CallCardDetail ccd = new CallCardDetail();
        CallCardDetailServices ccds = new CallCardDetailServices();
        cc.setCallCardId(dds.getMaxCallCard());
        cc.setReaderId(this.r.getReaderId());
        cc.setDateGetBook(java.sql.Date.valueOf(LocalDate.now().plusDays(2)));
        cc.setReturnDate(java.sql.Date.valueOf(LocalDate.now().plusDays(30)));

        dds.addCallCard(cc);
        ccd.setCallCardDetailId(ccds.getMaxCallCardDetail());
        ccd.setBookId(parseInt(this.txtMaSach.getText()));
        ccd.setQuantity(parseInt(this.txtSoLuong.getText()));
        ccd.setCallCardId(cc.getCallCardId());
        ccds.addCallCardDetail(ccd);
        
//            if (txtMaSach.getText().trim().equals("")) {
//                throw new Exception("Vui lòng chọn 1 sách");
//            }
//            if (this.txtSoLuong.getText().trim().equals("")) {
//                throw new Exception("Vui lòng nhap so sach can muon");
//            }
        this.loadTvSachDaChonData(ccd.getCallCardDetailId());
        this.loadTvSachDaChon();
        Utils.getBox("Thêm thành công!", Alert.AlertType.INFORMATION).show();
        // create callCardDetail
//        if (flag==true){
//            try{
//                if(!"".equals(txtMaMA.getText().trim()))
//            }
//            catch(){
//                
//            }
//        }
    }

}
