package com.example.web138_project.service;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.entity.*;
import com.example.web138_project.vo.DoctorVo;

import java.util.List;
import java.util.Map;

public interface DoctorService {
    List<Dept> findDeptAll() throws ServiceException;
    List<Education> findEductionAll()throws ServiceException;
    List<Job> findJobAll()throws ServiceException;
    List<Doctor> findDoctorAll() throws ServiceException;
    boolean addDept(Dept dept)throws ServiceException;
    boolean delDept(int id)throws ServiceException;

    boolean addEducation(Education edu)throws ServiceException;
    boolean delEducation(int id)throws ServiceException;

    boolean addJob(Job job)throws ServiceException;
    boolean delJob(int id)throws ServiceException;
    boolean addDoctor(Login login, Doctor doctor) throws ServiceException;
    //记录总数
    int countInfo(Map<String,String> map) throws ServiceException;
    //医生信息分页查询
    List<DoctorVo> findPage(Map<String,String> map) throws ServiceException;
    //删除医生信息
    boolean delDoctor(int id) throws ServiceException;
    //查询医生信息
    DoctorVo findInfoById(int id) throws ServiceException;
    //修改医生信息
    boolean editDoctor(Doctor doctor) throws ServiceException;
    //登录
    DoctorVo loginDocInfo(String name,String pass) throws ServiceException;

    List<DoctorVo> showDocNameByDepartId(int departid) throws ServiceException;
}
