package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.vo.PatientVo;

import java.util.List;

public interface PatientDAO extends BaseDAO<Patient> {
    List<Patient> selectAll() throws DAOException;
    Patient selectByIdcard(String  idcard) throws DAOException;
    int insertRecordPatient(Patient patient) throws DAOException;
    //逻辑删除
    boolean updateDel(int patId ,int val) throws DAOException;
    List<PatientVo> selectPatByDocId(int docId) throws DAOException;
  PatientVo selectPatByName(String name) throws DAOException;

}
