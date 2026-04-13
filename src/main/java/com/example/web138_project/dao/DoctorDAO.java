package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.Doctor;
import com.example.web138_project.vo.DoctorVo;
//import com.example.web138_project.vo.DoctorVo;

import java.util.List;
import java.util.Map;

public interface DoctorDAO extends BaseDAO<Doctor> {
    int addDoctorInfo(Doctor doctor) throws DAOException;
    List<DoctorVo> listDocInfo ()  throws DAOException;
    List<DoctorVo> listRecPage (Map<String,String> map) throws DAOException;
    DoctorVo selectInfoById(int id) throws DAOException;
    List<DoctorVo> selectDocNameById(int  id) throws DAOException;


}
