package com.example.web138_project.entity;

public class Medicine {
    private int drugid;
    private String drugname;
    private int drugtype;
    private String drugunit;
    private int support;
    private String productdate;
    private String effectdate;
    private int stock;
    private int purchaseprice;
    private int price;
    private String descp;

    public Medicine() {
    }

    public Medicine(int drugid, String drugname, int drugtype, String drugunit, int support, String productdate, String effectdate, int stock, int purchaseprice, int price, String descp) {
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
        return "Medicine{" +
                "drugid=" + drugid +
                ", drugname='" + drugname + '\'' +
                ", drugtype=" + drugtype +
                ", drugunit='" + drugunit + '\'' +
                ", support=" + support +
                ", productdate='" + productdate + '\'' +
                ", effectdate='" + effectdate + '\'' +
                ", stock=" + stock +
                ", purchaseprice=" + purchaseprice +
                ", price=" + price +
                ", descp='" + descp + '\'' +
                '}';
    }
}
