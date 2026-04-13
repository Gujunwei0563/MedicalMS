package com.example.web138_project.service.impl;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.dao.MedicineDAO;
import com.example.web138_project.dao.impl.MedDAOImpl;
import com.example.web138_project.entity.Medicine;
import com.example.web138_project.service.MedicineService;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MedicineServiceImplTest {


    @Test
    public void updMedicine() {
        MedicineService medicineService = new MedicineServiceImpl();
        MedAddVo medicine = new MedAddVo();
        medicine.setDrugid(4);
        medicine.setDrugname("感冒灵");
        medicine.setDrugunit("盒");
        medicine.setStock(100);
        medicine.setPurchaseprice(10);
        medicine.setPrice(10);
        medicine.setProductdate("2020-01-01");
        medicine.setEffectdate("2020-01-01");
        medicine.setDescp("感冒灵");
        medicine.setDrugtype(1);
        medicine.setSupport(1);
        boolean b = false;
        try {
            b = medicineService.updMedicine(medicine);
            if (b){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        System.out.println(b);
    }

    @Test
    public void findMedicineVoByWord() {
        MedicineService medicineService = new MedicineServiceImpl();
        try {
            List<MedAddVo> list = medicineService.findMedicineVoByWord("感");
            for (MedAddVo medAddVo : list) {
                System.out.println(medAddVo);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}