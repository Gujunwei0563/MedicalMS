package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.entity.Medicine;
import com.example.web138_project.service.MedicineService;
import com.example.web138_project.service.impl.MedicineServiceImpl;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PrescribeController extends BaseController implements Initializable {
    public TableColumn drugidCol;
    public TableColumn drugnameCol;
    public TableColumn drugunitCol;
    public TableColumn drugtypeCol;
    public TableColumn priceCol;
    public TableColumn supportCol;
    public TableColumn stockCol;
    public TableView drugTable;
    public ListView drugList;
//    Medicine medicine = new Medicine();
    MedAddVo medAddVo = new MedAddVo();
MedicineService medicineService = new MedicineServiceImpl();
    ObservableList<MedAddVo> medaddVoObj= FXCollections.observableArrayList();
    ObservableList<MedAddVo> listmedic=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listmedic.clear();
        colToProperty();
        loadData();

    }
    void colToProperty(){
        this.colToPro(PrescribeController.class);
    }
    public   void loadData(){
        colToProperty();
        drugTable.getItems().clear();
        List<MedAddVo> list = null;
        try {
            list = medicineService.findMedicineVoAll();
            for (int i =0;i<list.size();i++){
                MedAddVo medAddVo=list.get(i);
                medaddVoObj.add(medAddVo);
            }
            drugTable.getItems().addAll(medaddVoObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectDrug(ActionEvent actionEvent) {
        drugList.getItems().clear();
        MedAddVo medAddVo = (MedAddVo) drugTable.getSelectionModel().getSelectedItem();
        System.out.println(medAddVo.toString());
        if (medAddVo==null){
            AlterUtil.alertError("请选择药品");
            return;
        }
        MedAddVo medAddVo1 = new MedAddVo();
        medAddVo1.setDrugid(medAddVo.getDrugid());
        medAddVo1.setDrugname(medAddVo.getDrugname());
        medAddVo1.setDrugunit(medAddVo.getDrugunit());
       // medAddVo.setDrugtype(medAddVo.getDrugtype());
        medAddVo1.setPrice(medAddVo.getPrice());
       // medAddVo.setSupport(medAddVo.getSupport());
       // medAddVo.setStock(medAddVo.getStock());
        boolean falg=false;
        for(int i=0;i<listmedic.size();i++){
            if(listmedic.get(i).getDrugid()==medAddVo1.getDrugid()){
                falg=true;
                medAddVo1.setStock(listmedic.get(i).getStock()+1);
                System.out.println(medAddVo1.toString());
                listmedic.remove(i);
                listmedic.add(medAddVo1);
                break;
            }
        }
        if(!falg){
            medAddVo1.setStock(1);
            listmedic.add(medAddVo1);
        }
        drugList.getItems().addAll(listmedic);

        //drugList.getItems().add(medAddVo);
    }

    public void prescribe(ActionEvent actionEvent) {
    }

    public void pay(ActionEvent actionEvent) {
    }
}
