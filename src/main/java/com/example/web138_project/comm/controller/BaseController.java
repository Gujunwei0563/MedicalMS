package com.example.web138_project.comm.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseController {

    public void  colToPro (Class<?> clazz ){

        Field [] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            if (TableColumn.class.isAssignableFrom(field.getType()  )){
                field.setAccessible(true);
                try {
                    TableColumn<?,?> column = (TableColumn<?,?>)field.get(this);
                    String fieldName= field.getName();
                    if (fieldName.endsWith("Col")){
                        String proname =fieldName.substring(0,fieldName.length()-3);
                        Constructor<PropertyValueFactory> constructor =PropertyValueFactory.class.getConstructor(String.class);
                        PropertyValueFactory obj =constructor .newInstance(proname);
                        Method setCellValueFactory = TableColumn.class.getMethod("setCellValueFactory", Callback.class);
                        setCellValueFactory.invoke(column,obj);
                    }
                 } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
