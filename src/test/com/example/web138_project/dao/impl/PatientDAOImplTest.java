package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.vo.PatientVo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PatientDAOImplTest {

    @Test
    public void updateDel() {
        PatientDAOImpl patientDAO = new PatientDAOImpl();
        try {
            patientDAO.updateDel(5,0);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectPatByDocId() {
        PatientDAOImpl patientDAO = new PatientDAOImpl();
        try {
            List<PatientVo> patientVos = patientDAO.selectPatByDocId(1);
            for (PatientVo patientVo : patientVos) {
                System.out.println(patientVo);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}