package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.dao.AdminDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminDAOImplTest {

    @Test
    public void listAdminInfo() {
        AdminDAO adminDAO = new AdminDAOImpl();
        try {
            System.out.println(adminDAO.listAdminInfo());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}