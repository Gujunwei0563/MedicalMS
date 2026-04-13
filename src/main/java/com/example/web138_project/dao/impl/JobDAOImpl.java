package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.JobDAO;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.dao.mapper.JobMapper;
import com.example.web138_project.entity.Job;

import java.util.List;
@Respository
public class JobDAOImpl extends MyJDBCTemplate implements JobDAO {
    @Override
    public List<Job> selectAll() throws DAOException {
        String sql ="select jobid,jobname,jobdescp from tab_jobinfo";
        try {
            return this.queryAll(sql,new JobMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public Job selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Job job) throws DAOException {
        String sql ="insert into tab_jobinfo values(null,?,?)";
        Object obj[] ={job.getJobname(),job.getJobdescp()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_jobinfo where jobid=?";

        try {
            return this.exeuteUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean upd(Job job) throws DAOException {
        String sql ="update tab_jobinfo set jobname=?,jobdescp=? where jobid=?";
        Object obj[] ={job.getJobname(),job.getJobdescp(),job.getJobid()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
