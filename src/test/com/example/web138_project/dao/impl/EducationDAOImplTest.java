package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.dao.EducationDAO;
import com.example.web138_project.dao.JobDAO;
import com.example.web138_project.entity.Dept;
import com.example.web138_project.entity.Education;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EducationDAOImplTest {
    EducationDAO educationDAO =new EducationDAOImpl();
    @Test
    public void selectAll() throws DAOException {
        List<Education> educations =educationDAO.selectAll();
        educations.forEach(System.out::println);
    }

    @Test
    public void selectById() {
    }

    @Test
    public void add() throws DAOException {
        boolean add = educationDAO.add(new Education(0, "e535", "453"));
        assertTrue(add);
    }

    @Test
    public void del() throws DAOException {
        boolean del = educationDAO.del(6);
        assertTrue(del);
    }
    @Test
    public void upd() throws DAOException {
        boolean upd = educationDAO.upd(new Education(7, "ggg", "hhh"));
        assertTrue(upd);
    }
}