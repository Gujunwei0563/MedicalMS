package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginDAOImplTest {

    @Test
    public void loginDoctor() throws DAOException {
        LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
        DoctorVo doctorVo = loginDAOImpl.loginDoctor("admin2", "8888");
        System.out.println(doctorVo);
    }

    @Test
    public void loginAdmin() throws DAOException {
        LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
        AdminVo adminVo = loginDAOImpl.loginAdmin("wang", "8888");
        System.out.println(adminVo);
    }
}