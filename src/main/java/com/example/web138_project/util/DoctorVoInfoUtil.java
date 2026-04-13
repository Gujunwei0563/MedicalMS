package com.example.web138_project.util;

import com.example.web138_project.vo.DoctorVo;

import java.util.Map;

public class DoctorVoInfoUtil {
    //1：跟新
    //2:查询
    private static ThreadLocal<Map<Integer, DoctorVo>> local =new ThreadLocal<>();
    public static void set(Map<Integer, DoctorVo> map)
    {
        local.set(map);
    }
    public static Map<Integer, DoctorVo> get()
    {
        return local.get();
    }
}
