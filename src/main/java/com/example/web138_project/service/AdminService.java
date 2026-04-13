package com.example.web138_project.service;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.entity.Admin;
import com.example.web138_project.entity.Login;
import com.example.web138_project.vo.AdminVo;

import java.util.List;

public interface AdminService {
     //添加管理员信息
     boolean add(Login login, Admin admin) throws ServiceException;
     //查询管理员信息
      AdminVo selectInfoById(int id) throws ServiceException;
      //查询管理员信息列表
      List<AdminVo> findInfo() throws ServiceException;

      AdminVo loginAdminInfo(String name,String pass) throws ServiceException;

}
