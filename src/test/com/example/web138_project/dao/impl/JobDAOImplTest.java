package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.dao.DeptDAO;
import com.example.web138_project.dao.JobDAO;
import com.example.web138_project.entity.Dept;
import com.example.web138_project.entity.Education;
import com.example.web138_project.entity.Job;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JobDAOImplTest {
    JobDAO jobDAO =new JobDAOImpl();
    @Test
    public void selectAll() {
        try {
            List<Job> jobs = jobDAO.selectAll();
            jobs.forEach(System.out::println);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selectById() {
    }

    @Test
    public void add() throws DAOException {
        boolean add = jobDAO.add(new Job(0, "564", "883"));
        assertTrue(add);
    }

    @Test
    public void del() throws DAOException {
        boolean del = jobDAO.del(5);
        assertTrue(del);
    }

    @Test
    public void upd() throws DAOException {
        boolean upd = jobDAO.upd(new Job(7, "ggg", "hhh"));
        assertTrue(upd);
    }
}