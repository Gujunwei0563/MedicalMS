package com.example.web138_project.vo.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.vo.PatientVo;

import java.sql.ResultSet;

public class PatientVoMapper implements RowMapper<PatientVo> {
    @Override
    public PatientVo mapperRow(ResultSet rst) {
        PatientVo patientVo =new PatientVo();
        try {
            patientVo.setAge(rst.getInt("age"));
            patientVo.setReid(rst.getInt("reid"));
            patientVo.setPatientid(rst.getInt("patientid"));
            patientVo.setLoginname(rst.getString("loginname"));
            patientVo.setPname(rst.getString("pname"));
            patientVo.setGender(rst.getString("gender"));
            patientVo.setBirthday(rst.getString("birthday"));
            patientVo.setIdcard(rst.getString("idcard"));
            patientVo.setPhone(rst.getString("phone"));
            patientVo.setIsdel(rst.getInt("isdel"));
            patientVo.setCreatetime(rst.getString("createtime"));
            patientVo.setDoctorid(rst.getInt("doctorid"));
            patientVo.setName(rst.getString("name"));
            patientVo.setDeptid(rst.getInt("deptid"));
            patientVo.setDepartname(rst.getString("departname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientVo;
    }
}
