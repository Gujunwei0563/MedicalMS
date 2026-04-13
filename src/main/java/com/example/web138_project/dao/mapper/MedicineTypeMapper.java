package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.MedicineType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineTypeMapper implements RowMapper<MedicineType> {
    @Override
    public MedicineType mapperRow(ResultSet rst) {
        MedicineType medicineType =new MedicineType();
        try {
            medicineType.setCid(rst.getInt("cid"));
            medicineType.setCname(rst.getString("cname"));
            medicineType.setCdescp(rst.getString("cdescp"));
            medicineType.setLastdate(rst.getString("lastdate"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medicineType;
    }
}
