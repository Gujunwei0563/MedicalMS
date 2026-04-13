package com.example.web138_project.comm.dao;

import java.sql.ResultSet;

public interface RowMapper <T>{
    T mapperRow(ResultSet rst);
}
