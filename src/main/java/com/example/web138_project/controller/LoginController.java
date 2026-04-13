package com.example.web138_project.controller;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.ViewUtil;
import com.example.web138_project.entity.Admin;
import com.example.web138_project.entity.Login;
import com.example.web138_project.service.AdminService;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.service.impl.AdminServiceImpl;
import com.example.web138_project.service.impl.DoctorServiceImpl;
import com.example.web138_project.util.LoginInfoUtil;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField unameRef;
    public RadioButton adminRad;
    public RadioButton docRad;
    public TextField passRef;
    public ImageView bgImg;
    private ToggleGroup group = new ToggleGroup();
    AdminService adminService = BeanFactory.getBean(AdminService.class);

    public void login(ActionEvent actionEvent) {
        //登录
        String name = unameRef.getText();
        String pass = passRef.getText();
        if (adminRad.isSelected()){


            try {
                AdminVo adminVo = adminService.loginAdminInfo(name,pass);
                if (adminVo != null){
                    Map map = new HashMap();
                    map.put(1,adminVo);
                    LoginInfoUtil.setLogin(map);
                        ViewUtil.start("/com/example/web138_project/main.fxml","管理员主页");
                        ViewUtil.close(unameRef);

                }else {
                    AlterUtil.alertError("用户名或密码或角色错误");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }else {
            DoctorService doctorService = new DoctorServiceImpl();
            try {
                DoctorVo doctorVo = doctorService.loginDocInfo(name,pass);
                if (doctorVo != null){
                    Map map = new HashMap();
                    map.put(2,doctorVo);
                    LoginInfoUtil.setLogin(map);
                        ViewUtil.start("/com/example/web138_project/main.fxml","医生主页");
                        ViewUtil.close(unameRef);

                }else {
                    AlterUtil.alertError("用户名或密码错误或角色错误");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg2.jpg"));
        bgImg.setImage(image);
        adminRad.setSelected(true);
        adminRad.setToggleGroup(group);
        docRad.setToggleGroup(group);

    }
}
