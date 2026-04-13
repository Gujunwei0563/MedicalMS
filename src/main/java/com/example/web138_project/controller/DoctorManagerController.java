package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.ui.MyUIManager;
import com.example.web138_project.comm.ui.UIConstant;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.PageUtil;
import com.example.web138_project.entity.Dept;
import com.example.web138_project.entity.Education;
import com.example.web138_project.entity.Job;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.service.impl.DoctorServiceImpl;
import com.example.web138_project.util.DoctorVoInfoUtil;
import com.example.web138_project.vo.DoctorVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

public class DoctorManagerController extends BaseController implements Initializable {
    public ComboBox<Dept> deptCom;
    public ComboBox<Education> eduCom;
    public ComboBox<Job> jobCom;
    public RadioButton boyRef;
    public RadioButton girlRef;
    public TableView docTab;
    public TableColumn didCol;
    public TableColumn loginnameCol;
    public TableColumn nameCol;
    public TableColumn genderCol;
    public TableColumn birthdayCol;
    public TableColumn jobnameCol;
    public TableColumn departnameCol;
    public TableColumn enameCol;
    public Label pageinfoLab;
    public TextField nameRef;
    public ImageView bgImg;
    int departId =0;
    int educationId=0;
    int jobId=0;
    String imgUrl="";
    private ToggleGroup group = new ToggleGroup();
    DoctorService doctorService= BeanFactory.getBean(DoctorService.class);
    PageUtil pageUtil =new PageUtil();
    ObservableList<DoctorVo> doctorVoObj= FXCollections.observableArrayList();
    Map conMap =new HashMap();
    int totalCount;
    public void showData(){
        doctorVoObj.clear();
        this.colToPro(DoctorManagerController.class);
        //总记录数
        try {
            totalCount = doctorService.countInfo(conMap);
            pageUtil.setTotalCount(totalCount);
            pageUtil.setPageNum();
            pageUtil.setCurrentPage(pageUtil.getCurrentPage());
            conMap.put("page",String.valueOf(pageUtil.getCurrentPage()));
            conMap.put("size",String.valueOf(pageUtil.getPageSize()));
            if (totalCount>0){
                List<DoctorVo>list = doctorService.findPage(conMap);
                for (DoctorVo d:list){
                    doctorVoObj.add(d);
                }
                docTab.setItems(doctorVoObj);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void showPageInfo(){
        pageinfoLab.setText("共"+totalCount+"条记录，当前第"+pageUtil.getCurrentPage()+"页，共"+pageUtil.getPageNum()+"页");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        boyRef.setToggleGroup(group );
        girlRef.setToggleGroup(group);
        boyRef.setSelected(true);
        showPageInfo();
        try {
//           iconCom.getItems().addAll("/images/boy.jpg","/images/girl.jpg","/images/ledi.jpg","/images/man.jpg");
            List<Dept> deptAll =doctorService.findDeptAll();
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
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        pageUtil.setCurrentPage(1);
        showData();
    }
    public void addDocHandel(ActionEvent actionEvent) {
        MyUIManager.show(MainController.nodeList, UIConstant.DOC_ADD);
    }
    public void prePage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(pageUtil.getCurrentPage()-1);
        showData();
        showPageInfo();
    }
    public void nextPage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(pageUtil.getCurrentPage()+1);
        showData();
        showPageInfo();
    }
    public void firstPage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(1);
        showData();
        showPageInfo();
    }
    public void lastPage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(pageUtil.getPageNum());
        showData();
        showPageInfo();
    }

    public void queryCond(ActionEvent actionEvent) {
        conMap.clear();
        String name= nameRef.getText();
       if (!name.isEmpty()){
           conMap.put("ename",name);
       }
       if (boyRef.isSelected()){
           conMap.put("gender","男");
       }else if (girlRef.isSelected()){
           conMap.put("gender","女");
       }
       if (this.departId!=0){
           conMap.put("deid",this.departId);
       }
       if (this.educationId!=0){
           conMap.put("edid",this.educationId);
       }
       if (this.jobId!=0){
           conMap.put("joid",this.jobId);
       }
       showData();
       showPageInfo();
    }

    public void refresh(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(1);
        pageUtil.setPageSize(2);
        conMap.clear();
        showData();
        showPageInfo();
        this.educationId=0;
        this.jobId=0;
        this.departId=0;
        this.nameRef.setText("");
        this.boyRef.setSelected(false);
        this.girlRef.setSelected(false);
        jobCom.getSelectionModel().clearSelection();
        deptCom.getSelectionModel().clearSelection();
        eduCom.getSelectionModel().clearSelection();
    }
    public void delDocHandel(ActionEvent actionEvent) {
        int SelectedIndex = docTab.getSelectionModel().getSelectedIndex();
        if (SelectedIndex==-1){
            AlterUtil.alertError("请选中需要删除的信息");
        }
        AlterUtil.alertConfig("确定删除这条记录吗",(x)->{
            DoctorVo doctorVo = doctorVoObj.get(SelectedIndex);
            int did = doctorVo.getDid();
            try {
                boolean delDoctor = doctorService.delDoctor(did);
                if (delDoctor){
                    AlterUtil.alertInfo("删除医生信息成功");
                    showData();
                }else{
                    AlterUtil.alertError("删除医生信息失败");
                }
            } catch (ServiceException e) {
               AlterUtil.alertError(e.getMessage());
            }
        });
    }
    //查看
    public void viewDochandel(ActionEvent actionEvent) {
        int SelectedIndex = docTab.getSelectionModel().getSelectedIndex();
        if (SelectedIndex==-1){
            AlterUtil.alertError("请选中需要查看的信息");
            return;
        }
        extracted(SelectedIndex,2);
    }
    private void extracted(int selectedIndex,int idx){
        DoctorVo doctorVo = doctorVoObj.get(selectedIndex);
        Map<Integer, DoctorVo> map = new HashMap<>();
        map.put(idx,doctorVo);
        DoctorVoInfoUtil.set(map);
        MyUIManager.show(MainController.nodeList, UIConstant.DOC_VIEW);
    }
    public void updDocHandel(ActionEvent actionEvent) {
        int SelectedIndex = docTab.getSelectionModel().getSelectedIndex();
        if (SelectedIndex==-1){
            AlterUtil.alertError("请选中需要修改的信息");
            return;
        }
        extracted(SelectedIndex,1);
    }
}
