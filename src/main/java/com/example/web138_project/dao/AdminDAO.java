package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.Admin;
import com.example.web138_project.vo.AdminVo;

import java.util.List;

public interface AdminDAO extends BaseDAO<Admin> {
    List<AdminVo> listAdminInfo() throws DAOException;
}
