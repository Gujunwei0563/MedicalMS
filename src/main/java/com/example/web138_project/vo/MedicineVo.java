package com.example.web138_project.vo;

public class MedicineVo {
  private int drugid;
  private String drugname;
  private String drugtype;
  private String drugunit;
  private String support;
  private String productdate;
  private String effectdate;
  private String stock;
  private String purchaseprice;
  private String price;
  private String descp;

    public MedicineVo(int drugid, String drugname, String drugtype, String drugunit, String support, String productdate, String effectdate, String stock, String purchaseprice, String price, String descp) {
        this.drugid = drugid;
        this.drugname = drugname;
        this.drugtype = drugtype;
        this.drugunit = drugunit;
        this.support = support;
        this.productdate = productdate;
        this.effectdate = effectdate;
        this.stock = stock;
        this.purchaseprice = purchaseprice;
        this.price = price;
        this.descp = descp;
    }

    public MedicineVo() {
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

    public String getDrugtype() {
        return drugtype;
    }

    public void setDrugtype(String drugtype) {
        this.drugtype = drugtype;
    }

    public String getDrugunit() {
        return drugunit;
    }

    public void setDrugunit(String drugunit) {
        this.drugunit = drugunit;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(String purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
        return "MedicineVo{" +
                "drugid=" + drugid +
                ", drugname='" + drugname + '\'' +
                ", drugtype='" + drugtype + '\'' +
                ", drugunit='" + drugunit + '\'' +
                ", support='" + support + '\'' +
                ", productdate='" + productdate + '\'' +
                ", effectdate='" + effectdate + '\'' +
                ", stock='" + stock + '\'' +
                ", purchaseprice='" + purchaseprice + '\'' +
                ", price='" + price + '\'' +
                ", descp='" + descp + '\'' +
                '}';
    }
}
