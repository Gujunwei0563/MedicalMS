package com.example.web138_project.vo;

public class AdminVo {
    private int aid;
    private String loginName;
    private String pass;
    private int roleid;
    private String aname;
    private String gender;
    private String tel;
    private String email;
    private String webchat;
    private String qq;
    private String rname;
    private String iconimg;

    public AdminVo() {

    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebchat() {
        return webchat;
    }

    public void setWebchat(String webchat) {
        this.webchat = webchat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getIconimg() {
        return iconimg;
    }

    public void setIconimg(String iconimg) {
        this.iconimg = iconimg;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "aid=" + aid +
                ", loginName='" + loginName + '\'' +
                ", pass='" + pass + '\'' +
                ", roleid=" + roleid +
                ", aname='" + aname + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", webchat='" + webchat + '\'' +
                ", qq='" + qq + '\'' +
                ", rname='" + rname + '\'' +
                ", iconimg='" + iconimg + '\'' +
                '}';
    }
}
