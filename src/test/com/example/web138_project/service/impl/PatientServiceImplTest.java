package com.example.web138_project.service.impl;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.entity.Registration;
import com.example.web138_project.entity.See_Doctor;
import com.example.web138_project.service.PatientService;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientServiceImplTest {
    PatientService patientService = new PatientServiceImpl();
    @Test
    public void selectByIdcard() {
    }

    @Test
    public void addRegistration() {
        Patient patient = new Patient();
        patient.setIdcard("1002");
        patient.setPname("王乐");
        patient.setGender("男");
        patient.setBirthday("2002-02-02");
        patient.setPhone("187894594332");
        patient.setIsdel(0);
        Registration registration = new Registration();
        registration.setDeptid(2);
        registration.setDoctorid(1);
        try {
            patientService.addRegistration(patient,registration);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void findPatientAll() {
        try {
            System.out.println(patientService.findPatientAll());
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void addPat() {
        Patient patient = new Patient();
        patient.setIdcard("1003");
        patient.setPname("王美");
        patient.setGender("女");
        patient.setBirthday("2001-02-02");
        patient.setPhone("19994594332");
        patient.setIsdel(0);
        try {
            patientService.addPat(patient);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addPatient() {
        See_Doctor see_doctor = new See_Doctor();
        see_doctor.setOrderid(1001);
        see_doctor.setPatieid(3);
        see_doctor.setDocid(1);
        see_doctor.setDeptid(2);
        see_doctor.setCreatetieme("2023-03-03 10:00:00");
        see_doctor.setDescp("感冒");
        see_doctor.setCash(100.0);
        try {
            patientService.addPatient(see_doctor);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}