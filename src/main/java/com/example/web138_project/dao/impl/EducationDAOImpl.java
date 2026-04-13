package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.EducationDAO;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.dao.mapper.EducationalMapper;
import com.example.web138_project.entity.Education;

import java.util.List;
@Respository
public class EducationDAOImpl extends MyJDBCTemplate implements EducationDAO {
    @Override
    public List<Education> selectAll() throws DAOException {
        String sql ="select eid,ename,edescp from tab_educationinfo";

        try {
            return this.queryAll(sql,new EducationalMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Education selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Education education) throws DAOException {
        String sql ="insert into tab_educationinfo values(null,?,?)";
        Object obj[] ={education.getEname(),education.getEdescp()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_educationinfo where eid=?";
        try {
            return this.exeuteUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }



    @Override
    public boolean upd(Education education) throws DAOException {
        String sql ="update tab_educationinfo set ename=?,edescp=? where eid=?";
        Object obj[] ={education.getEname(),education.getEdescp(),education.getEid()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
