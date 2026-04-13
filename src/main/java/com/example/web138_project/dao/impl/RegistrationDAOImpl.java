package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.RegistrationDAO;
import com.example.web138_project.entity.Registration;

import java.util.List;
@Respository
public class RegistrationDAOImpl extends MyJDBCTemplate implements RegistrationDAO {


    @Override
    public List<Registration> selectAll() throws DAOException {
        return null;
    }

    @Override
    public Registration selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Registration registration) throws DAOException {
        String sql = "insert into tab_registration(patientid,doctorid,deptid,createtime,status) values(?,?,?,now(),0)";
        Object [] obj = {registration.getPatientid(),registration.getDoctorid(),registration.getDeptid()};
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
    public boolean upd(Registration registration) throws DAOException {
        return false;
    }

    @Override
    public boolean updateStatus(int reid, int status) throws DAOException {
        String sql = "update tab_registration set status=? where reid=?";
        Object [] obj = {status,reid};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
