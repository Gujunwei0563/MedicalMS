package com.example.web138_project.entity;

import com.example.web138_project.comm.exception.DAOException;

public class Education {
    private int eid;
    private String ename;
    private String edescp;
    public Education() {
    }
    public Education(int eid, String ename, String edescp) {
        this.eid = eid;
        this.ename = ename;
        this.edescp = edescp;
    }
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getEdescp() {
        return edescp;
    }
    public void setEdescp(String edescp) {
        this.edescp = edescp;
    }

    @Override
    public String toString() {
        return this.ename;
    }
}
