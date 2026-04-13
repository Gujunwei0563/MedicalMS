package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.ui.MyUIManager;
import com.example.web138_project.comm.ui.UIConstant;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.DateUtil;
import com.example.web138_project.comm.util.StringUtil;
import com.example.web138_project.entity.*;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.service.impl.DoctorServiceImpl;
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

public class DoctorAddController extends BaseController implements Initializable {
    public TextField deptNameRef;
    public TextArea deptDescRef;
    public TableView deptTab;
    public TableColumn departidCol;
    public TableColumn departnameCol;
    public TableColumn departdescpCol;
    public TextField eduNameRef;
    public TextArea eduDescRef;
    public TableView eduTab;
    public TableColumn eidCol;
    public TableColumn enameCol;
    public TableColumn edescpCol;
    public TextField jobNameRef;
    public TextArea jobDescRef;
    public TableView jobTab;
    public TableColumn jobidCol;
    public TableColumn jobnameCol;
    public TableColumn jobdescpCol;
    public ComboBox <Job>jobCom;
    public ComboBox<Dept> deptCom;
    public ComboBox<Education> eduCom;
    public DatePicker boirthdayRef;
    public RadioButton boyRef;
    public RadioButton girlRef;
    public ComboBox<String> iconCom;
    public ImageView iconImg;
    public TextField loginnameRef;
    public TextField realnameRef;
    public ImageView bgImg;


    ObservableList<Dept> deptObj= FXCollections.observableArrayList();
    DoctorService doctorService= BeanFactory.getBean(DoctorService.class);
    ObservableList<Job> jobObj= FXCollections.observableArrayList();
    ObservableList<Education> eduObj= FXCollections.observableArrayList();
    private ToggleGroup group = new ToggleGroup();
    ObservableList<String> iconObj= FXCollections.observableArrayList();
    int departId =0;
    int educationId=0;
    int jobId=0;
    String imgUrl="";
    public void colToProperty() {
      this.colToPro(DoctorAddController.class);
    }
    public void deptLoadData(){ //loadData方法：将集合中的数据对应加载到tableView表格中
        colToProperty();
        deptObj.clear();
        List<Dept> list = null;
        try {
            list = doctorService.findDeptAll();
            for (int i =0;i<list.size();i++){
                Dept dept=list.get(i);
                deptObj.add(dept);

            }
        } catch (ServiceException e) {
            AlterUtil.alertError(e.getMessage());
            throw new RuntimeException(e);
        }
        deptTab.setItems(deptObj);//将bankService集合对象中的信息全部添加到teaTab中。
    }
    public void jobLoadData(){ //loadData方法：将集合中的数据对应加载到tableView表格中
        colToProperty();
        jobObj.clear();
        List<Job> list = null;
        try {
            list = doctorService.findJobAll();
            for (int i =0;i<list.size();i++){
                Job job=list.get(i);
                jobObj.add(job);

            }
        } catch (ServiceException e) {
            AlterUtil.alertError(e.getMessage());
            throw new RuntimeException(e);
        }
        jobTab.setItems(jobObj);//将bankService集合对象中的信息全部添加到teaTab中。
    }

