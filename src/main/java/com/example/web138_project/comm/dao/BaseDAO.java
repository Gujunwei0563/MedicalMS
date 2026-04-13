package com.example.web138_project.comm.dao;
import com.example.web138_project.comm.exception.DAOException;
import java.util.List;
import java.util.Map;
public interface BaseDAO <T>{
    List<T> selectAll() throws DAOException;
    T selectById(int id) throws DAOException;
     boolean add(T t) throws DAOException;
    boolean del(int id) throws DAOException;

    boolean upd(T t) throws DAOException;
    default int countRec (Map<String ,String> map)throws DAOException{
        return 0;
    }
    default  List<T> selectByCondPage(Map<String ,String > map ) throws DAOException {
        return  null;
    }
}
