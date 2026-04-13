package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.Medicine;
import com.example.web138_project.vo.DoctorVo;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;

import java.util.List;
import java.util.Map;

public interface MedicineDAO extends BaseDAO<Medicine> {
    List<MedAddVo> listMedVoInfo ()  throws DAOException;
    List<MedAddVo> listMedVoInfoByWord(String word) throws DAOException;
    List<MedAddVo> listRecPage (Map<String,String> map) throws DAOException;
    //删除药品信息
    boolean delMedAddVo(int drugid) throws DAOException;
    //更新药品信息
    boolean updMedicine(MedAddVo medAddVo) throws DAOException;


}
