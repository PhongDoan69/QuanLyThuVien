package com.btl.quanlythuvien;

import com.btl.pojo.Account;
import com.btl.pojo.Reader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static Account curAcc;
    private static Reader curR;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("DangNhap.fxml"));

        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException ex) {
            Logger.getLogger(GiaoDienKhachHangController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }

    /**
     * @return the curAcc
     */
    public static Account getCurAcc() {
        return curAcc;
    }

    /**
     * @param aCurAcc the curAcc to set
     */
    public static void setCurAcc(Account aCurAcc) {
        curAcc = aCurAcc;
    }

    /**
     * @return the curR
     */
    public static Reader getCurR() {
        return curR;
    }

    /**
     * @param aCurR the curR to set
     */
    public static void setCurR(Reader aCurR) {
        curR = aCurR;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        App.scene = scene;
    }
}
