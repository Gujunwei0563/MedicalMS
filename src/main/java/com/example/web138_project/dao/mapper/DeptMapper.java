package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptMapper implements RowMapper<Dept> {
    @Override
    public Dept mapperRow(ResultSet rst) {
        Dept dept =new Dept();
        try {
            dept.setDepartid(rst.getInt("departid"));
            dept.setDepartname(rst.getString("departname"));
            dept.setDepartdescp(rst.getString("departdescp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dept;
    }
}
