package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.AdminDAO;
import com.example.web138_project.entity.Admin;
import com.example.web138_project.vo.AdminVo;
import com.example.web138_project.vo.mapper.AdminVoMapper;

import java.util.List;
@Respository
public class AdminDAOImpl extends MyJDBCTemplate implements AdminDAO {
    @Override
    public List<Admin> selectAll() throws DAOException {
        return null;
    }

    @Override
    public Admin selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Admin admin) throws DAOException {
        String sql = "insert into " +
                "tab_admin(aid,aname,gender,tel,email,webchat,qq,iconimg) " +
                "values(?,?,?,?,?,?,?,?)";
        try {
            return exeuteUpd(sql,admin.getAid(),admin.getAname(),
                    admin.getGender(),admin.getTel(),admin.getEmail(),
                    admin.getWebchat(),admin.getQq(),admin.getIconimg());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
    @Override
    public boolean del(int id) throws DAOException {
        return false;
    }



    @Override
    public boolean upd(Admin admin) throws DAOException {
        return false;
    }

    @Override
    public List<AdminVo> listAdminInfo() throws DAOException {
        String sql = """
                SELECT
                a.aid,l.loginname,l.pass,l.roleid,a.aname,a.gender,a.tel,a.email,a.webchat,a.qq,r.rname,a.iconimg
                from tab_admin a
                left join tab_login l
                on a.aid = l.id
                inner join tab_role r
                on l.roleid = r.rid
                """;
        try {
            return this.queryAll(sql,new AdminVoMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
