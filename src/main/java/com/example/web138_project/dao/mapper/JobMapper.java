package com.example.web138_project.dao.mapper;

import com.example.web138_project.comm.dao.RowMapper;
import com.example.web138_project.entity.Job;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobMapper implements RowMapper<Job> {
    @Override
    public Job mapperRow(ResultSet rst) {
            Job job =new Job();
        try {
            job.setJobid(rst.getInt("jobid"));
            job.setJobname(rst.getString("jobname"));
            job.setJobdescp(rst.getString("jobdescp"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return job;
    }
}
