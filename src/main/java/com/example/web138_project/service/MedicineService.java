package com.example.web138_project.service;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.entity.Dept;
import com.example.web138_project.entity.Medicine;
import com.example.web138_project.entity.MedicineSup;
import com.example.web138_project.entity.MedicineType;
import com.example.web138_project.vo.DoctorVo;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;

import java.util.List;
import java.util.Map;

public interface MedicineService {
    List<MedicineType> findMedicineTypeAll() throws ServiceException;
    List<MedicineSup> findMedicineSupAll() throws ServiceException;
    List<MedAddVo> findMedicineVoAll() throws ServiceException;
    List<MedAddVo> findMedicineVoByWord(String word) throws ServiceException;
    boolean addSup(MedicineSup medicineSup)throws ServiceException;
    boolean delSup(int id)throws ServiceException;
    boolean addType(MedicineType medicineType)throws ServiceException;
    boolean delType(int id)throws ServiceException;
    boolean addMedicine(Medicine medicine)throws ServiceException;
    //记录患者数
    int countInfo(Map<String,String> map) throws ServiceException;
    //患者信息分页查询
    List<MedAddVo> findPage(Map<String,String> map) throws ServiceException;
    //删除药品信息
    boolean delMedAddVo(int drugid)throws ServiceException;
    //修改药品信息
    boolean updMedicine(MedAddVo medicineVo)throws ServiceException;


}
