/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.btl.quanlythuvien;

import com.btl.pojo.Book;
import com.btl.pojo.Reader;
import com.btl.services.BookServices;
import com.btl.services.DatSachServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DatSachController implements Initializable {
    @FXML TextField txtTongSoSach;
    @FXML TextField txtMaSach;
    @FXML TextField txtSoLuong;
    @FXML private TableView<Book> tbSach;
    @FXML TableView tvSachDaChon;
    BookServices sv = new BookServices();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTvSach();
        try {
            LoadDataViewDatSach();
        } catch (SQLException ex) {
            Logger.getLogger(DatSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    } 
    
    //TabDatSach
    private void loadTvSach(){
        TableColumn colBookID = new TableColumn("Mã sách");
        colBookID.setCellValueFactory(new PropertyValueFactory("bookId"));
        colBookID.setPrefWidth(100);
        
        TableColumn colBookName = new TableColumn("Tên sách");
        colBookName.setCellValueFactory(new PropertyValueFactory("bookName"));
        colBookName.setPrefWidth(100);
        
        TableColumn colBookCategory = new TableColumn("Thể loại");
        colBookCategory.setCellValueFactory(new PropertyValueFactory("bookCategory"));
        colBookCategory.setPrefWidth(100);
        
        TableColumn colBookDescription = new TableColumn("Mô tả");
        colBookDescription.setCellValueFactory(new PropertyValueFactory("bookDescription"));
        colBookDescription.setPrefWidth(100);
        
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
        this.tbSach.getColumns().addAll(colBookID, colBookName, colBookCategory, colBookDescription, colPublish, colPublishYear, colEntryDate, colBookPosition);
    }
    
    
    public void LoadDataViewDatSach() throws SQLException{
        this.tbSach.setItems(FXCollections.observableArrayList(sv.getListBook()));
    }
    
}
