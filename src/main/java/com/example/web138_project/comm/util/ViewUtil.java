package com.example.web138_project.comm.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewUtil {
    public static void start(String url,String title){
        Parent root =null;
        try {
            root = FXMLLoader.load(ViewUtil.class.getResource(url));
            //设置场景
            Scene scene = new Scene(root, 1100, 800);
            //创建舞台
            Stage stage =new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void  close(Parent parent){
        Stage stage =(Stage) parent.getScene().getWindow();
        stage.close();
    }
}
