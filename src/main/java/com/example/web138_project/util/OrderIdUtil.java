package com.example.web138_project.util;

public class OrderIdUtil {
    private static ThreadLocal<Integer> local=new ThreadLocal<>();
    public static void setOrderId(int orderId){
        local.set(orderId);
    }
    public static int getOrderId(){
        return local.get();
    }
}
