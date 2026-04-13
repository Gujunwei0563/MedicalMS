package com.example.web138_project.util;

import com.example.web138_project.vo.DoctorVo;
import com.example.web138_project.vo.MedAddVo;
import com.example.web138_project.vo.MedicineVo;

import java.util.Map;

public class MedicineVoInfoUtil {
    private static ThreadLocal<Map<Integer, MedAddVo>> local =new ThreadLocal<>();
    public static void set(Map<Integer, MedAddVo> map)
    {
        local.set(map);
    }
    public static Map<Integer, MedAddVo> get()
    {
        return local.get();
    }
}
