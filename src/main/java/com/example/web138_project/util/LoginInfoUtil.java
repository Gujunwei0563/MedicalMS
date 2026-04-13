package com.example.web138_project.util;

import java.util.Map;

public class LoginInfoUtil {
    private static ThreadLocal<Map<Integer,Object>> local=new ThreadLocal();
    public static void setLogin(Map<Integer,Object> map) {
        local.set(map);
    }
    public static Map<Integer,Object> getLogin() {
        return local.get();
    }
}
