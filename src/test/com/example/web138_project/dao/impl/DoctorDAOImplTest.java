package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.dao.DoctorDAO;
import com.example.web138_project.entity.Doctor;
import com.example.web138_project.vo.DoctorVo;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DoctorDAOImplTest {
    DoctorDAO doctorDAO =new DoctorDAOImpl();

    @Test
    public void listDocInfo() throws DAOException {
        List<DoctorVo> doctorVos=doctorDAO.listDocInfo();
        doctorVos.forEach(System.out::println);
    }

    @Test
    public void countRec() throws DAOException {
        Map<String ,String >map =new HashMap<>();
//        map.put("gender","男");
//        map.put("edid","1");
        int i = doctorDAO.countRec(map);
        System.out.println(i);
    }

    @Test
    public void listRecPage() throws DAOException{
        Map<String ,String> map=new HashMap<>();
        map.put("offset","2");
        map.put("size","2");
        List<DoctorVo> doctorVos=doctorDAO.listRecPage(map);
        doctorVos.forEach(System.out::println);
    }


    @Test
    public void selectInfoById() {
            try {
                DoctorVo doctorVo = doctorDAO.selectInfoById(2);
                System.out.println(doctorVo);

            } catch (DAOException e) {
                throw new RuntimeException(e);
            }

        }

    @Test
    public void selectNameById() {
        try {
            List<DoctorVo> doctor = doctorDAO.selectDocNameById(2);
            doctor.forEach(System.out::println);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}