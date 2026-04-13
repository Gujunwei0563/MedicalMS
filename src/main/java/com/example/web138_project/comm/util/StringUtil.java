package com.example.web138_project.comm.util;

public class StringUtil {

    public static boolean isNumber(String str){
         return str.matches("^[1-9]\\d*");
    }
    public static boolean isChi(String str){
        return str.matches("[\\u4e00-\\u9fa5]{1,}");
    }
    public static boolean isGen(String str){
        return str.matches("男|女");
    }
    public static boolean isPhone(String str){
        return str.matches("0?(13|14|15|18|17|16|19)[0-9]{9}");
    }

    public static boolean isEmail(String str){
        return str.matches("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
    }
    public static boolean idName(String str){
        return str.matches("^[A-Za-z]\\w{3,}|[\\u4e00-\\u9fa5]{2,}");
    }
}
