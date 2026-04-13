package com.example.web138_project.vo.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.vo.MedAddVo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedAddMapper implements RowMapper<MedAddVo> {

    @Override
    public MedAddVo mapperRow(ResultSet rst) {
        MedAddVo medAddVo = new MedAddVo();
            try {
                medAddVo.setDrugid(rst.getInt("drugid"));
                medAddVo.setDrugname(rst.getString("drugname"));
                medAddVo.setDrugtype(rst.getInt("drugtype"));
                medAddVo.setCname(rst.getString("cname"));
                medAddVo.setDrugunit(rst.getString("drugunit"));
                medAddVo.setSupport(rst.getInt("support"));
                medAddVo.setSupname(rst.getString("supname"));
                medAddVo.setProductdate(rst.getString("productdate"));
                medAddVo.setEffectdate(rst.getString("effectdate"));
                medAddVo.setUsedate(rst.getInt("usedate"));
                medAddVo.setStock(rst.getInt("stock"));
                medAddVo.setPurchaseprice(rst.getInt("purchaseprice"));
                medAddVo.setPrice(rst.getInt("price"));
                medAddVo.setDescp(rst.getString("descp"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
          return  medAddVo;
    }
}
