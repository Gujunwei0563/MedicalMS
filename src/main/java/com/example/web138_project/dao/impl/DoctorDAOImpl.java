package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.DoctorDAO;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.dao.mapper.DoctorMapper;
import com.example.web138_project.entity.Doctor;
import com.example.web138_project.vo.DoctorVo;
import com.example.web138_project.vo.mapper.DoctorVoMapper;
import java.util.List;
import java.util.Map;
@Respository
public class DoctorDAOImpl extends MyJDBCTemplate implements DoctorDAO {

    @Override
    public List<Doctor> selectAll() throws DAOException {
       String sql ="select * from tab_doctor";
        try {
            return this.queryAll(sql,new DoctorMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Doctor selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Doctor doctor) throws DAOException {
        String sql ="insert into tab_doctor values(?,?,?,?,?,?,?,?)";
        Object obj[] ={doctor.getDid(),doctor.getName(),doctor.getGender(),doctor.getBirthday(),doctor.getJoid()
                ,doctor.getDeid(),doctor.getEdid(),doctor.getIconimg()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        String sql ="delete from tab_doctor where did=?";
        try {
            return this.exeuteUpd(sql, id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public boolean upd(Doctor doctor) throws DAOException {
        String sql ="update tab_doctor set name=?,gender=?,birthday=?,joid=?,deid=?,edid=?,iconimg=? where did=?";
        Object obj[] ={doctor.getName(),doctor.getGender(),
                doctor.getBirthday(),doctor.getJoid(),doctor.getDeid(),doctor.getEdid(),
                doctor.getIconimg(),doctor.getDid()};
        try {
            return this.exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public int addDoctorInfo(Doctor doctor) throws DAOException {
        return 0;
    }

    @Override
    public List<DoctorVo> listDocInfo() throws DAOException {
        String sql ="select * from docView";
//        select d.did,l.loginname,l.pass,l.roleid,d.`name`,d.gender,d.birthday,d.joid,j.jobname,d.deid,d1.departname,d.edid,e.ename,r.rname
        try {
            return this.queryAll(sql,new DoctorVoMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<DoctorVo> listRecPage(Map<String, String> map) throws DAOException{
        String sql= """
                select
                d.did,l.loginname,l.pass,l.roleid,d.name,d.gender,d.birthday,d.joid,j.jobname,
                d.deid,d1.departname,d.edid,e.ename,r.rname,d.iconimg
                from
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
                on l.roleid = r.rid where 1=1
                """;

        try {
            return this.listPage(sql,new DoctorVoMapper(),map);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public DoctorVo selectInfoById(int id) throws DAOException {
        String sql= """
                select
                d.did,l.loginname,l.pass,l.roleid,d.name,d.gender,d.birthday,d.joid,j.jobname,
                d.deid,d1.departname,d.edid,e.ename,r.rname,d.iconimg
                from
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
                on l.roleid = r.rid where 1=1 and did = ?
                """;
        try {
            return this.queryOne(sql,new DoctorVoMapper(),id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<DoctorVo> selectDocNameById(int id) throws DAOException {
        String sql= """
                select
                *
                from
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
                on l.roleid = r.rid where 1=1 and deid = ?
                """;
        try {
            return this.queryAll(sql,new DoctorVoMapper(),id);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
    @Override
    public int countRec(Map<String, String> map) throws DAOException {
        String sql= """
                select
                count(d.did) as num
                from
                tab_doctor d
                left join tab_login l
                on d.did=l.id
                inner join tab_jobinfo j
                on d.joid=j.jobid
                inner join tab_depatinfo d1
                on d.did = d1.departid
                inner join tab_educationinfo e
                on d.edid = e.eid
                inner join tab_role r
                on l.roleid =r.rid
                where 1=1
                 """;
        try {
            return this.count(sql,map);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
