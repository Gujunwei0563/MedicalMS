package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.dao.DeptDAO;
import com.example.web138_project.entity.Dept;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeptDAOImplTest {
    DeptDAO deptDAO =new DeptDAOImpl();

    @Test
    public void selectAll() {
        try {
            List<Dept> depts = deptDAO.selectAll();
            depts.forEach(System.out::println);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void selectById() {
    }

    @Test
    public void add() throws DAOException {
        boolean add = deptDAO.add(new Dept(0, "cccc", "ccc"));
        assertTrue(add);
    }

    @Test
    public void del() throws DAOException {
        boolean del = deptDAO.del(8);
        assertTrue(del);
    }

    @Test
    public void upd() throws DAOException {
        boolean upd = deptDAO.upd(new Dept(7, "ggg", "hhh"));
        assertTrue(upd);
    }
}