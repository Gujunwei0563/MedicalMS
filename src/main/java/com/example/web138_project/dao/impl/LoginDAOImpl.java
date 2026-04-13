package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.LoginDAO;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.dao.mapper.LoginMapper;
import com.example.web138_project.entity.Login;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.DoctorVo;
import com.example.web138_project.vo.mapper.AdminVoMapper;
import com.example.web138_project.vo.mapper.DoctorVoMapper;

import java.util.List;
@Respository
public class LoginDAOImpl extends MyJDBCTemplate implements LoginDAO {
    @Override
    public List<Login> selectAll() throws DAOException {
        return null;
    }

    @Override
    public Login selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Login login) throws DAOException {
        return false;
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_login where id=?";
        try {
            return this.exeuteUpd(sql,id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean upd(Login login) throws DAOException {
        return false;
    }

    @Override
    public int addLoginInfo(Login login) throws DAOException{
        String sql ="insert into tab_login values (null,?,'8888',?,0)";
        try {
            return this.insertRecord(sql,login.getLoginname(),login.getRoleid());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean checkLoginName(String name) throws DAOException {
        String sql ="select id,loginname,pass,roleid,islogin from tab_login where loginname=?";
        try {
            Login login =this.queryOne(sql,new LoginMapper(),name);
            if (login==null){
                return  true;
            }else {
                throw new DAOException("登录名重复");
            }
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public AdminVo loginAdmin(String name, String pass) throws DAOException {
        String sql = """
                SELECT
                a.aid,l.loginname,l.pass,l.roleid,a.aname,a.gender,a.tel,a.email,a.webchat,a.qq,r.rname,a.iconimg
                from tab_admin a
                left join tab_login l
                on a.aid = l.id
                inner join tab_role r
                on l.roleid = r.rid
                where l.loginname = ? and pass=?
                """;
        Object [] obj = {name,pass};
        try {
            return this.queryOne(sql,new AdminVoMapper(),obj);
        } catch (DataException e) {
            throw new DAOException("管理员登录失败");
        }
    }

    @Override
    public DoctorVo loginDoctor(String name, String pass) throws DAOException {
        String sql = """
                select
                d.did,l.loginname,l.pass,l.roleid,d.name,d.gender,d.birthday,d.joid,j.jobname,
                d.deid,d1.departname,d.edid,e.ename,r.rname,d.iconimg
                from\s
                tab_doctor d
                left join tab_login l
                on d.did = l.id
                inner join tab_jobinfo j
                on d.joid = j.jobid
                inner join tab_depatinfo d1
                on d.deid = d1.departid
                inner join tab_educationinfo e
                on d.edid = e.eid
                inner join tab_role r
                on l.roleid = r.rid
                where l.loginname = ? and pass = ?
                """;
        Object [] obj = {name,pass};
        try {
            return this.queryOne(sql,new DoctorVoMapper(),obj);
        } catch (DataException e) {
            throw new DAOException("医生登录失败");
        }
    }
}
