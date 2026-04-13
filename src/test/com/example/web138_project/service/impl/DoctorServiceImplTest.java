package com.example.web138_project.service.impl;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.entity.Doctor;
import com.example.web138_project.entity.Login;
import com.example.web138_project.service.DoctorService;
import com.example.web138_project.vo.DoctorVo;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DoctorServiceImplTest {
DoctorService doctorService =new DoctorServiceImpl();
    @Test
    public void addDoctor() {
        Login login =new Login();
        login.setLoginname("admin");
        Doctor doctor =new Doctor();
        doctor.setName("张三");
        doctor.setGender("男");
        doctor.setBirthday("2001-1-2");
        doctor.setJoid(1);
        doctor.setDeid(1);
        doctor.setEdid(1);
        doctor.setIconimg("/images/boy.jpg");
        try {
            boolean flag = doctorService.addDoctor(login, doctor);
            assertTrue(flag);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    @Test
    public void countInfo() {
        Map map =new HashMap();
        try {
            int i = doctorService.countInfo(map);
            System.out.println(i);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void findPage() {
        Map<String,String> map =new HashMap<>();
        map.put("page","3");
        map.put("size","2");
//        map.put("gender","女");
        try {
            List list =doctorService.findPage(map);
            list.forEach(System.out::println);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void loginDocInfo() {
        try {
            DoctorVo doctorVo = doctorService.loginDocInfo("admin","admin");
            System.out.println(doctorVo);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testLoginDocInfo() {
        try {
            DoctorVo doctorVo = doctorService.loginDocInfo("wang","888");
            System.out.println(doctorVo);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}