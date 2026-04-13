package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.MedicineSup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineSupMapper implements RowMapper<MedicineSup> {

    @Override
    public MedicineSup mapperRow(ResultSet rst) {
        MedicineSup medicineSup = new MedicineSup();
        try {
            medicineSup.setSuid(rst.getInt("suid"));
            medicineSup.setSupname(rst.getString("supname"));
            medicineSup.setTel(rst.getString("tel"));
            medicineSup.setEmail(rst.getString("email"));
            medicineSup.setAddress(rst.getString("address"));
            medicineSup.setSupdesc(rst.getString("supdesc"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medicineSup;
    }
}
