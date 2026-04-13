package com.example.web138_project.vo.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.vo.DoctorVo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorVoMapper implements RowMapper<DoctorVo> {

    @Override
    public DoctorVo mapperRow(ResultSet rst) {
        DoctorVo doctorVo =new DoctorVo();
        try {
            doctorVo .setDid(rst.getInt("did"));
            doctorVo.setLoginname(rst.getString("loginname"));
            doctorVo.setPass(rst.getString("pass"));
            doctorVo.setRoleid(rst.getInt("roleid"));
            doctorVo.setName(rst.getString("name"));
            doctorVo.setGender(rst.getString("gender"));
            doctorVo.setBirthday(rst.getString("birthday"));
            doctorVo.setJoid(rst.getInt("joid"));
            doctorVo.setJobname(rst.getString("jobname"));
            doctorVo.setDeid(rst.getInt("deid"));
            doctorVo.setDepartname(rst.getString("departname"));
            doctorVo.setEdid(rst.getInt("edid"));
            doctorVo.setEname(rst.getString("ename"));
            doctorVo.setRname(rst.getString("rname"));
            doctorVo.setIconimg(rst.getString("iconimg"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctorVo;
    }
}
