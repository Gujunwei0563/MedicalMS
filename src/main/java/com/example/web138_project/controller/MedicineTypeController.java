package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.DateUtil;
import com.example.web138_project.comm.util.StringUtil;
import com.example.web138_project.entity.Dept;
import com.example.web138_project.entity.MedicineSup;
import com.example.web138_project.entity.MedicineType;
import com.example.web138_project.service.MedicineService;
import com.example.web138_project.service.impl.MedicineServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MedicineTypeController extends BaseController implements Initializable {
    public TableView medicineTypeTab;
    public TableColumn cidCol;
    public TableColumn cnameCol;
    public TableColumn cdescpCol;
    public TableColumn lastdateCol;
    public TableView MedicineSupTab;
    public TableColumn suidCol;
    public TableColumn supnameCol;
    public TableColumn telCol;
    public TableColumn emailCol;
    public TableColumn addressCol;
    public TableColumn supdescCol;
    public TextField suidRef;
    public TextField suemailRef;
    public TextField sunameRef;
    public TextField suaddressRef;
    public TextField sutelRef;
    public TextArea sudescpRef;
    public TextField cidRef;
    public TextArea cdescRef;
    public TextField cnameRef;
    public DatePicker lastdateRef;
    public ImageView bgImg;
    ObservableList<MedicineType> medTypeObj= FXCollections.observableArrayList();
    ObservableList<MedicineSup> medSupObj= FXCollections.observableArrayList();
    MedicineService medicineService= BeanFactory.getBean(MedicineService.class);
    public void colToProperty() {
        this.colToPro(MedicineTypeController.class);
    }
    public void medTypeLoadData(){ //loadData方法：将集合中的数据对应加载到tableView表格中
        colToProperty();
        medTypeObj.clear();
        List<MedicineType> list = null;
        try {
            list = medicineService.findMedicineTypeAll();
            for (int i =0;i<list.size();i++){
                MedicineType medicine=list.get(i);
                medTypeObj.add(medicine);

            }
            medicineTypeTab.setItems(medTypeObj);//将bankService集合对象中的信息全部添加到teaTab中。
        } catch (ServiceException e) {
            AlterUtil.alertError(e.getMessage());
            throw new RuntimeException(e);
        }

    }
    public void medSupLoadData(){ //loadData方法：将集合中的数据对应加载到tableView表格中
        colToProperty();
        medSupObj.clear();
        List<MedicineSup> list = null;
        try {
            list = medicineService.findMedicineSupAll();
            for (int i =0;i<list.size();i++){
                MedicineSup medicineSup=list.get(i);
                medSupObj.add(medicineSup);

            }
            MedicineSupTab.setItems(medSupObj);//将bankService集合对象中的信息全部添加到teaTab中。
        } catch (ServiceException e) {
            AlterUtil.alertError(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        medTypeLoadData();
        medSupLoadData();
    }

    public void medaddSupHandel(ActionEvent actionEvent) {
        String suname=sunameRef.getText();
        String suemail=suemailRef.getText();
        String suaddress=suaddressRef.getText();
        String sutel=sutelRef.getText();
        String sudescp=sudescpRef.getText();
        if (suname.isEmpty()||suemail.isEmpty()||suaddress.isEmpty()||sutel.isEmpty()||sudescp.isEmpty()){
            AlterUtil.alertError("请填全数据");
            return;
        }
        if (!StringUtil.isChi(suname)){
            AlterUtil.alertError("请输入正确的供应商名称");
            return;
        }
        if (!StringUtil.isEmail(suemail)){
            AlterUtil.alertError("请输入正确的供应商邮箱");
            return;
        }
        if (!StringUtil.isPhone(sutel)){
            AlterUtil.alertError("请输入正确的供应商电话");
            return;
        }
        if (!StringUtil.isChi(suaddress)){
            AlterUtil.alertError("请输入正确的供应商地址");
            return;
        }
        if (!StringUtil.isChi(sudescp)){
            AlterUtil.alertError("请输入正确的供应商描述");
            return;
        }
        MedicineSup medicineSup=new MedicineSup();
        medicineSup.setSupname(suname);
        medicineSup.setEmail(suemail);
        medicineSup.setAddress(suaddress);
        medicineSup.setTel(sutel);
        medicineSup.setSupdesc(sudescp);
        try {
            boolean addSup = medicineService.addSup(medicineSup);
            if (addSup){
                AlterUtil.alertInfo("添加供应商成功");
                medSupLoadData();
                sunameRef.setText("");
                suemailRef.setText("");
                suaddressRef.setText("");
                sutelRef.setText("");
                sudescpRef.setText("");
            }else {
                AlterUtil.alertError("添加供应商失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void medicineTypeAddHandel(ActionEvent actionEvent) {
        String cuname=cnameRef.getText();
        String cdesc=cdescRef.getText();
//        String date= DateUtil.showDate();
        String cdate="";
        if (cuname.isEmpty()||cdesc.isEmpty() ||lastdateRef.getValue()==null){
            AlterUtil.alertError("请填全数据");
            return;
        }
        if (lastdateRef.getValue()!=null){
            cdate=lastdateRef.getValue().toString();
        }
//        if (!StringUtil.isChi(cuname)){
//            AlterUtil.alertError("请输入正确的药品类型名称");
//            return;
//        }
//        if (!StringUtil.isChi(cdesc)){
//            AlterUtil.alertError("请输入正确的药品类型描述");
//            return;
//        }
        MedicineType  medicineType=new  MedicineType();
        medicineType.setCname(cuname);
        medicineType.setCdescp(cdesc);
        medicineType.setLastdate(cdate);
        try {
            boolean addType = medicineService.addType(medicineType);
            if (addType){
                AlterUtil.alertInfo("添加药品类型成功");
                medTypeLoadData();
                cnameRef.setText("");
                cdescRef.setText("");
                lastdateRef.setValue(null);
            }else {
                AlterUtil.alertError("添加药品类型失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }


    }
}