    public void EduLoadData(){ //loadData方法：将集合中的数据对应加载到tableView表格中
        colToProperty();
        eduObj.clear();
        List<Education> list = null;
        try {
            list = doctorService.findEductionAll();
            for (int i =0;i<list.size();i++){
                Education edu =list.get(i);
                eduObj.add(edu);

            }
        } catch (ServiceException e) {
            AlterUtil.alertError(e.getMessage());
            throw new RuntimeException(e);
        }
        eduTab.setItems(eduObj);//将bankService集合对象中的信息全部添加到teaTab中。
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        colToProperty();
        deptLoadData();
        jobLoadData();
        EduLoadData();
        boyRef.setToggleGroup(group );
        girlRef.setToggleGroup(group);
        boyRef.setSelected(true);
        boirthdayRef.setValue(DateUtil.setDefaultDate(2000,1,1));
       loadComDate();
    }
    public void  loadComDate(){
        try {
            iconCom.getItems().addAll("/images/boy.jpg","/images/girl.jpg","/images/ledi.jpg","/images/man.jpg");
            iconCom.getSelectionModel().selectedItemProperty().addListener((observable,oldVal,newVal)->{
               String s=Optional.ofNullable(newVal).orElse("");
            });
            List <Dept> deptAll =doctorService.findDeptAll();
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
    }
    public void chooseIcon(ActionEvent actionEvent) {
        String selectedItem = iconCom.getSelectionModel().getSelectedItem();
        if (selectedItem!=null){
            Image image = new Image(getClass().getResourceAsStream(selectedItem));
            iconImg.setImage(image);
            this.imgUrl=selectedItem;
        } else {
            this.imgUrl="";
        }
        //获取下拉项
//        String selectedItem = iconCom.getSelectionModel().getSelectedItem();
//        //创建图像对象
//        Image image = new Image(getClass().getResourceAsStream(selectedItem));
//        //将图片对象设置在容器中
//        iconImg.setImage(image);
//        //将图片地址存到成员属性中
//        this.imgUrl=selectedItem;
    }

    public void backlistDocHandel(ActionEvent actionEvent) {
        MyUIManager.show(MainController.nodeList, UIConstant.DOC_MANAGER);
    }


    public void addDeptHandel(ActionEvent actionEvent) {
        String dname=deptNameRef.getText();
        String desc=deptDescRef.getText();
        if (dname.isEmpty()||desc.isEmpty()){
            AlterUtil.alertError("请填全数据");
            return;
        }
        if (!StringUtil.idName(dname)){
            AlterUtil.alertError("请输入正确的部门名称");
            return;
        }
        if (!StringUtil.idName(desc)){
            AlterUtil.alertError("请输入正确的部门介绍");
            return;
        }
        Dept dept =new Dept();
        dept.setDepartname(dname);
        dept.setDepartdescp(desc);
        try {
            boolean addDept = doctorService.addDept(dept);
            if (addDept){
                AlterUtil.alertInfo("添加部门成功");
                deptLoadData();
                deptNameRef.setText("");
                deptDescRef.setText("");
            }else {
                AlterUtil.alertError("添加部门失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void delDeptHandel(ActionEvent actionEvent) {
        int selectedIndex = deptTab.getSelectionModel().getSelectedIndex();
        AlterUtil.alertConfig("确定删除这条记录吗",(x)->{

            if (selectedIndex==1){
                AlterUtil.alertError("请选中需要删除的信息");
                return;
            }
            Dept dept =deptObj.get(selectedIndex);
            try {
                boolean delDept = doctorService.delDept(dept.getDepartid());
                if (delDept){
                    AlterUtil.alertInfo("删除成功");
                    deptLoadData();
                }else{
                    AlterUtil.alertError("删除失败");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addEducationHandel(ActionEvent actionEvent) {
        String ename=eduNameRef.getText();
        String edesc=eduDescRef.getText();
        if (ename.isEmpty()||edesc.isEmpty()){
            AlterUtil.alertError("请填全数据");
            return;
        }
        if (!StringUtil.idName(ename)){
            AlterUtil.alertError("请输入正确的学历名称");
            return;
        }
        if (!StringUtil.idName(edesc)){
            AlterUtil.alertError("请输入正确的学历介绍");
            return;
        }
        Education education =new Education();
        education.setEname(ename);
        education.setEdescp(edesc);
        try {
            boolean addedDept = doctorService.addEducation(education);
            if (addedDept){
                AlterUtil.alertInfo("添加学历成功");
                EduLoadData();
                eduNameRef.setText("");
                eduDescRef.setText("");
            }else {
                AlterUtil.alertError("添加学历失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void delEducationHandel(ActionEvent actionEvent) {
        int selectedIndex = eduTab.getSelectionModel().getSelectedIndex();
        AlterUtil.alertConfig("确定删除这条记录吗",(x)->{

            if (selectedIndex==1){
                AlterUtil.alertError("请选中需要删除的信息");
                return;
            }
            Education education =eduObj.get(selectedIndex);
            try {
                boolean delEdu = doctorService.delEducation(education.getEid());
                if (delEdu){
                    AlterUtil.alertInfo("删除成功");
                    EduLoadData();
                }else{
                    AlterUtil.alertError("删除失败");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addJobHandel(ActionEvent actionEvent) {
        String jobname=jobNameRef.getText();
        String jobdesc=jobDescRef.getText();
        if (jobname.isEmpty()||jobdesc.isEmpty()){
            AlterUtil.alertError("请填全数据");
            return;
        }
        if (!StringUtil.idName(jobname)){
            AlterUtil.alertError("请输入正确的学历名称");
            return;
        }
        if (!StringUtil.idName(jobdesc)){
            AlterUtil.alertError("请输入正确的学历介绍");
            return;
        }
        Job job =new Job();
        job.setJobname(jobname);
        job.setJobdescp(jobdesc);
        try {
            boolean addJob = doctorService.addJob(job);
            if (addJob){
                AlterUtil.alertInfo("添加学历成功");
                jobLoadData();
                jobNameRef.setText("");
                jobDescRef.setText("");
            }else {
                AlterUtil.alertError("添加学历失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void delJobHandel(ActionEvent actionEvent) {
        int selectedIndex = jobTab.getSelectionModel().getSelectedIndex();
        AlterUtil.alertConfig("确定删除这条记录吗",(x)->{
            if (selectedIndex==1){
                AlterUtil.alertError("请选中需要删除的信息");
                return;
            }
            Job job =jobObj.get(selectedIndex);
            try {
                boolean delJob = doctorService.delJob(job.getJobid());
                if (delJob){
                    AlterUtil.alertInfo("删除成功");
                    jobLoadData();
                }else{
                    AlterUtil.alertError("删除失败");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void refresh(ActionEvent actionEvent) {
        deptCom.getItems().clear();
        eduCom.getItems().clear();
        jobCom.getItems().clear();
        loadComDate();
    }

    public void addDocHandel(ActionEvent actionEvent) {
        String logName = loginnameRef.getText();
        String realName = realnameRef.getText();
        if (logName.isEmpty()||realName.isEmpty()){
            AlterUtil.alertError("请填全数据");
            return;
        }if(this.jobId==0||this.educationId==0||this.departId==0||this.imgUrl.equals("")){
            AlterUtil.alertError("请选择下拉项");
            return;
        }if (!StringUtil.idName(logName)){
            AlterUtil.alertError("请输入正确的用户名");
            return;
        }if (!StringUtil.isChi(realName)){
            AlterUtil.alertError("请输入中文名");
            return;
        }
        Login login =new Login();
        login.setLoginname(logName);
        login.setRoleid(2);
        Doctor doctor=new Doctor();
        doctor.setName(realName);
        doctor.setGender(boyRef.isSelected()?"男":"女");
        doctor.setBirthday(this.boirthdayRef.getValue().toString());
        doctor.setJoid(this.jobId);
        doctor.setDeid(this.departId);
        doctor.setEdid(this.educationId);
        doctor.setIconimg(this.imgUrl);
        try {
            doctorService.addDoctor(login,doctor);
            AlterUtil.alertInfo("添加成功");
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
