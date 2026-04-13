package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.PatientDAO;
import com.example.web138_project.dao.mapper.PatientMapper;
import com.example.web138_project.entity.Patient;
import com.example.web138_project.vo.PatientVo;
import com.example.web138_project.vo.mapper.PatientVoMapper;

import java.util.List;
import java.util.stream.Stream;

@Respository
public class PatientDAOImpl extends MyJDBCTemplate implements PatientDAO {

    @Override
    public List<Patient> selectAll() throws DAOException {
        String sql ="select patientid,pname,gender,birthday,idcard,phone,isdel,createtime from tab_patient";
        try {
            return this.queryAll(sql,new PatientMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Patient selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Patient patient) throws DAOException {
        String sql ="insert into tab_patient(pname,gender,birthday,idcard,phone,isdel,createtime) values(?,?,?,?,?,0,now())";
        Object[] obj = {patient.getPname(), patient.getGender(), patient.getBirthday(),
                patient.getIdcard(), patient.getPhone()};
        try {
            return this.exeuteUpd(sql, obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        return false;
    }


    @Override
    public boolean upd(Patient patient) throws DAOException {
        return false;
    }

    @Override
    public Patient selectByIdcard(String idcard) throws DAOException {
        String sql ="select patientid,pname,gender,birthday,idcard,phone,isdel,createtime from tab_patient where idcard=?";
        try {
            return this.queryOne(sql,new PatientMapper(),idcard);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public int insertRecordPatient(Patient patient) throws DAOException {

        String sql ="insert into tab_patient(pname,gender,birthday,idcard,phone,isdel,createtime) values(?,?,?,?,?,0,now())";
        Object[] obj = {patient.getPname(), patient.getGender(), patient.getBirthday(),
                patient.getIdcard(), patient.getPhone()};
        try {
            return this.insertRecord(sql, obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean updateDel(int patId, int val) throws DAOException {
        String sql ="update tab_patient set isdel=? where patientid=?";
        try {
            return this.exeuteUpd(sql,val,patId);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
    @Override
    public List<PatientVo> selectPatByDocId(int docId) throws DAOException {
        //通过登录的医生id查询患者信息
        String sql = """
                select
                r.reid,l.loginname,p.patientid,p.pname,p.gender,p.birthday,datediff(NOW(),p.birthday)/365 age,p.idcard,p.phone,p.isdel,p.createtime,r.doctorid,
                d.name,r.deptid,d1.departname
                from
                tab_patient p
                inner join tab_registration r
                on r.patientid = p.patientid
                inner join tab_doctor d
                on d.did = r.doctorid
                inner join tab_depatinfo d1
                on r.deptid = d1.departid
                inner join tab_login l
                on d.did = l.id
                WHERE doctorid = ?
                """;
        try {
            return this.queryAll(sql,new PatientVoMapper(),docId);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public PatientVo selectPatByName(String name) throws DAOException {
        String sql = """
                select
                r.reid,l.loginname,p.patientid,p.pname,p.gender,p.birthday,datediff(NOW(),p.birthday)/365 age,p.idcard,p.phone,p.isdel,p.createtime,r.doctorid,
                d.name,r.deptid,d1.departname
                from
                tab_patient p
                inner join tab_registration r
                on r.patientid = p.patientid
                inner join tab_doctor d
                on d.did = r.doctorid
                inner join tab_depatinfo d1
                on r.deptid = d1.departid
                inner join tab_login l
                on d.did = l.id
                WHERE pname like ?
                """;
        try {
            return this.queryOne(sql,new PatientVoMapper(), name);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }


}
