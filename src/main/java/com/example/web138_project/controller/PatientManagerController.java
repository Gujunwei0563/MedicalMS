package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.entity.Registration;
import com.example.web138_project.service.PatientService;
import com.example.web138_project.service.impl.PatientServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PatientManagerController extends BaseController implements Initializable {
    public TableView patientTable;
    public TableColumn genderCol;
    public TableColumn birthdayCol;
    public TableColumn idcardCol;
    public TableColumn phoneCol;
    public Label patientNumLabel;
    public TableColumn patientidCol;
    public TableColumn pnameCol;
    public TableColumn isdelCol;
    public TableColumn createtimeCol;
    public ImageView bgImg;

    ObservableList<Patient> regObj= FXCollections.observableArrayList();
   PatientService patientService = BeanFactory.getBean(PatientService.class);
    public void colToProperty() {
        this.colToPro(PatientManagerController.class);
    }
    public void patientLoadData(){ //loadData方法：将集合中的数据对应加载到tableView表格中
        colToProperty();
        regObj.clear();
        List<Patient> list = null;
        try {
            list = patientService.findPatientAll();
            for (int i =0;i<list.size();i++){
                Patient patient=list.get(i);
                regObj.add(patient);
            }
            patientTable.setItems(regObj);//将bankService集合对象中的信息全部添加到teaTab中。
        } catch (ServiceException e) {
            AlterUtil.alertError(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void deleteHandel(ActionEvent actionEvent) {
        Patient patient =( Patient) patientTable.getSelectionModel().getSelectedItem();
        if (patient==null){
            AlterUtil.alertError("请选中需要删除的信息");
        }else {
            if (patient.getIsdel()==1){
                AlterUtil.alertError("该记录已删除");
                return;
            }
            AlterUtil.alertConfig("确定删除这条记录吗", (x) -> {
                int patId = patient.getPatientid();
                try {
                    boolean delPat = patientService.delPat(patId,1);
                    if (delPat) {
                        patientLoadData();
                        AlterUtil.alertInfo("删除成功");
                    }else {
                        AlterUtil.alertError("删除失败");
                    }
                } catch (ServiceException e) {
                    AlterUtil.alertError(e.getMessage());
                }
            });
        }
    }

    public void recoverHandel(ActionEvent actionEvent) {
        Patient patient =( Patient) patientTable.getSelectionModel().getSelectedItem();
        if (patient==null){
            AlterUtil.alertError("请选中需要恢复的信息");
            return;
        }
        if (patient.getIsdel()==0){
            AlterUtil.alertError("该记录未删除");
            return;
        }
        AlterUtil.alertConfig("确定恢复这条记录吗",(x)->{
            int patId = patient.getPatientid();
            try {
                boolean recoverPat = patientService.delPat(patId,0);
                if (recoverPat){
                    AlterUtil.alertInfo("恢复成功");
                    patientLoadData();
                }else {
                    AlterUtil.alertError("恢复失败");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void recoverAllHandel(ActionEvent actionEvent) {
        //自动获取patientTable的数据，并恢复逻辑删除
        regObj = (ObservableList<Patient>) patientTable.getItems();
        // 创建副本避免并发修改异常
        ObservableList<Patient> copyList = FXCollections.observableArrayList(regObj);
        for (Patient patient : copyList) {
            int patId = patient.getPatientid();
            try {
                patientService.delPat(patId, 0);
                patientLoadData();
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        colToProperty();
        patientLoadData();
    }
}
