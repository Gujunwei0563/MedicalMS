package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.MedSupDAO;
import com.example.web138_project.dao.mapper.MedicineSupMapper;
import com.example.web138_project.entity.MedicineSup;

import java.util.List;
@Respository
public class MedSupDAOImpl extends MyJDBCTemplate implements MedSupDAO {
    @Override
    public List<MedicineSup> selectAll() throws DAOException {
        String sql ="select suid,supname,tel,email,address,supdesc from tab_support";
        try {
            return this.queryAll(sql,new MedicineSupMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public MedicineSup selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(MedicineSup medicineSup) throws DAOException {
        String sql ="insert into tab_support values(null,?,?,?,?,?)";
        Object obj[] ={medicineSup.getSupname(),medicineSup.getTel(),medicineSup.getEmail(),medicineSup.getAddress(),medicineSup.getSupdesc()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_support where suid=?";
        try {
            return this.exeuteUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }


    @Override
    public boolean upd(MedicineSup medicineSup) throws DAOException {
        return false;
    }
}
