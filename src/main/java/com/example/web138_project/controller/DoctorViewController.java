package com.example.web138_project.controller;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.entity.Dept;
import com.example.web138_project.entity.Education;
import com.example.web138_project.entity.Job;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.service.impl.DoctorServiceImpl;
import com.example.web138_project.util.DoctorVoInfoUtil;
import com.example.web138_project.vo.DoctorVo;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

public class DoctorViewController implements Initializable {
    public Label titleRef;
    public Button butInfo;
    public Label loginLab;
    public TextField liginTxt;
    public ComboBox<String > iconCom;
    public ComboBox <Dept>deptCom;
    public ComboBox <Education>eduCom;
    public ComboBox <Job>jobCom;
    public TextField idRef;
    public TextField realnameRef;
    public RadioButton boyRef;
    public RadioButton girlRef;
    public DatePicker birthdayRef;
    public ImageView iconImg;
    public ImageView bgImg;
    DoctorService doctorService= BeanFactory.getBean(DoctorService.class);
    private ToggleGroup group = new ToggleGroup();
    int departId =0;
    int educationId=0;
    int jobId=0;
    String imgUrl="";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image images = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(images);
        boyRef.setToggleGroup(group );
        girlRef.setToggleGroup(group);
        List <Dept> deptAll=null;
        try {
            iconCom.getItems().addAll("/images/boy.jpg","/images/girl.jpg","/images/ledi.jpg","/images/man.jpg");
            iconCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
                String s=Optional.ofNullable(newVal).orElse("");
            });
            deptAll =doctorService.findDeptAll();
            deptCom.getItems().addAll(deptAll);
            deptCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
                Dept dept = Optional.ofNullable(newVal).orElse(new Dept());
                this.departId=dept.getDepartid();
            });
            List<Education> eduAll= doctorService.findEductionAll();
            eduCom.getItems().addAll(eduAll);
            eduCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
                Education education =Optional.ofNullable(newVal).orElse(new Education());
                this.educationId=education.getEid();
            });
            List<Job> jobAll =doctorService.findJobAll();
            jobCom.getItems().addAll(jobAll);
            jobCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
                Job job =Optional.ofNullable(newVal).orElse(new Job());
                this.jobId=job.getJobid();
            });
            jobCom.getItems().addAll(jobAll);
            System.out.println("触发事件");
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        Map<Integer, DoctorVo> map = DoctorVoInfoUtil.get();
        if (map.containsKey(1)){
            titleRef.setText("更新医生信息");
            butInfo.setText("更新");
            loginLab.setVisible( false);
            liginTxt.setVisible(false);
            DoctorVo doctorVo = map.get(1);
            idRef.setText(doctorVo.getDid()+"");
            realnameRef.setText(doctorVo.getName());
            if (doctorVo.getGender().equals("男")){
                boyRef.setSelected(true);
            }else {
                girlRef.setSelected(true);
            }
            birthdayRef.setValue(LocalDate.parse(doctorVo.getBirthday()));
            deptCom.setValue(new Dept(0,doctorVo.getDepartname(),""));
            eduCom.setValue(new Education(0,doctorVo.getEname(),""));
            jobCom.setValue(new Job(0,doctorVo.getJobname(),""));
            iconCom.setValue(doctorVo.getIconimg());
//            imgUrl=doctorVo.getIconimg();
//            iconImg.setImage(new Image(getClass().getResourceAsStream(doctorVo.getIconimg())));
            Image image = new Image(getClass().getResourceAsStream(doctorVo.getIconimg()));
            iconImg.setImage(image);
        }else {
            titleRef.setText("查看医生信息");
            butInfo.setText("返回");
            loginLab.setVisible(true);
            liginTxt.setVisible(true);
            DoctorVo doctorVo = map.get(2);
            idRef.setText(doctorVo.getDid()+"");
            realnameRef.setText(doctorVo.getName());
            if (doctorVo.getGender().equals("男")){
                boyRef.setSelected(true);
            }else {
                girlRef.setSelected(true);
            }
            birthdayRef.setValue(LocalDate.parse(doctorVo.getBirthday()));
            deptCom.setValue(new Dept(0,doctorVo.getDepartname(),""));
            eduCom.setValue(new Education(0,doctorVo.getEname(),""));
            jobCom.setValue(new Job(0,doctorVo.getJobname(),""));
            iconCom.setValue(doctorVo.getIconimg());
//            imgUrl=doctorVo.getIconimg();
//            iconImg.setImage(new Image(getClass().getResourceAsStream(doctorVo.getIconimg())));
            Image image = new Image(getClass().getResourceAsStream(doctorVo.getIconimg()));
            iconImg.setImage(image);
            idRef.setEditable(false);
            idRef.setText(doctorVo.getDid()+"");
            liginTxt.setText(doctorVo.getLoginname());
        }
    }
}
