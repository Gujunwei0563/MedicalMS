package com.example.web138_project.service.impl;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.service.AdminService;
import com.example.web138_project.vo.AdminVo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceImplTest {

    @Test
    public void findInfo() {
        AdminService adminService = new AdminServiceImpl();
        try {
            List<AdminVo> adminVos = adminService.findInfo();
            for (AdminVo adminVo : adminVos) {
                System.out.println(adminVo);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}