package com.example.web138_project.service.impl;

import com.example.web138_project.comm.anno.AutoWired;
import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.comm.factory.BeanFactory;
import com.example.web138_project.dao.*;
import com.example.web138_project.dao.impl.*;
import com.example.web138_project.entity.*;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.vo.DoctorVo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Respository
public class DoctorServiceImpl implements DoctorService {
    @AutoWired
    private DeptDAO deptDAO ;
    @AutoWired
    private EducationDAO educationDAO;
    @AutoWired
    private JobDAO jobDAO ;
//    @AutoWired
//    private LoginDAO loginDAO ;
    @AutoWired
    private DoctorDAO doctorDAO;
    private LoginDAO loginDAO = BeanFactory.getBean(LoginDAO.class);
    @Override
    public List<Dept> findDeptAll() throws ServiceException {
        try {
            return deptDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Education> findEductionAll() throws ServiceException{
        try {
            return educationDAO.selectAll();

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Job> findJobAll() throws ServiceException{
        try {
            return jobDAO.selectAll();

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Doctor> findDoctorAll() throws ServiceException {
        try {
            return doctorDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addDept(Dept dept) throws ServiceException{
        try {
            return deptDAO.add(dept);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delDept(int id) throws ServiceException{
        try {
            return deptDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addEducation(Education edu) throws ServiceException{
        try {
            return educationDAO.add(edu);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delEducation(int id) throws ServiceException{
        try {
            return educationDAO.del(id) ;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addJob(Job job) throws ServiceException{
        try {
            return jobDAO.add(job);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delJob(int id) throws ServiceException{
        try {
            return jobDAO.del(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addDoctor(Login login, Doctor doctor) throws ServiceException {

        boolean b = false;
        try {
            b = loginDAO.checkLoginName(login.getLoginname());
            if (b){
                int r1 = loginDAO.addLoginInfo(login);
                doctor.setDid(r1);
                return doctorDAO.add(doctor);
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
         return false;
    }

    @Override
    public int countInfo(Map<String, String> map) throws ServiceException {
        try {
            return doctorDAO.countRec(map);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<DoctorVo> findPage(Map<String, String> map) throws ServiceException {
        int page =0;
        int size=0;
        if (map.containsKey("page")){
            page=Integer.parseInt(map.get("page"));
            map.remove("page");
        }
        if (map.containsKey("size")){
            size=Integer.parseInt(map.get("size"));
        }
        //偏移值
        int offset =(page-1)*size;
        map.put("offset",String.valueOf(offset));
        try {
            return doctorDAO.listRecPage(map);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delDoctor(int id) throws ServiceException {
        try {
            boolean del = doctorDAO.del(id);
            if (del){


                return loginDAO.del(id);
            }

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return false;
    }

    @Override
    public DoctorVo findInfoById(int id) throws ServiceException {
        try {
            return doctorDAO.selectInfoById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean editDoctor(Doctor doctor) throws ServiceException {
        try {
            return doctorDAO.upd(doctor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public DoctorVo loginDocInfo(String name, String pass) throws ServiceException {
        try {
            return loginDAO.loginDoctor(name,pass);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<DoctorVo> showDocNameByDepartId(int departid) throws ServiceException {
        try {
           return doctorDAO.selectDocNameById(departid);
       } catch (DAOException e) {
           throw new ServiceException(e.getMessage());
       }
    }

//    @Override
//    public List<DoctorVo> showDocNameByDepartId(int departid) throws ServiceException {
//        try {
//            return doctorDAO.selectDocNameById(departid);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage());
//        }
//    }

}

