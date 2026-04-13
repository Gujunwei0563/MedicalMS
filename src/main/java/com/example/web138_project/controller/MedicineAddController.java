package com.example.web138_project.controller;

import com.example.web138_project.comm.controller.BaseController;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.comm.util.ChangeTitle;
import com.example.web138_project.comm.ui.MyUIManager;
import com.example.web138_project.comm.ui.UIConstant;
import com.example.web138_project.comm.util.AlterUtil;
import com.example.web138_project.comm.util.StringUtil;
import com.example.web138_project.dao.MedicineDAO;
import com.example.web138_project.entity.Medicine;
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
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;

import static com.example.web138_project.controller.MainController.nodeList;

public class MedicineAddController extends BaseController implements Initializable {
    public TextField priceInRef;
    public TextField priceOutRef;
    public TextField drugUnitRef;

    public TextField drugNameRef;
    public TextField stockRef;
    public DatePicker productDateRef;
    public TextArea drugdescpRef;
    public DatePicker effectdateRef;
    public ComboBox <MedicineSup>supportCom;
    public ComboBox<MedicineType>drugTypeCom;
    public Label titleLab;
    public Button addDrugBtn;
    public Button updateDrugBtn;
    public TextField drugidRef;
    public ImageView bgImg;
    int medTypeId =0;
    int medSupId =0;
    ObservableList<MedicineType> medTypeObj= FXCollections.observableArrayList();
    ObservableList<MedicineSup> medSupObj= FXCollections.observableArrayList();
    MedicineService medicineService= BeanFactory.getBean(MedicineService.class);
    Medicine medicine =new Medicine();
    MedicineDAO medicineDAO = BeanFactory.getBean(MedicineDAO.class);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(this.getClass().getResourceAsStream("/images/bg4.jpg"));
        bgImg.setImage(image);
        loadComDate();
        //桥梁跨越不同的类显示盒不显示按钮
        titleLab.setText(ChangeTitle.isEditMode()?"药品更新":"药品添加");
        addDrugBtn.setVisible(!ChangeTitle.isEditMode());
        updateDrugBtn.setVisible(ChangeTitle.isEditMode());
        Map<Integer, MedAddVo> dataMap = MedicineVoInfoUtil.get();
        if (dataMap != null && dataMap.containsKey(1)) {
            MedAddVo selectedData = dataMap.get(1);
            fillFormWithData(selectedData); // 自定义方法填充表单
}
    }
public void loadComDate() {
        try {
        medTypeObj.addAll(medicineService.findMedicineTypeAll());
        medSupObj.addAll(medicineService.findMedicineSupAll());
        drugTypeCom.setItems(medTypeObj);
        supportCom.setItems(medSupObj);
        } catch (ServiceException e) {
        throw new RuntimeException(e);
        }
        }

    private void fillFormWithData(MedAddVo data) {
        // 实现表单数据填充逻辑
        // 例如：txtField.setText(data.getFieldName());
        drugidRef.setText(data.getDrugid()+"");
        drugidRef.setText(data.getDrugid()+"");
        drugNameRef.setText(data.getDrugname());
        drugUnitRef.setText(data.getDrugunit());
        stockRef.setText(data.getStock()+"");
        priceInRef.setText(data.getPurchaseprice()+"");
        priceOutRef.setText(data.getPrice()+"");
        productDateRef.setValue(LocalDate.parse(data.getProductdate().substring(0,10)));
        effectdateRef.setValue(LocalDate.parse(data.getEffectdate().substring(0,10)));
        drugdescpRef.setText(data.getDescp());
        drugTypeCom.setValue(new MedicineType(0, data.getCname(),"",""));
        for(int i=0;i<medTypeObj.size();i++){
            if(medTypeObj.get(i).getCname().equals(data.getCname())){
                medTypeId = medTypeObj.get(i).getCid();
                break;
            }
        }
        supportCom.setValue(new MedicineSup(0, data.getSupname(), ""," "," ",""));
        for(int i=0;i<medSupObj.size();i++){
            if(medSupObj.get(i).getSupname().equals(data.getSupname())){
                medSupId = medSupObj.get(i).getSuid();
                break;
            }
        }
//        for(MedicineType type : medTypeObj){
//            if(type.getCname().equals(data.getDrugtype())){
//                drugTypeCom.getSelectionModel().select(type);
//                break;
//            }
//        }
//
//        // 设置供应商下拉框（通过ID匹配现有选项）
//        for(MedicineSup sup : medSupObj){
//            if(sup.getSupname().equals(data.getSupport())){
//                supportCom.getSelectionModel().select(sup);
//                break;
//            }
//        }
    }

