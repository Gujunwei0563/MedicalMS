package com.example.web138_project.vo;

public class MedAddVo {
    private int drugid;
    private String drugname;
    private int drugtype;
    private String cname;
    private String drugunit;
    private int  support;
    private String supname;
    private String productdate;
    private String effectdate;
    private int usedate;
    private int stock;
    private int purchaseprice;
    private int price;
    private String descp;

    public MedAddVo() {
    }

    public MedAddVo(int drugid, String drugname, int drugtype, String cname, String drugunit, int support, String supname, String productdate, String effectdate, int usedate, int stock, int purchaseprice, int price, String descp) {
        this.drugid = drugid;
        this.drugname = drugname;
        this.drugtype = drugtype;
        this.cname = cname;
        this.drugunit = drugunit;
        this.support = support;
        this.supname = supname;
        this.productdate = productdate;
        this.effectdate = effectdate;
        this.usedate = usedate;
        this.stock = stock;
        this.purchaseprice = purchaseprice;
        this.price = price;
        this.descp = descp;
    }

    public int getDrugid() {
        return drugid;
    }

    public void setDrugid(int drugid) {
        this.drugid = drugid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public int getDrugtype() {
        return drugtype;
    }

    public void setDrugtype(int drugtype) {
        this.drugtype = drugtype;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDrugunit() {
        return drugunit;
    }

    public void setDrugunit(String drugunit) {
        this.drugunit = drugunit;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getProductdate() {
        return productdate;
    }

    public void setProductdate(String productdate) {
        this.productdate = productdate;
    }

    public String getEffectdate() {
        return effectdate;
    }

    public void setEffectdate(String effectdate) {
        this.effectdate = effectdate;
    }

    public int getUsedate() {
        return usedate;
    }

    public void setUsedate(int usedate) {
        this.usedate = usedate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(int purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    @Override
    public String toString() {
        return drugid+"  "+drugname+"  "+price+ "  "+stock;
    }
}
