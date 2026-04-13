package com.example.web138_project.entity;

import java.time.LocalDate;

public class Patient {
    private int patientid;
    private String pname;
    private String gender;
    private String birthday;
    private String idcard;
    private String phone;
    private int isdel;

    private String createtime;

    public Patient() {
    }

    public Patient(int patientid, String pname, String gender, String birthday, String idcard, String phone, int isdel, String createtime) {
        this.patientid = patientid;
        this.pname = pname;
        this.gender = gender;
        this.birthday = birthday;
        this.idcard = idcard;
        this.phone = phone;
        this.isdel = isdel;
        this.createtime = createtime;
    }




    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientid=" + patientid +
                ", pname='" + pname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idcard=" + idcard +
                ", phone='" + phone + '\'' +
                ", isdel=" + isdel +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
