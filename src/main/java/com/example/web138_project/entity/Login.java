package com.example.web138_project.entity;

public class Login {
    private int id;
    private String loginname;
    private String pass;
    private int roleid;
    private int islogin;

    public Login() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
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

    public int getIslogin() {
        return islogin;
    }

    public void setIslogin(int islogin) {
        this.islogin = islogin;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", pass='" + pass + '\'' +
                ", roleid=" + roleid +
                ", islogin=" + islogin +
                '}';
    }
}
