package com.example.web138_project.entity;

public class Registration {
    private  int reid;
    private  int patientid;
    private  int doctorid;
    private  int deptid ;
    private  String createtime;
    private  int status;

    public Registration(int reid, int patientid, int doctorid, int deptid, String createtime, int status) {
        this.reid = reid;
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.deptid = deptid;
        this.createtime = createtime;
        this.status = status;
    }

    public Registration() {
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "reid=" + reid +
                ", patientid=" + patientid +
                ", doctorid=" + doctorid +
                ", deptid=" + deptid +
                ", createtime='" + createtime + '\'' +
                ", status=" + status +
                '}';
    }
}
