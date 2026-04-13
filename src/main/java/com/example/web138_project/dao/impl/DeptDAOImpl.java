package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.DeptDAO;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.dao.mapper.DeptMapper;
import com.example.web138_project.entity.Dept;

import java.util.List;
@Respository
public class DeptDAOImpl extends  MyJDBCTemplate implements DeptDAO {
    @Override
    public List<Dept> selectAll() throws DAOException {
        String sql ="select departid,departname,departdescp from tab_depatinfo";
        try {
            return this.queryAll(sql,new DeptMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Dept selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Dept dept) throws DAOException {
//        Connection con = JDBCUtil.getJdbcUtil().getCon();
//        String sql ="insert into tab_depatinfo values(null,?,?)";
//        try {
//            PreparedStatement preparedStatement=con.prepareStatement(sql);
//            preparedStatement.setString(1,dept.getDepartname());
//            preparedStatement.setString(2,dept.getDepartdescp());
//            int row =preparedStatement.executeUpdate();
//            return row>0;
//        } catch (SQLException e) {
//            throw new DAOException("添加出错");
//        }
        String sql ="insert into tab_depatinfo values(null,?,?)";
        Object obj[] ={dept.getDepartname(),dept.getDepartdescp()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_depatinfo where departid=?";

        try {
            return this.exeuteUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean upd(Dept dept) throws DAOException {
        String sql ="update tab_depatinfo set departname=?,departdescp=? where departid=?";
        Object obj[] ={dept.getDepartname(),dept.getDepartdescp(),dept.getDepartid()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
