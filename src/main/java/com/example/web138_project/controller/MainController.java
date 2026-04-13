package com.example.web138_project.controller;

import com.example.web138_project.comm.util.ChangeTitle;
import com.example.web138_project.comm.ui.MyUIManager;
import com.example.web138_project.comm.ui.UIConstant;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.ViewUtil;
import com.example.web138_project.util.LoginInfoUtil;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public AnchorPane mainFrame;
    public static ObservableList<Node> nodeList;
    public Label roleLab;
    public Label nameLab;
    public ImageView iconimg;
    public Menu userMenu;
    public Menu drupMenu;
    public MenuItem dataMenu;
    public ImageView bgImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nodeList=mainFrame.getChildren();
        Map<Integer,Object> map= LoginInfoUtil.getLogin();
        if(map.containsKey(1)){
            AdminVo adminVo= (AdminVo) map.get(1);
           roleLab.setText(adminVo.getRname());
           nameLab.setText(adminVo.getAname());

           Image image=new Image(getClass().getResourceAsStream(adminVo.getIconimg()));
           iconimg.setImage(image);

        }else if(map.containsKey(2)){
            DoctorVo doctorVo= (DoctorVo) map.get(2);
            roleLab.setText(doctorVo.getRname());
            nameLab.setText(doctorVo.getName());

            Image image=new Image(getClass().getResourceAsStream(doctorVo.getIconimg()));
            iconimg.setImage(image);

            userMenu.setVisible(false);
            drupMenu.setVisible(false);
            dataMenu.setVisible(false);
        }
        new Thread(()->{
            MyUIManager.initView();
        }).start();
    }

    public void addDocHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList, UIConstant.DOC_ADD);
    }

    public void listDocHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.DOC_MANAGER);
    }

    public void addPatientHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList, UIConstant.PAT_ADD);
    }
    public void listPatientHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.PAT_MANAGER);
    }
    public void logout(ActionEvent actionEvent) {
        AlterUtil.alertConfig("是否退出系统",(x)->{
            ViewUtil.close(mainFrame);
        });
    }

    public void cancelUser(ActionEvent actionEvent) {
        AlterUtil.alertConfig("是否注销用户",(x)->{
            ViewUtil.start("/com/example/web138_project/login.fxml","万和医疗系统的登录页面");
            ViewUtil.close(mainFrame);
        });
    }


    public void typeMedicineHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.Med_TYPE);
    }

    public void addMedicineHandel(ActionEvent actionEvent) {
        ChangeTitle.setEditMode(false);
        MyUIManager.show(nodeList,UIConstant.Med_ADD);
    }

    public void addAdminHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.ADMIN_ADD);
    }

    public void registrationHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.REGISTRATION);

    }

    public void seeDocHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.SEE_DOC);
    }

    public void medicineManagerHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.Med_MANAGER);
    }

    public void aiHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.AI);
    }

    public void prescribeHandel(ActionEvent actionEvent) {
        MyUIManager.show(nodeList,UIConstant.PRESCRIBE);
    }
}
