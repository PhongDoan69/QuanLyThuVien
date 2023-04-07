module com.btl.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.btl.quanlythuvien to javafx.fxml;
    exports com.btl.quanlythuvien;
    exports com.btl.conf;
    exports com.btl.pojo;
}
