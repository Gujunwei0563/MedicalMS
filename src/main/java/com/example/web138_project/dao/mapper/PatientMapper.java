package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMapper implements RowMapper<Patient> {
    @Override
    public Patient mapperRow(ResultSet rst) {
        Patient patient =new Patient();
        try {
            patient.setPatientid(rst.getInt("patientid"));
            patient.setPname(rst.getString("pname"));
            patient.setGender(rst.getString("gender"));
            patient.setBirthday(rst.getString("birthday"));
            patient.setIdcard(rst.getString("idcard"));
            patient.setPhone(rst.getString("phone"));
            patient.setIsdel(rst.getInt("isdel"));
            patient.setCreatetime(rst.getString("createtime"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }
}
