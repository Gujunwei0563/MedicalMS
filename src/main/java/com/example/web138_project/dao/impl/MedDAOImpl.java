package com.example.web138_project.dao.impl;

import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.dao.MyJDBCTemplate;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.DataException;
import com.example.web138_project.dao.MedicineDAO;
import com.example.web138_project.entity.Medicine;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;
import com.example.web138_project.vo.mapper.MedAddMapper;
import com.example.web138_project.vo.mapper.MedicineVoMapper;

import java.util.List;
import java.util.Map;

@Respository
public class MedDAOImpl extends MyJDBCTemplate implements MedicineDAO {
    @Override
    public Medicine selectById(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Medicine medicine) throws DAOException {
      String sql="insert into tab_drug values(null,?,?,?,?,?,?,?,?,?,?)";
      Object obj[] ={medicine.getDrugname(),medicine.getDrugtype(),medicine.getDrugunit()
              ,medicine.getSupport(),medicine.getProductdate(),medicine.getEffectdate(),medicine.getStock(),
              medicine.getPurchaseprice(),medicine.getPrice(),medicine.getDescp()};
        try {
            return exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean del(int id) throws DAOException {
        return false;
    }

    @Override
    public boolean upd(Medicine medicine) throws DAOException {
        return false;
    }

    @Override
    public List<Medicine> selectAll() throws DAOException {

        return null;
    }

    @Override
    public List<MedAddVo> listMedVoInfo() throws DAOException {
        String sql= """
                select
                                     d.drugid,d.drugname,d.drugtype,d1.cname,d.drugunit,d.support,s.supname,d.productdate,
                                     d.effectdate,datediff(d.effectdate,d.productdate)/365 usedate,d.stock,d.purchaseprice,d.price,d.descp
                                     from
                                     tab_drug d
                                     inner join tab_drugtype d1\s
                                     on d.drugtype = d1.cid
                                     inner join tab_support s
                                     on d.support = s.suid
                """;
        try {
            return this.queryAll(sql, new MedAddMapper());
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<MedAddVo> listMedVoInfoByWord(String word) throws DAOException {
        String sql = """
                select
                d.drugid,d.drugname,d.drugtype,d1.cname,d.drugunit,d.support,s.supname,d.productdate,
                d.effectdate,datediff(d.effectdate,d.productdate)/365 usedate,d.stock,d.purchaseprice,d.price,d.descp
                from
                tab_drug d
                inner join tab_drugtype d1\s
                on d.drugtype = d1.cid
                inner join tab_support s
                on d.support = s.suid
                where d.drugname like ?
                """;
        Object obj[] ={"%" + word + "%"};
        try {
            return this.queryAll(sql, new MedAddMapper(),obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<MedAddVo> listRecPage(Map<String, String> map) throws DAOException {
        String sql = """
                select
                d.drugid,d.drugname,d.drugtype,d1.cname,d.drugunit,d.support,s.supname,d.productdate,
                d.effectdate,datediff(d.effectdate,d.productdate)/365 usedate,d.stock,d.purchaseprice,d.price,d.descp
                from
                tab_drug d
                inner join tab_drugtype d1\s
                on d.drugtype = d1.cid
                inner join tab_support s
                on d.support = s.suid
                    """;
        try {
            return this.listPage(sql,new MedAddMapper(),map);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public boolean delMedAddVo(int drugid) throws DAOException {
        String sql = "delete from tab_drug where drugid=?";
        try {
            return exeuteUpd(sql,drugid);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean updMedicine(MedAddVo medAddVo) throws DAOException {
        String sql = """
              update
              tab_drug
              set
              drugname=?,drugtype=?,drugunit=?,support=?,productdate=?,effectdate=?,stock=?,purchaseprice=?,price=?,descp=?
              where
              drugid=?
               """;
        Object obj[] ={medAddVo.getDrugname(),medAddVo.getDrugtype(),medAddVo.getDrugunit(),medAddVo.getSupport(),
                medAddVo.getProductdate(),medAddVo.getEffectdate(),medAddVo.getStock(),medAddVo.getPurchaseprice(),
                medAddVo.getPrice(),medAddVo.getDescp(),medAddVo.getDrugid()};
        try {
            return exeuteUpd(sql,obj);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }

//    @Override
//    public boolean updMedicine(Medicine medicine) throws DAOException {
//        String sql = """
//              update
//              tab_drug
//              set
//              drugname=?,drugtype=?,drugunit=?,support=?,productdate=?,effectdate=?,stock=?,purchaseprice=?,price=?,descp=?
//              where
//              drugid=?
//               """;
//        Object obj[] ={medicine.getDrugname(),medicine.getDrugtype(),medicine.getDrugunit(),medicine.getSupport(),
//                medicine.getProductdate(),medicine.getEffectdate(),medicine.getStock(),medicine.getPurchaseprice(),
//                medicine.getPrice(),medicine.getDescp(),medicine.getDrugid()};
//        try {
//            return exeuteUpd(sql,obj);
//        } catch (DataException e) {
//            throw new DAOException(e.getMessage());
//        }
//    }


//    @Override
//    public boolean updMedicine(Medicine medicine) throws DAOException {
//        String sql = """
//                update
//                tab_drug
//                set
//                drugname=?,drugtype=?,drugunit=?,support=?,productdate=?,effectdate=?,stock=?,purchaseprice=?,price=?,descp=?
//                where
//                drugid=?
//                """;
//        Object obj[] ={medicine.getDrugname(),medicine.getDrugtype(),medicine.getDrugunit(),medicine.getSupport(),
//                medicine.getProductdate(),medicine.getEffectdate(),medicine.getStock(),medicine.getPurchaseprice(),
//                medicine.getPrice(),medicine.getDescp(),medicine.getDrugid()};
//        try {
//            return exeuteUpd(sql,obj);
//        } catch (DataException e) {
//            throw new DAOException(e.getMessage());
//        }
//    }

//    @Override
//    public boolean updMedAddVo(MedAddVo medAddVo) throws DAOException {
//        String sql = """
//                update
//                tab_drug
//                set
//                drugname=?,drugtype=?,drugunit=?,support=?,productdate=?,effectdate=?,stock=?,purchaseprice=?,price=?,descp=?
//                where
//                drugid=?
//                """;
//        Object obj[] ={medAddVo.getDrugname(),medAddVo.getDrugtype(),medAddVo.getDrugunit(),medAddVo.getSupport(),
//                medAddVo.getProductdate(),medAddVo.getEffectdate(),medAddVo.getStock(),medAddVo.getPurchaseprice(),
//                medAddVo.getPrice(),medAddVo.getDescp(),medAddVo.getDrugid()};
//        try {
//            return exeuteUpd(sql,obj);
//        } catch (DataException e) {
//            throw new DAOException(e.getMessage());
//        }
//    }

    @Override
    public int countRec(Map<String, String> map) throws DAOException {
        String sql = """
                select
                count(drugid) as num
                from
                tab_drug d
                inner join tab_drugtype d1\s
                on d.drugtype = d1.cid
                inner join tab_support s
                on d.support = s.suid
                """;
        try {
            return this.count(sql,map);
        } catch (DataException e) {
            throw new DAOException(e.getMessage());
        }
    }
}