public void addDrug(ActionEvent actionEvent) {
        Medicine  med =new Medicine();
        if (drugNameRef.getText().equals("")|| drugUnitRef.getText().equals("")||stockRef.getText().equals("")||
                priceInRef.getText().equals("")||priceOutRef.getText().equals("")||effectdateRef.getValue()==null||
                productDateRef.getValue()==null ||drugdescpRef.getText().equals("")){
            AlterUtil.alertError("填全药品信息");
            return;
        }
        if (!StringUtil.isNumber(priceInRef.getText())){
            AlterUtil.alertError("请输入正确的进价");
            return;
        }
        if (!StringUtil.isNumber(priceOutRef.getText())){
            AlterUtil.alertError("请输入正确的销售价格");
            return;
        }
        if (!StringUtil.isChi(drugNameRef.getText())){
            AlterUtil.alertError("请输入正确的药品名称");
            return;
        }
        if (!StringUtil.isChi(drugUnitRef.getText())){
            AlterUtil.alertError("请输入正确的药品单位");
            return;
        }
        if (!StringUtil.isNumber(stockRef.getText())){
            AlterUtil.alertError("请输入正确的库存数量");
            return;
        }

        if (drugTypeCom.getValue()==null||supportCom.getValue()== null){
            AlterUtil.alertError("请选择药品类型或供应商");
            return;
        }
        med.setDrugname(drugNameRef.getText());
        med.setDrugtype(drugTypeCom.getSelectionModel().getSelectedItem().getCid());
        med.setDrugunit(drugUnitRef.getText());
        med.setSupport(supportCom.getSelectionModel().getSelectedItem().getSuid());
        med.setProductdate(productDateRef.getValue().toString());
        med.setEffectdate(effectdateRef.getValue().toString());
        med.setStock(Integer.parseInt(stockRef.getText()));
        med.setPurchaseprice(Integer.parseInt(priceInRef.getText()));
        med.setPrice(Integer.parseInt(priceOutRef.getText()));
        med.setDescp(drugdescpRef.getText());
        try {
            boolean b = medicineService.addMedicine(med);
            if ( b){
                AlterUtil.alertInfo("添加成功");
            }else {
                AlterUtil.alertError("添加失败");
            }
        //清空输入框
            drugidRef.setText("");
            drugNameRef.setText("");
            drugTypeCom.setValue(null);
            supportCom.setValue(null);
             drugUnitRef.setText("");
            productDateRef.setValue(null);
            effectdateRef.setValue(null);
            stockRef.setText("");
            priceInRef.setText("");
            priceOutRef.setText("");
            drugdescpRef.setText("");

        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }
    public void backDrugManager(ActionEvent actionEvent) {
        MyUIManager.show(nodeList, UIConstant.Med_MANAGER);
    }
    public void updateDrug(ActionEvent actionEvent) {
        //更新药品信息
AlterUtil.alertConfig("确认修改吗",(s)->{
            try {
                MedAddVo medicine = new  MedAddVo();

                //设置药品编号不能更改
                if (medicine.getDrugid()!=Integer.parseInt(drugidRef.getText())){
                    AlterUtil.alertError("很抱歉，药品编号无法更改，请重新选择");
                    return;
                }
                medicine.setDrugid(Integer.parseInt(drugidRef.getText()));
                medicine.setDrugname(drugNameRef.getText());
                medicine.setDrugunit(drugUnitRef.getText());
                medicine.setStock(Integer.parseInt(stockRef.getText()));
                medicine.setPurchaseprice(Integer.parseInt(priceInRef.getText()));
                medicine.setPrice(Integer.parseInt(priceOutRef.getText()));
                medicine.setProductdate(productDateRef.getValue().toString());
                medicine.setEffectdate(effectdateRef.getValue().toString());
                medicine.setDescp(drugdescpRef.getText());
                medicine.setDrugtype(medTypeId);
                medicine.setSupport(medSupId);
                boolean b = medicineService.updMedicine(medicine);
                if (b){
                    AlterUtil.alertInfo("修改成功");

                }else {
                    AlterUtil.alertError("修改失败");
                }
            } catch (ServiceException e) {
                throw new RuntimeException(e);
            }
        });
        //页面跳转(UIConstant.Med_MANAGER);
        MyUIManager.show(nodeList,UIConstant.Med_MANAGER);
        //清空输入框
        drugidRef.setText("");
        drugNameRef.setText("");
        drugTypeCom.setValue(null);
        supportCom.setValue(null);
        drugUnitRef.setText("");
        productDateRef.setValue(null);
        effectdateRef.setValue(null);
        stockRef.setText("");
        priceInRef.setText("");
        priceOutRef.setText("");
        drugdescpRef.setText("");
    }
}
