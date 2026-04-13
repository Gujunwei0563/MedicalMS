package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapperRow(ResultSet rst) {
        Doctor doctor = new Doctor();
        try {
            doctor.setDid(rst.getInt("did"));
            doctor.setName(rst.getString("name"));
            doctor.setGender(rst.getString("gender"));
            doctor.setBirthday(rst.getString("birthday"));
            doctor.setJoid(rst.getInt("joid"));
            doctor.setEdid(rst.getInt("edid"));
            doctor.setDeid(rst.getInt("deid"));
            doctor.setIconimg(rst.getString("iconimg"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }
}
