package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper<Login> {
    @Override
    public Login mapperRow(ResultSet rst) {
        Login login =new Login();
        try {
            login.setId(rst.getInt("id"));
            login.setLoginname(rst.getString("loginname"));
            login.setPass(rst.getString("pass") );
            login.setRoleid(rst.getInt("roleid"));
            login.setIslogin(rst.getInt("islogin"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return login;
    }
}
