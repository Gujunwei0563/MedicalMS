package com.example.web138_project.comm.factory;

import com.example.web138_project.comm.anno.AutoWired;
import com.example.web138_project.comm.anno.Respository;
import com.example.web138_project.comm.anno.Service;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class BeanFactory {
    private static Map<Class,Object> map = new HashMap<>();
    static{
        //获取所有的注解信息
        Set<Class<?>> allBeans = new LinkedHashSet<>();
        //获取反射工具包
        Reflections reflections = new Reflections("com.example.web138_project");
        //获取dao层的注解
       Set<Class<?>> daoCls=reflections.getTypesAnnotatedWith(Respository.class);
       //获取service层的注解
        Set<Class<?>> serviceCls=reflections.getTypesAnnotatedWith(Service.class);
        //集合合并
        allBeans.addAll(daoCls);
        allBeans.addAll(serviceCls);
        //控制反转 IOC  原先 程序员创建 现在是工厂类创建对象
        //创建对象
        allBeans.forEach(beanCls->{
            //通过反射创建
            try {
                Object instance = beanCls.newInstance();
                //获取接口 dao  service
                Class<?>[] interfaces = beanCls.getInterfaces();
                Class key = beanCls;
                if(interfaces!=null&& interfaces.length>0){
                    key = interfaces[0];
                }
                //存入map
                map.put(key,instance);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
//        System.out.println(map);
        //依赖注入
        map.values().stream().forEach(beanInstance->{
            //集合中对应的Class,每一个Class中的Field有没有autowired注解
            Stream.of(beanInstance.getClass().getDeclaredFields()).
                    filter(field->field.getAnnotation(AutoWired.class)!=null).forEach(field->{
                //设置属性可访问
                field.setAccessible(true);
                //获取属性的类  键值
               Class<?> fieldCls = field.getType();
               //获取对象
               Object fieldInstance = map.get(fieldCls);
               //通过反射给属性赋值
                        try {
                            field.set(beanInstance,fieldInstance);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    });

        });
    }
    //根据键值，获取创建的对象
    public static<T> T getBean(Class<T> interCls){
        Object obj = map.get(interCls);
        return (T)obj;
    }
}
