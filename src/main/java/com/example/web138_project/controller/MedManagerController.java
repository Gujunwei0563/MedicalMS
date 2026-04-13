package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.ChangeTitle;
import com.example.web138_project.comm.ui.MyUIManager;
import com.example.web138_project.comm.ui.UIConstant;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.PageUtil;
import com.example.web138_project.entity.MedicineSup;
import com.example.web138_project.entity.MedicineType;
import com.example.web138_project.service.MedicineService;
import com.example.web138_project.util.MedicineVoInfoUtil;
import com.example.web138_project.vo.MedAddVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;

import static com.example.web138_project.controller.MainController.nodeList;

public class MedManagerController extends BaseController implements Initializable {
    public TableView medTab;
    public TableColumn drugidCol;
    public TableColumn drugnameCol;
    public TableColumn purchasepriceCol;
    public TableColumn stockCol;
    public TableColumn drugunitCol;
    public TableColumn productdateCol;
    public TableColumn usedateCol;
    public TableColumn cnameCol;
    public TableColumn supnameCol;
    public Label pageLabel;
    public ComboBox queryWayCom;
    public ComboBox chooseCom;
    public ImageView bgImg;
    public TextField queryText;
    ObservableList<MedAddVo> medaddVoObj= FXCollections.observableArrayList();
    MedicineService medService= BeanFactory.getBean(MedicineService.class);
    Map medMap =new HashMap();
    PageUtil pageUtil = new PageUtil();
    int totalCount ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
//        loadData();
        List<String> list = new ArrayList<>();
        list.add("药品类别");
        list.add("供应商");
       queryWayCom.setItems(FXCollections.observableArrayList(list));
        chooseCom.setVisible(false);
        showData();
    }
    public void showPageInfo(){
        pageLabel.setText("共"+totalCount+"条记录，当前第"+pageUtil.getCurrentPage()+"页，共"+pageUtil.getPageNum()+"页");
    }
    public void showData(){
       totalCount = 0;
        medaddVoObj.clear();
        this.colToPro(MedManagerController.class);
        //总记录数
        try {
            totalCount = medService.countInfo(medMap);
            pageUtil.setTotalCount(totalCount);
            pageUtil.setPageNum();
            pageUtil.setCurrentPage(pageUtil.getCurrentPage());
            medMap.put("page",String.valueOf(pageUtil.getCurrentPage()));
            medMap.put("size",String.valueOf(pageUtil.getPageSize()));
            if (totalCount>0){
                List<MedAddVo>list = medService.findPage(medMap);
                for (MedAddVo d:list){
                    medaddVoObj.add(d);
                }
                medTab.setItems(medaddVoObj);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    public void firstPage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(1);
        showData();
        showPageInfo();
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

    public void lastPage(ActionEvent actionEvent) {
        pageUtil.setCurrentPage(pageUtil.getPageNum());
        showData();
        showPageInfo();
    }

    public void queryWayHandel(ActionEvent actionEvent) {
        String queryWay = (String)queryWayCom.getSelectionModel().getSelectedItem();
        chooseCom.setVisible(true);
        if (queryWay.equals("供应商")){
            chooseCom.getItems().clear();
            List<MedicineSup> list =null;
            try {
                list = medService.findMedicineSupAll();
            } catch (ServiceException e) {
                AlterUtil.alertError(e.getMessage());
                throw new RuntimeException(e);
            }
            for (MedicineSup d:list){
                chooseCom.getItems().add(d.getSupname());
            }
        }else if (queryWay.equals("药品类别")){
            chooseCom.getItems().clear();
            List<MedicineType> list =null;
            try {
                list = medService.findMedicineTypeAll();
            } catch (ServiceException e) {
                AlterUtil.alertError(e.getMessage());
                throw new RuntimeException(e);
            }
            for (MedicineType d:list){
                chooseCom.getItems().add(d.getCname());
            }
        }
        showData();
        showPageInfo();
    }
    public void queryHandel(ActionEvent actionEvent) {

        if (chooseCom.getSelectionModel().getSelectedItem()==null){
            AlterUtil.alertError("请选择查询方式");
            return;
        }
        String querytext = queryText.getText();
        if (querytext==null || querytext.equals("")){
            AlterUtil.alertError("请输入查询内容");
            return;
        }
        medMap.clear();
        pageUtil.setCurrentPage(1);
        medMap.put("drugname",querytext);
        String queryWay = (String)queryWayCom.getSelectionModel().getSelectedItem();
        String query = (String)chooseCom.getSelectionModel().getSelectedItem();
        if (queryWay.equals("药品类别")){
            medMap.put("cname",query);
        }else if (queryWay.equals("供应商")){
            medMap.put("supname",query);
        }
        showData();
        showPageInfo();
    }

    public void delHandel(ActionEvent actionEvent) {
        int SelectedIndex = medTab.getSelectionModel().getSelectedIndex();
        if (SelectedIndex==-1){
            AlterUtil.alertError("请选中需要删除的信息");
            return;
        }
        List<MedAddVo> list = medaddVoObj;
        AlterUtil.alertConfig("确定删除这条记录吗",(x)->{
            MedAddVo medAddVo = medaddVoObj.get(SelectedIndex);
            int mid = medAddVo.getDrugid();
            try {
                boolean delMedicine = medService.delMedAddVo(mid);
                if (delMedicine){
                    AlterUtil.alertInfo("删除药品信息成功");
                    showData();
                }else{
                    AlterUtil.alertError("删除药品信息失败");
                }
            } catch (ServiceException e) {
               AlterUtil.alertError(e.getMessage());
            }
        });
    }

    public void updateHandel(ActionEvent actionEvent){
        int SelectedIndex = medTab.getSelectionModel().getSelectedIndex();
        if (SelectedIndex == -1) {
            AlterUtil.alertError("请选中需要更新的信息");
            return;
        }
        MedAddVo medAddVo = medaddVoObj.get(SelectedIndex);
        ChangeTitle.setEditMode(true);
        // 存储选中数据到ThreadLocal（使用操作类型1表示更新）
        Map<Integer, MedAddVo> dataMap = new HashMap<>();
        dataMap.put(1, medAddVo); // 假设MedAddVo继承自DoctorVo
        MedicineVoInfoUtil.set(dataMap);
        MyUIManager.show(nodeList, UIConstant.Med_ADD);
//        ChangeTitle.setEditMode(true);
//        int SelectedIndex = medTab.getSelectionModel().getSelectedIndex();
//        if (SelectedIndex==-1){
//            AlterUtil.alertError("请选中需要更新的信息");
//            return;
//        }
//        MedAddVo medAddVo = medaddVoObj.get(SelectedIndex);
//        MyUIManager.show(nodeList, UIConstant.Med_ADD);

    }



    public void intoAddDrug(ActionEvent actionEvent) {
        ChangeTitle.setEditMode(false);
        MyUIManager.show(nodeList, UIConstant.Med_ADD);
    }
//    public void loadData() {
//        colToProperty();
//        medaddVoObj.clear();
//        List<MedAddVo> list =null;
//        try {
//            list = medService.findMedicineVoAll();
//           for (int i=0;i<list.size();i++){
//               MedAddVo medAddVo = list.get(i);
//               medaddVoObj.add(medAddVo);
//           }
//           medTab.setItems(medaddVoObj);
//        } catch (ServiceException e) {
//           AlterUtil.alertError(e.getMessage());
//           throw new RuntimeException(e);
//        }
//    }
}
