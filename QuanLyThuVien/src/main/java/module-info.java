module com.btl.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.btl.quanlythuvien to javafx.fxml;
    exports com.btl.quanlythuvien;
}
