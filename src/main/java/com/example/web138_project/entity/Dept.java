package com.example.web138_project.entity;

public class Dept {
    private int departid;
    private String departname;
    private String departdescp;
    public Dept(){

    }

    public Dept(int departid, String departname, String departdescp) {
        this.departid = departid;
        this.departname = departname;
        this.departdescp = departdescp;
    }

    public int getDepartid() {
        return departid;
    }

    public void setDepartid(int departid) {
        this.departid = departid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getDepartdescp() {
        return departdescp;
    }

    public void setDepartdescp(String departdescp) {
        this.departdescp = departdescp;
    }

    @Override
    public String toString() {
        return this.departname;
    }
}
