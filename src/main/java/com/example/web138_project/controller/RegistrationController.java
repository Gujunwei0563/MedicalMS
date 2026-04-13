package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.entity.*;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.service.PatientService;
import com.example.web138_project.service.impl.DoctorServiceImpl;
import com.example.web138_project.service.impl.PatientServiceImpl;
import com.example.web138_project.vo.DoctorVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class RegistrationController extends BaseController implements Initializable {
    public RadioButton boyRad;
    public RadioButton girlRad;
    public int departId =0;
    public String doctorName ="";

    public ComboBox<DoctorVo> docCom;
    public ComboBox <Dept> deptCom;
    public TextField idCardRef;
    public TextField pnameRef;
    public TextField phoneRef;
    public DatePicker birthdayPick;
    public ImageView bgImg;
    private ToggleGroup group =new ToggleGroup()   ;
    PatientService patientService = BeanFactory.getBean(PatientService.class);
    DoctorService doctorService = BeanFactory.getBean(DoctorService.class);
    private Registration registration = new Registration();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        boyRad.setToggleGroup(group);
        girlRad.setToggleGroup(group);
        boyRad.setSelected(true);
        loadComDate();
    }


    public void registerHandel(ActionEvent actionEvent) {
        try {
            Patient patient = patientService.selectByIdcard(idCardRef.getText());
            if (patient!=null){
                AlterUtil.alertInfo("该患者已注册");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        String idCard = idCardRef.getText();
        if (idCard.isEmpty()){
            AlterUtil.alertInfo("请输入医保卡号");
            return;
        }
        String pname = pnameRef.getText();
        if (pname.isEmpty()){
            AlterUtil.alertInfo("请输入患者姓名");
            return;
        }
        String phone = phoneRef.getText();
        if (phone.isEmpty()){
            AlterUtil.alertInfo("请输入患者手机号");
            return;
        }
        String birthday = birthdayPick.getValue().toString();
        if (birthday.isEmpty()){
            AlterUtil.alertInfo("请输入患者生日");
            return;
        }
        String gender = "";
        if (boyRad.isSelected()){
            gender="男";
        }else {
            gender="女";
        }
        Patient patient = new Patient();
        patient.setPatientid(0);
        patient.setPname(pname);
        patient.setPhone(phone);
        patient.setBirthday(birthday);
        patient.setGender(gender);
        patient.setIdcard(idCard);
        patient.setIsdel(0);
        patient.setCreatetime(LocalDate.now().toString());
        registration.setDoctorid(docCom.getValue().getDid());
        registration.setDeptid(deptCom.getValue().getDepartid());
        try {
            boolean b = patientService.addRegistration(patient,registration);
            if (b){
                AlterUtil.alertInfo("注册成功");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }
    public void  loadComDate(){

        try {
            List<Dept> deptAll =doctorService.findDeptAll();
            deptCom.getItems().addAll(deptAll);
            deptCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
                Dept dept = Optional.ofNullable(newVal).orElse(new Dept());
               this.departId=dept.getDepartid();

                docCom.getItems().clear();
                if (departId>0){
                   List<DoctorVo> doctors = null;
                    try {
                        doctors = doctorService.showDocNameByDepartId(this.departId);
                        docCom.getItems().addAll(doctors);
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
//            List<Doctor> doctorAll =doctorService.showDocNameByDepartId(departId);
//            ObservableList<Doctor> doctorObservableList = FXCollections.observableArrayList(doctorAll);
//            docCom.getItems().addAll(doctorObservableList);
//            docCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
//                Doctor doctor = Optional.ofNullable(newVal).orElse(new Doctor());
//                this.doctorName=doctor.getName();
//            });
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void isPatientHandel(ActionEvent actionEvent) {
        String idCard = idCardRef.getText();
        if (idCard.isEmpty()){
            AlterUtil.alertInfo("请输入医保卡号");
            return;
        }
        try {
            Patient patient = patientService.selectByIdcard(idCard);
            if (patient!=null){
                pnameRef.setText(patient.getPname());
                phoneRef.setText(patient.getPhone());
                birthdayPick.setValue(LocalDate.parse(patient.getBirthday()));
                if (patient.getGender().equals("男")){
                    boyRad.setSelected(true);
                }else {
                    girlRad.setSelected(true);
                }
            }else {
                AlterUtil.alertInfo("医保卡不存在");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void refreshHandel(ActionEvent actionEvent) {
        idCardRef.setText("");
        pnameRef.setText("");
        phoneRef.setText("");
        birthdayPick.setValue(null);
        boyRad.setSelected(true);
    }
}
