package com.example.web138_project.vo.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.vo.MedicineVo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineVoMapper implements RowMapper<MedicineVo> {
    @Override
    public MedicineVo mapperRow(ResultSet rst) {
        MedicineVo vo = new MedicineVo();
        try {
            vo.setDrugid(rst.getInt("drugid"));
            vo.setDrugname(rst.getString("drugname"));
            vo.setDrugtype(rst.getString("drugtype"));
            vo.setDrugunit(rst.getString("drugunit"));
            vo.setSupport(rst.getString("support"));
            vo.setProductdate(rst.getString("productdate"));
            vo.setEffectdate(rst.getString("effectdate"));
            vo.setStock(rst.getString("stock"));
            vo.setPurchaseprice(rst.getString("purchaseprice"));
            vo.setPrice(rst.getString("price"));
            vo.setDescp(rst.getString("descp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vo;
    }
}
