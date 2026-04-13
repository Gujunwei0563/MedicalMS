package com.example.web138_project.vo.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.vo.AdminVo;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminVoMapper implements RowMapper<AdminVo> {
    @Override
    public AdminVo mapperRow(ResultSet rst) {
        AdminVo adminVo = new AdminVo();
        try {
            adminVo.setAid(rst.getInt("aid"));
            adminVo.setLoginName(rst.getString("loginname"));
            adminVo.setPass(rst.getString("pass"));
            adminVo.setRoleid(rst.getInt("roleid"));
            adminVo.setAname(rst.getString("aname"));
            adminVo.setGender(rst.getString("gender"));
            adminVo.setTel(rst.getString("tel"));
            adminVo.setEmail(rst.getString("email"));
            adminVo.setWebchat(rst.getString("webchat"));
            adminVo.setQq(rst.getString("qq"));
            adminVo.setIconimg(rst.getString("iconimg"));
            adminVo.setRname(rst.getString("rname"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminVo;
    }
}
