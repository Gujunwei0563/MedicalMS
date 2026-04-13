package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.ui.MyUIManager;
import com.example.web138_project.comm.ui.UIConstant;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.dao.RegistrationDAO;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.entity.See_Doctor;
import com.example.web138_project.service.AdminService;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.service.PatientService;
import com.example.web138_project.service.impl.AdminServiceImpl;
import com.example.web138_project.service.impl.DoctorServiceImpl;
import com.example.web138_project.service.impl.PatientServiceImpl;
import com.example.web138_project.util.LoginInfoUtil;
import com.example.web138_project.util.OrderIdUtil;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;
import com.example.web138_project.vo.PatientVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.ref.PhantomReference;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static com.example.web138_project.controller.MainController.nodeList;

public class SeeDocController extends BaseController implements Initializable {
    public TextField patientName;
    public Label patientAgeLab;
    public Label patientIdLab;
    public Label regIdLab;
    public Label deptidLab;
    public TextArea seeRef;
    public ComboBox<PatientVo> patNameCom;
    public ImageView bgImg;
    PatientService patientService = BeanFactory.getBean(PatientService.class);
    DoctorService doctorService = BeanFactory.getBean(DoctorService.class);
    ObservableList<PatientVo > patientObj= FXCollections.observableArrayList();
    AdminService adminService = BeanFactory.getBean(AdminService.class);
    RegistrationDAO registrationDAO = BeanFactory.getBean(RegistrationDAO.class);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
            loadComDate();
    }
//    public void showPatLabel() {
//
//            PatientVo patientVo = (PatientVo) newVal;
//            patientAgeLab.setText(patientVo.getBirthday());
//            patientIdLab.setText(patientVo.getIdcard());
//            regIdLab.setText(String.valueOf(patientVo.getReid()));
//            deptidLab.setText(patientVo.getDepartname());
//
//    }
    public void loadComDate(){
        Map<Integer, Object> login = LoginInfoUtil.getLogin();
        if (login.containsKey(2)) {
            DoctorVo doctorVo = (DoctorVo) login.get(2);
            int doctorId = doctorVo.getDid();
            try {
                List<PatientVo> patientVos = patientService.findPatientByDocId(doctorId);
                // 清空现有数据
                patientObj.clear();
                // 添加所有患者姓名到列表
                for (PatientVo patientVo : patientVos) {
                    patientObj.add(patientVo);
                }
                // 只设置一次 ComboBox 的项目列表
                patNameCom.setItems(patientObj);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        } else if (login.containsKey(1)) {
            AlterUtil.alertInfo("无权限查看");
        }
    }
    public void seeEnd(ActionEvent actionEvent) {
    PatientVo patientVo =  patNameCom.getSelectionModel().getSelectedItem();
    String text = seeRef.getText();
    if (text.isEmpty()){
        AlterUtil.alertInfo("请输入就诊情况");
        return;
    }
    See_Doctor see_doctor =new See_Doctor();
    see_doctor.setPatieid(patientVo.getPatientid());
    see_doctor.setRegid(patientVo.getReid());
    see_doctor.setDeptid(patientVo.getDeptid());
    see_doctor.setDescp( seeRef.getText());
    see_doctor.setCreatetieme(patientVo.getCreatetime());
    see_doctor.setDocid(patientVo.getDoctorid());
        try {
            int i = patientService.addPatient(see_doctor);
            AlterUtil.alertConfig("是否开药？",(x)->{
                OrderIdUtil.setOrderId(see_doctor.getOrderid());
                OrderIdUtil.setOrderId(i);
                try {
                    registrationDAO.updateStatus(patientVo.getReid(),1);
                    MyUIManager.show(nodeList, UIConstant.PRESCRIBE);
                } catch (DAOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }



    }
    public void clearInfo(ActionEvent actionEvent) {
        seeRef.clear();
        patNameCom.getSelectionModel().clearSelection();
        patientAgeLab.setText("");
        patientIdLab.setText("");
        regIdLab.setText("");
        deptidLab.setText("");
        patientName.clear();
    }
    public void showPatLabel(ActionEvent actionEvent) {
        PatientVo selectedPatientName = patNameCom.getSelectionModel().getSelectedItem();
        if (selectedPatientName != null) {
            try {
               PatientVo patientVo = patientService.findPatientByName(selectedPatientName.getPname());
                if (patientVo != null) {
                    // 显示患者信息
                    patientAgeLab.setText(patientVo.getAge()+"");
                    patientIdLab.setText(patientVo.getIdcard());
                    regIdLab.setText(String.valueOf(patientVo.getReid()));
                    deptidLab.setText(patientVo.getDepartname());
                } else {
                    AlterUtil.alertInfo("患者不存在");
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

    }
}
