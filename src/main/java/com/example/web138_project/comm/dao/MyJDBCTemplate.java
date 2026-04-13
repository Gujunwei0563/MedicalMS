package com.example.web138_project.comm.dao;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.comm.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class MyJDBCTemplate {
        public boolean exeuteUpd(final  String SQL,Object... params) throws DataException {
            Connection con = JDBCUtil.getJdbcUtil().getCon();
            try {
                PreparedStatement preparedStatement =con.prepareStatement(SQL);
                setParam(preparedStatement, params);
                return preparedStatement.executeUpdate()>0;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DataException("增删改出错");
            }
        }

    private static void setParam(PreparedStatement preparedStatement, Object[] params) throws SQLException {
        for (int i = 0; i< params.length; i++){
            preparedStatement.setObject((i+1), params[i]);
        }
    }

    public <T> List<T> queryAll(final  String SQL, RowMapper<T> rowMapper, Object... params ) throws DataException {
            List<T> list =new ArrayList<>();
            Connection con =JDBCUtil.getJdbcUtil().getCon();
            try {
                PreparedStatement preparedStatement = con.prepareStatement(SQL);
                setParam(preparedStatement, params);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    T t = rowMapper.mapperRow(resultSet);
                    list.add(t);
                }
            } catch (SQLException e) {
                throw new DataException("查询记录出错");
            }
            return list;
        }
    public <T> T queryOne(final  String SQL, RowMapper<T> rowMapper, Object... params ) throws DataException {

        Connection con =JDBCUtil.getJdbcUtil().getCon();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            setParam(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
                T t = rowMapper.mapperRow(resultSet);
                return  t;
            }
           return  null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("查询一条记录出错");
        }
    }
        public int insertRecord(final String SQL,Object... params) throws DataException{
            Connection con =JDBCUtil.getJdbcUtil().getCon();
            try {
                PreparedStatement pst = con.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);
                setParam(pst,params);
                int row = pst.executeUpdate();
                if (row<1){
                    throw new DataException("新增记录，返回主键出错");
                }
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()){
                     return generatedKeys.getInt(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return 0;
        }
        public StringBuilder dysql(String sql,Map<String ,String> map){
                StringBuilder sbuf=new StringBuilder(sql);
                if (map!=null&& !map.isEmpty()){
                    List<String> skipList = Arrays.asList("offset", "size");
                    for (String key : map.keySet()){
                        if (!skipList.contains(key) ){
                            sbuf.append(" and "+key);
                            sbuf.append(" like concat('%','");
                            sbuf.append(map.get(key));
                            sbuf.append("','%')");
                        }
                    }
                }
                return sbuf;
        }
        //根据条件返回记录数
        public <T> int count(final String SQL, Map<String ,String >map) throws DataException{
                Connection con =JDBCUtil.getJdbcUtil().getCon();
                String sql = dysql(SQL, map).toString();
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    return resultSet.getInt(1);
                }

            } catch (SQLException e) {
                throw new DataException("记录总数出错");
            }
            return 0;
        }
        public<T> List <T> listPage(final String SQL,RowMapper<T>rowMapper,Map<String ,String >map) throws DataException{
            List<T> list =new ArrayList<>();
            Connection con =JDBCUtil.getJdbcUtil().getCon();
            StringBuilder stringBuilder = dysql(SQL, map);
            stringBuilder.append(" limit ");
            stringBuilder.append(Integer.parseInt(map.get("offset")));
            stringBuilder.append(",");
            stringBuilder.append(Integer.parseInt(map.get("size")));
            String sql = stringBuilder.toString();
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    T t = rowMapper.mapperRow(resultSet);
                    list.add(t);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new DataException("分页记录查询出错");
            }
            return list;
        }
}
