package com.example.web138_project.entity;

public class MedicineType {
    private int cid;
    private String cname;
    private String cdescp;
    private String lastdate;
    public MedicineType() {
    }

    @Override
    public String toString() {
        return this.cname ;
    }

    public MedicineType(int cid, String cname, String cdescp, String lastdate) {
        this.cid = cid;
        this.cname = cname;
        this.cdescp = cdescp;
        this.lastdate = lastdate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdescp() {
        return cdescp;
    }

    public void setCdescp(String cdescp) {
        this.cdescp = cdescp;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }
}
