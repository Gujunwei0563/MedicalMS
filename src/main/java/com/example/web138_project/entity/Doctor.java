package com.example.web138_project.entity;

import java.util.SplittableRandom;

public class Doctor {
    private int did;
    private String name;
    private String gender;
    private String birthday;
    private int joid;
    private int edid;
    private int deid;
    private String iconimg;

    public Doctor(int did, String name, String gender, String birthday, int joid, int edid, int deid, String iconimg) {
        this.did = did;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.joid = joid;
        this.edid = edid;
        this.deid = deid;
        this.iconimg = iconimg;
    }

    public Doctor() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getJoid() {
        return joid;
    }

    public void setJoid(int joid) {
        this.joid = joid;
    }

    public int getEdid() {
        return edid;
    }

    public void setEdid(int edid) {
        this.edid = edid;
    }

    public int getDeid() {
        return deid;
    }

    public void setDeid(int deid) {
        this.deid = deid;
    }

    public String getIconimg() {
        return iconimg;
    }

    public void setIconimg(String iconimg) {
        this.iconimg = iconimg;
    }

    @Override
    public String toString() {
        return name+"医生" ;
    }
}
