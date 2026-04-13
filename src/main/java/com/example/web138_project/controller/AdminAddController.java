package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.entity.Admin;
import com.example.web138_project.entity.Login;
import com.example.web138_project.service.AdminService;
import com.example.web138_project.service.impl.AdminServiceImpl;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminAddController extends BaseController implements Initializable {
    public TableView adminTab;
    public TableColumn aidCol;
    public TableColumn loginNameCol;
    public TableColumn genderCol;
    public TableColumn anameCol;
    public TableColumn telCol;
    public TableColumn emailCol;
    public TableColumn webchatCol;
    public TableColumn qqCol;
    public TextField loginnameRef;
    public RadioButton maleRef;
    public RadioButton femaleRef;
    public TextField telRef;
    public TextField emailRef;
    public TextField webchatRef;
    public TextField qqRef;
    public ComboBox<String> iconCom;
    public ImageView iconImg;
    public TextField anameRef;
    public ImageView bgImg;

    private String imgUrl="";

    ObservableList<AdminVo> adminVoObj = FXCollections.observableArrayList();
    AdminService adminService = BeanFactory.getBean(AdminService.class);
    private  ToggleGroup group = new ToggleGroup();

    public void showData() {
        adminVoObj.clear();
        this.colToPro(AdminAddController.class);
        List<AdminVo> info = null;
        try {
            info = adminService.findInfo();
            for (AdminVo a : info) {
                adminVoObj.add(a);
            }
            adminTab.setItems(adminVoObj);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        maleRef.setToggleGroup(group);
        femaleRef.setToggleGroup(group);
        maleRef.setSelected(true);
        showData();
        iconCom.getItems().addAll("/images/ledi.jpg","/images/man.jpg","/images/girl.jpg","/images/red.jpg");
        iconCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
            String s = Optional.ofNullable(newVal).orElse("");
//                System.out.println(dept.getDepartid());
        });
    }

    public void chooseIcon(ActionEvent actionEvent) {
        //获取下拉项
        String selectedItem = iconCom.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
            //创建图片对象
            Image img = new Image(getClass().getResourceAsStream(selectedItem));
            //将图片对象设置在容器中
            iconImg.setImage(img);
            this.imgUrl = selectedItem;
        }else{
            this.imgUrl="";
        }
    }

    public void addAdminHandle(ActionEvent actionEvent) {
        String loginname = loginnameRef.getText();
        String aname = anameRef.getText();
        String gender = null;
        if(maleRef.isSelected()){
            gender = "男";
        }else if(femaleRef.isSelected()){
            gender = "女";
        }
        String tel = telRef.getText();
        String email = emailRef.getText();
        String webchat = webchatRef.getText();
        String qq = qqRef.getText();
        if(loginname.isEmpty()||aname.isEmpty()||gender.isEmpty()||tel.isEmpty()||
                email.isEmpty()||webchat.isEmpty()||qq.isEmpty()||imgUrl.isEmpty()){
            AlterUtil.alertError("请填全数据");
            return;
        }
        Login login = new Login();
        login.setLoginname(loginname);
        login.setRoleid(1);
        Admin admin = new Admin();
        admin.setAname(aname);
        admin.setGender(gender);
        admin.setTel(tel);
        admin.setEmail(email);
        admin.setWebchat(webchat);
        admin.setQq(qq);
        admin.setIconimg(imgUrl);
        try {
            boolean add = adminService.add(login, admin);
            if(add){
                AlterUtil.alertInfo("添加成功");
                clearInfo();
                showData();
            }else{
                AlterUtil.alertError("添加失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }
    //清空添加信息
    private void clearInfo() {
        loginnameRef.setText("");
        anameRef.setText("");
        telRef.setText("");
        emailRef.setText("");
        webchatRef.setText("");
        qqRef.setText("");
        iconCom.setValue(null);
        iconImg.setImage(null);
        this.imgUrl = "";
    }


}
