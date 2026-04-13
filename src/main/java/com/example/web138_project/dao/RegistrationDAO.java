package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.Registration;

import java.util.List;

public interface RegistrationDAO extends BaseDAO<Registration> {
    //更改状态
    boolean updateStatus(int reid,int status) throws DAOException;

}
