package com.example.web138_project.comm.util;


import java.sql.Connection;

public class JDBCUtilTest {

    @org.junit.Test
    public void getCon() {
        Connection con =JDBCUtil.getJdbcUtil().getCon();
        System.out.println(con);
    }
}