package com.example.web138_project.entity;

public class MedicineSup {
    private int suid;
    private String supname;
    private String tel;
    private String email;
    private String address;
    private String supdesc;
    public MedicineSup() {
    }
    public MedicineSup(int suid, String supname, String tel, String email, String address, String supdesc) {
        this.suid = suid;
        this.supname = supname;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.supdesc = supdesc;
    }
    public int getSuid() {
        return suid;
    }
    public void setSuid(int suid) {
        this.suid = suid;
    }
    public String getSupname() {
        return supname;
    }
    public void setSupname(String supname) {
        this.supname = supname;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSupdesc() {
        return supdesc;
    }
    public void setSupdesc(String supdesc) {
        this.supdesc = supdesc;
    }
    @Override
    public String toString() {
        return this.supname ;
    }
}
