package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.See_DoctorDAO;
import com.example.web138_project.entity.See_Doctor;

import java.util.List;

public class SeeDoctorImpl extends MyJDBCTemplate implements See_DoctorDAO {
    @Override
    public List<See_Doctor> selectAll() throws DAOException {
        return null;
    }

    @Override
    public See_Doctor selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(See_Doctor seeDoctor) throws DAOException {
        String sql="insert into tab_see_doctor values(null,?,?,?,?,now(),?,0,0)";
        Object obj[]=new Object[]{seeDoctor.getPatieid(),seeDoctor.getRegid(),seeDoctor.getDeptid(),
                seeDoctor.getDescp(),seeDoctor.getDocid()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        return false;
    }

    @Override
    public boolean upd(See_Doctor seeDoctor) throws DAOException {
        return false;
    }

    @Override
    public int addSeeDoctor(See_Doctor see_doctor) throws DAOException {
        String sql="insert into tab_see_doctor values(null,?,?,?,?,now(),?,0,0)";
        Object obj[]=new Object[]{see_doctor.getPatieid(),see_doctor.getRegid(),see_doctor.getDeptid(),
                see_doctor.getDescp(),see_doctor.getDocid()};
        try {
            return this.insertRecord(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public int addPatient(See_Doctor see_doctor) throws DAOException {
        String sql="insert into tab_see_doctor values(null,?,?,?,?,now(),?,0,0)";
        Object obj[]=new Object[]{see_doctor.getPatieid(),see_doctor.getRegid(),see_doctor.getDeptid(),
                see_doctor.getDescp(),see_doctor.getDocid()};
        try {
            return this.insertRecord(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
