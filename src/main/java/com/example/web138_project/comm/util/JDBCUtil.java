package com.example.web138_project.comm.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    private static  JDBCUtil jdbcUtil=new JDBCUtil();
    private BasicDataSource dataSource;
    private ThreadLocal<Connection> local =new ThreadLocal<>();

    private JDBCUtil(){
        Properties properties =new Properties();
        try {
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            dataSource=(BasicDataSource) BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static JDBCUtil getJdbcUtil(){
        return jdbcUtil;
    }
    public Connection getCon(){
        Connection connection = local.get();
        if (connection==null){
            try {
               connection= dataSource.getConnection();
               local.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
    public void close(){
        Connection connection = local.get();
        if (connection!=null){
            try {
                connection.close();
                local.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
