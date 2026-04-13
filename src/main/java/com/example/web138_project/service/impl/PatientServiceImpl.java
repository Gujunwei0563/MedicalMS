package com.example.web138_project.service.impl;

import com.example.web138_project.comm.anno.AutoWired;
import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.dao.PatientDAO;
import com.example.web138_project.dao.RegistrationDAO;
import com.example.web138_project.dao.See_DoctorDAO;
import com.example.web138_project.dao.impl.PatientDAOImpl;
import com.example.web138_project.dao.impl.RegistrationDAOImpl;
import com.example.web138_project.dao.impl.SeeDoctorImpl;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.entity.Registration;
import com.example.web138_project.entity.See_Doctor;
import com.example.web138_project.service.PatientService;
import com.example.web138_project.vo.PatientVo;

import java.util.List;
@Respository
public class PatientServiceImpl implements PatientService {
        @AutoWired
        private  PatientDAO patientDAO;
        @AutoWired
        private  RegistrationDAO registrationDAO;

      See_DoctorDAO see_doctorDAO =new SeeDoctorImpl();

    @Override
    public Patient selectByIdcard(String idcard) throws ServiceException {

        try {
            return patientDAO.selectByIdcard(idcard);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public boolean addRegistration(Patient patient, Registration registration) throws ServiceException {
       String idcard = patient.getIdcard();
        try {
            //挂号
            Patient patient1 = patientDAO.selectByIdcard(idcard);
            if(patient1==null){
                int pid = patientDAO.insertRecordPatient(patient);
                registration.setPatientid(pid);
                return registrationDAO.add(registration);
            }else {
                int patientid = patient.getPatientid();
                registration.setPatientid(patientid);
                return registrationDAO.add(registration);
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean addPat(Patient patient) throws ServiceException {
        try {
            return patientDAO.add(patient);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int addPatient(See_Doctor see_doctor) throws ServiceException {
        try {
            return see_doctorDAO.addPatient(see_doctor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Patient> findPatientAll() throws ServiceException {
        try {
            return patientDAO.selectAll() ;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delPat(int patId, int val) throws ServiceException {
        try {
            return patientDAO.updateDel(patId,val);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public List<PatientVo> findPatientByDocId(int docId) throws ServiceException {
        try {
            return patientDAO. selectPatByDocId(docId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public PatientVo findPatientByName(String name) throws ServiceException {
        try {
            return patientDAO.selectPatByName(name);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


}
