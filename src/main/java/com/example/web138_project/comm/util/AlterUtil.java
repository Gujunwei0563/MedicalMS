package com.example.web138_project.comm.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.function.Consumer;

//用于弹出提示窗口！！！！
public class AlterUtil {
    public static void alert(String msg,Alert.AlertType type){
        //创建对象
        Alert alert = new Alert(type);
        //设置弹出窗口的内容
        alert.setContentText(msg);
        //显示弹出窗口
        alert.show();
    }
    public static void alertInfo(String msg){
        alert(msg,Alert.AlertType.INFORMATION);
    }
    public static void alertError(String msg){
        alert(msg,Alert.AlertType.ERROR);
    }
    public static void alertConfig(String msg, Consumer<String > consumer){
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(msg);
        Optional<ButtonType> buttonType =alert.showAndWait();
        if (buttonType.get()==ButtonType.OK){
            consumer.accept("");
        }
    }
}
