package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.Education;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationalMapper implements RowMapper<Education> {
    @Override
    public Education mapperRow(ResultSet rst) {
       Education education =new Education();
        try {
            education.setEid(rst.getInt("eid"));
            education.setEname(rst.getString("ename"));
            education.setEdescp(rst.getString("edescp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return education;
    }
}
