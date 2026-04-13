package com.example.web138_project.vo;

public class PatientVo {
    private int age;
    private int reid ;
    private String loginname ;

    private int patientid ;
    private String pname ;
    private String gender ;
    private String birthday ;
    private String idcard ;
    private String phone ;
    private int isdel ;
    private String createtime ;
    private int doctorid ;
    private  String name ;
    private int deptid;
    private String departname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PatientVo() {
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public PatientVo(int reid, String loginname, int patientid, String pname, String gender, String birthday, String idcard, String phone, int isdel, String createtime, int doctorid, String name, int deptid, String departname) {
        this.reid = reid;
        this.loginname = loginname;
        this.patientid = patientid;
        this.pname = pname;
        this.gender = gender;
        this.birthday = birthday;
        this.idcard = idcard;
        this.phone = phone;
        this.isdel = isdel;
        this.createtime = createtime;
        this.doctorid = doctorid;
        this.name = name;
        this.deptid = deptid;
        this.departname = departname;
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
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


    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    @Override
    public String toString() {
        return pname;
    }
}
