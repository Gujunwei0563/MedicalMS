package com.example.web138_project.service.impl;

import com.example.web138_project.comm.anno.AutoWired;
import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.dao.AdminDAO;
import com.example.web138_project.dao.LoginDAO;
import com.example.web138_project.dao.impl.AdminDAOImpl;
import com.example.web138_project.dao.impl.LoginDAOImpl;
import com.example.web138_project.entity.Admin;
import com.example.web138_project.entity.Login;
import com.example.web138_project.service.AdminService;
import com.example.web138_project.vo.AdminVo;

import java.util.List;
@Respository
public class AdminServiceImpl implements AdminService {
    @AutoWired
    private LoginDAO loginDAO ;
    @AutoWired
    private AdminDAO adminDAO;
    @Override
    public boolean add(Login login, Admin admin) throws ServiceException {
        boolean b = false;
        try {
            b = loginDAO.checkLoginName(login.getLoginname());
            if(b){
                int r1 = loginDAO.addLoginInfo(login);
               admin.setAid(r1);
                return adminDAO.add(admin);
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return false;
    }

    @Override
    public AdminVo selectInfoById(int id) throws ServiceException {
        return null;
    }

    @Override
    public List<AdminVo> findInfo() throws ServiceException {
        try {
            return adminDAO.listAdminInfo();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public AdminVo loginAdminInfo(String name, String pass) throws ServiceException {
        try {
            return loginDAO.loginAdmin(name,pass);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
