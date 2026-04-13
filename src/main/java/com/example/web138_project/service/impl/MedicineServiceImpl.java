package com.example.web138_project.service.impl;

import com.example.web138_project.comm.anno.AutoWired;
import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.exception.DAOException;
import com.example.web138_project.comm.exception.ServiceException;
import com.example.web138_project.dao.DeptDAO;
import com.example.web138_project.dao.MedSupDAO;
import com.example.web138_project.dao.MedTypeDAO;
import com.example.web138_project.dao.MedicineDAO;
import com.example.web138_project.dao.impl.DeptDAOImpl;
import com.example.web138_project.dao.impl.MedDAOImpl;
import com.example.web138_project.dao.impl.MedSupDAOImpl;
import com.example.web138_project.dao.impl.MedTypeDAOImpl;
import com.example.web138_project.entity.Medicine;
import com.example.web138_project.entity.MedicineSup;
import com.example.web138_project.entity.MedicineType;
import com.example.web138_project.service.MedicineService;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;

import java.util.List;
import java.util.Map;

@Respository
public class MedicineServiceImpl implements MedicineService {
    @AutoWired
    private MedTypeDAO medTypeDAO ;
    @AutoWired
    private MedSupDAO medSupDAO ;
    MedicineDAO medicineDAO = new MedDAOImpl();
    @Override
    public List<MedicineType> findMedicineTypeAll() throws ServiceException {
        try {
            return medTypeDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<MedicineSup> findMedicineSupAll() throws ServiceException {
        try {
            return medSupDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<MedAddVo> findMedicineVoAll() throws ServiceException {
        try {
            return medicineDAO.listMedVoInfo();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<MedAddVo> findMedicineVoByWord(String word) throws ServiceException {
        try {
            return medicineDAO.listMedVoInfoByWord(word);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public boolean addSup(MedicineSup medicineSup) throws ServiceException {
        try {
           return medSupDAO.add(medicineSup);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public boolean delSup(int id) throws ServiceException {
        return false;
    }
    @Override
    public boolean addType(MedicineType medicineType) throws ServiceException {
        try {
            return medTypeDAO.add(medicineType);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public boolean delType(int id) throws ServiceException {
        return false;
    }

    @Override
    public boolean addMedicine(Medicine medicine) throws ServiceException {
        try {
            return medicineDAO.add(medicine);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countInfo(Map<String, String> map) throws ServiceException {
        try {
            return medicineDAO.countRec(map);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<MedAddVo> findPage(Map<String, String> map) throws ServiceException {
        //将page 当前页转换为offset -->传递到DAO层
        int page =0;
        int size=0;
        if (map.containsKey("page")){
            page=Integer.parseInt(map.get("page"));
            map.remove("page");
        }
        if (map.containsKey("size")){
            size=Integer.parseInt(map.get("size"));
        }
        //偏移值
        int offset =(page-1)*size;
        map.put("offset",String.valueOf(offset));
        try {
            return medicineDAO.listRecPage(map);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean delMedAddVo(int drugid) throws ServiceException {
        try {
            return medicineDAO.delMedAddVo(drugid);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean updMedicine(MedAddVo medaddVo) throws ServiceException {

        try {
            return medicineDAO.updMedicine(medaddVo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
