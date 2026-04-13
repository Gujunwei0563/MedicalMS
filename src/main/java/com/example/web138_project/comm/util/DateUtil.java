package com.example.web138_project.comm.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String showDate(){
        Calendar instance= Calendar.getInstance();
        int year = instance.get(Calendar.YEAR );
        int mon = instance.get(Calendar.MONTH)+1;
        int day = instance.get(Calendar.DATE);
        int hour = instance.get(Calendar.HOUR);
        int minute = instance.get(Calendar.MINUTE);
        int second = instance.get(Calendar.SECOND);
        return  year+"年"+mon+"月"+day+"日"+hour+"时"+minute+"分"+second+"秒";
    }
    public static String simpleDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return  simpleDateFormat.format(new Date());
    }

   public static LocalDate setDefaultDate(int year , int month, int date){
        return LocalDate.of(year,month,date);
   }
}
