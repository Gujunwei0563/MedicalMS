package com.example.web138_project.comm.exception;

import com.example.web138_project.comm.dao.BaseDAO;

public class ServiceException extends Exception {
    public ServiceException(String msg){
        super(msg);
    }
}
