package com.example.web138_project.dao;

import com.example.web138_project.comm.dao.BaseDAO;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.entity.See_Doctor;

public interface See_DoctorDAO extends BaseDAO<See_Doctor> {
    public int addSeeDoctor(See_Doctor see_doctor) throws DAOException;
    int addPatient(See_Doctor see_doctor) throws DAOException;
}
