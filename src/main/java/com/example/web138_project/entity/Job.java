package com.example.web138_project.entity;

public class Job {
    private int jobid;
    private String jobname;
    private String jobdescp;

    public Job() {
    }

    @Override
    public String toString() {
        return this.jobname;
    }

    public Job(int jobid, String jobname, String jobdescp) {
        this.jobid = jobid;
        this.jobname = jobname;
        this.jobdescp = jobdescp;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobdescp() {
        return jobdescp;
    }

    public void setJobdescp(String jobdescp) {
        this.jobdescp = jobdescp;
    }
}
