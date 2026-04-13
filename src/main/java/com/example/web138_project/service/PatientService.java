package com.example.web138_project.service;

import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.entity.MedicineType;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.entity.Registration;
import com.example.web138_project.entity.See_Doctor;
import com.example.web138_project.vo.PatientVo;

import java.util.List;

public interface PatientService {

    Patient selectByIdcard(String idcard) throws ServiceException;
    boolean addRegistration( Patient patient, Registration registration)throws ServiceException;
    boolean addPat(Patient patient) throws ServiceException;
    int addPatient(See_Doctor see_doctor) throws ServiceException;
    List<Patient> findPatientAll() throws ServiceException;
    boolean delPat(int patId,int val) throws ServiceException;
    List<PatientVo> findPatientByDocId(int docId) throws ServiceException;
    PatientVo findPatientByName(String name) throws ServiceException;

}
