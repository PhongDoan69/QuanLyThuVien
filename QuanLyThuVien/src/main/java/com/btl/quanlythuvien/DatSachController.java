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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DatSachController implements Initializable {

    @FXML
    Label lbTongSoSach;
    @FXML
    Label lbMPM;
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
    @FXML
    TextField txtMaKhachHang;
    @FXML
    TextField txtHoVaTen;
    @FXML
    TextField txtCMND;
    @FXML
    TextField txtSDT;
    
    @FXML
    TextField txtSoLuongXN;
    @FXML
    private TabPane tab;
    @FXML
    private Tab tab1;
    ObservableList<Sach> danhSachSach = FXCollections.observableArrayList();

    Reader r = App.getCurR();
    public boolean flag = false;
    private int maCC;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        if(this.r==null){
            this.r = new Reader();
        }
        Reader r = App.getCurR();
        try {
            this.loadTabXacNhan();
        } catch (SQLException ex) {
            Logger.getLogger(DatSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        TableColumn colQuantity = new TableColumn("Số lượng");
        colQuantity.setCellValueFactory(new PropertyValueFactory("soLuong"));
        colQuantity.setPrefWidth(200);

        TableColumn colBookID = new TableColumn("Mã sách");
        colBookID.setCellValueFactory(new PropertyValueFactory("maSach"));
        colBookID.setPrefWidth(200);

        this.tvSachDaChon.getColumns().addAll(colBookID, colQuantity);
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
            TableRow<Sach> row = new TableRow<>();
            row.setOnMouseClicked((event) -> {
                if (event.getClickCount() != 0 && (!row.isEmpty())) {
                    Sach rowData = row.getItem();
                    this.txtMaSach.setText(String.valueOf(rowData.maSach));
                    this.txtSoLuong.setText(String.valueOf(rowData.soLuong));
                }
            });
            return row;
        });
    }

    public void LoadTabDatSach(Reader r) throws SQLException {
        this.loadTvSach();
        this.MouseClickTvSach();
        this.loadTvSachDaChon();
        MouseClickTvSachDaChon();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        this.txtNgayDat.setText(d.format(java.sql.Date.valueOf(LocalDate.now())));
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

    public class Sach {

        private int maSach;
        private int soLuong;

        public Sach(int maSach, int soLuong) {
            this.maSach = maSach;
            this.soLuong = soLuong;
        }

        public int getMaSach() {
            return maSach;
        }

        public void setMaSach(int maSach) {
            this.maSach = maSach;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }

    }

    public int tinhTongSoLuongSach(List<Sach> sachList) {
        int tongSoLuong = 0;
        for (Sach sach : sachList) {
            tongSoLuong += sach.getSoLuong();
        }
        return tongSoLuong;
    }

    public void addVaoTabSachDaChon(ActionEvent event) throws SQLException {
        try {
            int maSach = Integer.parseInt(txtMaSach.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            
            Sach sachMoi = new Sach(maSach, soLuong);
            boolean sachDaTonTai = false;
            for (Sach sach : danhSachSach) {
                if (sach.getMaSach() == sachMoi.getMaSach()) {
                    sachDaTonTai = true;
                    break;
                }
            }
            if (!sachDaTonTai) {
                if ((parseInt(this.txtSoLuong.getText()) + parseInt(this.lbTongSoSach.getText())) > 5) {
                    Utils.getBox("Khong duoc muon qua 5 cuon sach!", Alert.AlertType.INFORMATION).show();
                    
                }
                else{
                danhSachSach.add(sachMoi);
                tvSachDaChon.setItems(danhSachSach);
                this.lbTongSoSach.setText(String.valueOf(tinhTongSoLuongSach(danhSachSach)));
                Utils.getBox("Them Thanh Cong!", Alert.AlertType.INFORMATION).show();
                this.txtMaSach.clear();
                this.txtSoLuong.clear();
                }
            } else {
                Utils.getBox("Sách đã có trong danh sách sách đa chọn của bạn!", Alert.AlertType.INFORMATION).show();
            }
        } catch (NumberFormatException ex) {
            Utils.getBox("Vui lòng chọn Sach để thêm!", Alert.AlertType.INFORMATION).show();
        }
    }

    public void capNhatSach(int maSach, int soLuong, List<Sach> danhSachSach) {
        for (Sach sach : danhSachSach) {
            if (sach.getMaSach() == maSach) {
                sach.setSoLuong(soLuong);
                break;
            }
        }
    }

    public void updateSachDaChon(ActionEvent event) throws SQLException, ParseException, Exception {
        try {

            if ("".equals(txtMaSach.getText().trim())) {
                throw new Exception("Vui lòng chọn 1 sach để cập nhật");
            }
            if (parseInt(txtSoLuong.getText()) <= 0) {
                throw new NumberFormatException();
            }
            if (parseInt(txtSoLuong.getText()) > 100) {
                throw new Exception("Số lượng món ăn không được vượt quá 100");
            }

//                if(s.getDatMonAn(maTiec, d.getMaMA()) != null){
            if ("".equals(txtSoLuong.getText().trim())) {
                throw new Exception("Vui lòng nhập số lượng sach");
            }
            int maSach = Integer.parseInt(txtMaSach.getText());
            int soLuongMoi = Integer.parseInt(txtSoLuong.getText());
            capNhatSach(maSach, soLuongMoi, danhSachSach);
            tvSachDaChon.refresh();
            this.lbTongSoSach.setText(String.valueOf(tinhTongSoLuongSach(danhSachSach)));
            this.txtMaSach.clear();
            this.txtSoLuong.clear();
            Utils.getBox("Cập nhật thành công!", Alert.AlertType.INFORMATION).show();
//                    }
//                else{
//                    Utils.getBox("Món ăn này không nằm trong thực đơn của bạn!", Alert.AlertType.INFORMATION).show();
//                }
        } catch (NumberFormatException ex) {
            Utils.getBox("Vui lòng nhập đúng kiểu dữ liệu!", Alert.AlertType.INFORMATION).show();
        } catch (Exception ex) {
            Utils.getBox(ex.getMessage(), Alert.AlertType.INFORMATION).show();
        }
    }

    public void xoaSach(int maSach, List<Sach> danhSachSach) {
        Iterator<Sach> iter = danhSachSach.iterator();
        while (iter.hasNext()) {
            Sach sach = iter.next();
            if (sach.getMaSach() == maSach) {
                iter.remove();
                break;
            }
        }
    }

    public void deleteSachDaChon(ActionEvent event) throws SQLException, ParseException, Exception {
        int maSach = Integer.parseInt(txtMaSach.getText());
        xoaSach(maSach, danhSachSach);
        tvSachDaChon.setItems(danhSachSach);
        this.lbTongSoSach.setText(String.valueOf(tinhTongSoLuongSach(danhSachSach)));
        this.txtMaSach.clear();
        this.txtSoLuong.clear();
        Utils.getBox("Xóa thành công!", Alert.AlertType.INFORMATION).show();
    }
    public void xacNhan(ActionEvent event) throws SQLException, ParseException, Exception {       
            CallCard cc = new CallCard();
            DatSachServices dds = new DatSachServices();
            cc.setCallCardId(cc.getCallCardId());
            cc.setReaderId(this.r.getReaderId());
            cc.setDateGetBook(java.sql.Date.valueOf(LocalDate.now().plusDays(2)));
            cc.setReturnDate(java.sql.Date.valueOf(LocalDate.now().plusDays(30)));
            dds.addCallCard(cc);
            CallCardDetail ccd = new CallCardDetail();
            CallCardDetailServices ccds = new CallCardDetailServices();
            for (Sach sach : danhSachSach) {
            ccd.setCallCardDetailId(ccds.getMaxCallCardDetail());
            ccd.setBookId(sach.maSach);
            ccd.setCallCardId(maCC);
            ccd.setQuantity(sach.soLuong);
            ccds.addCallCardDetail(ccd);
        }          
            Utils.getBox("Thêm thành công!", Alert.AlertType.INFORMATION).show();       
    }  

    public void loadTabXacNhan() throws SQLException {
        DatSachServices ds = new DatSachServices();
        this.maCC = ds.getMaxCallCard();
        this.txtMaKhachHang.setText(Integer.toString(this.r.getReaderId()));
        this.txtHoVaTen.setText(this.r.getReaderName());
        this.txtCMND.setText("1111111111");
        this.txtSDT.setText(this.r.getPhone());
        this.lbMPM.setText(Integer.toString(maCC));
        this.txtSoLuongXN.setText(String.valueOf(this.lbTongSoSach));
    }
}
