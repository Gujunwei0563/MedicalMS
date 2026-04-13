package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.MedTypeDAO;
import com.example.web138_project.dao.mapper.EducationalMapper;
import com.example.web138_project.dao.mapper.MedicineTypeMapper;
import com.example.web138_project.entity.MedicineType;

import java.util.List;
@Respository
public class MedTypeDAOImpl extends MyJDBCTemplate implements MedTypeDAO {
    @Override
    public List<MedicineType> selectAll() throws DAOException {
        String sql ="select cid,cname,cdescp,lastdate from tab_drugtype";
        try {
            return this.queryAll(sql,new MedicineTypeMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public MedicineType selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(MedicineType medicineType) throws DAOException {
        String sql ="insert into tab_drugtype values(null,?,?,?)";
        Object obj[] ={medicineType.getCname(),medicineType.getCdescp(),medicineType.getLastdate()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_drugtype where cid=?";
        try {
            return this.exeuteUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }


    @Override
    public boolean upd(MedicineType medicineType) throws DAOException {
        return false;
    }
}
