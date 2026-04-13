package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.Login;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;

public interface LoginDAO extends BaseDAO<Login> {
    int addLoginInfo(Login login) throws DAOException;
    boolean checkLoginName(String name  ) throws DAOException;
    //登录管理员
    AdminVo loginAdmin(String name, String pass) throws DAOException;
    DoctorVo loginDoctor(String name, String pass) throws DAOException;

}
