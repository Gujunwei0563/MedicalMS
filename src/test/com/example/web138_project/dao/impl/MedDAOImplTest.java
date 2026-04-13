package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.dao.MedicineDAO;
import com.example.web138_project.vo.MedAddVo;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MedDAOImplTest {
    MedicineDAO medicineDAO = new MedDAOImpl();

    @Test
    public void listRecPage() {
        Map<String,String> map = new HashMap<>();
        map.put("offset","2");
        map.put("size","2");
        try {
            List<MedAddVo> list = medicineDAO.listRecPage(map);
            for (MedAddVo medAddVo : list) {
                System.out.println(medAddVo);
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void countRec() {
        Map<String,String> map = new HashMap<>();
        try {
            int num = medicineDAO.countRec(map);
            System.out.println(num);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}