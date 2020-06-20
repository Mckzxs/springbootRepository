package com.example.service;

import io.netty.util.collection.CharCollections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Atest {
    public static void main(String[] args) throws Exception {
        StudentService studentService = new StudentService();
        Class<StudentService> st = StudentService.class;
        Constructor<StudentService> declaredConstructor = st.getDeclaredConstructor();
        StudentService studentService1 = declaredConstructor.newInstance();
        Date date = new Date();
        System.out.println("系统此刻时间"+date.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss EEE a");
        String format = simpleDateFormat.format(date);
        System.out.println("格式后的时间"+format);

/**

        // 面试题：已知一个时间是 2019-07-01 10:40:01
        // 请问 1天 2小时，21分后的时间是多少。
        //已知时间
        //String timeStr="2019/07/01 10:40:01";
        String timeStr="2019/07/01 10:40:01";

        //格式要与字符串存储的已知时间格式一样
        //SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:ss:mm");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //解析已知时间
        //Date d = simpleDateFormat1.parse(timeStr);
        Date date1 = simpleDateFormat1.parse(timeStr);
        //已知时间的毫秒值
        //long time = d.getTime();
        long time = date1.getTime();

        //1天 2小时，21分后的时间毫秒值
        //time+=(26*60+21)*60*1000;
        time+=(26*60+21)*60*1000;
        //System.out.println("1天 2小时，21分后的时间是  "+simpleDateFormat1.format(time));
        System.out.println(simpleDateFormat1.format(time));
 *
 */
        HashMap<String, String> map = new HashMap<>();
        map.put("K","Y");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("string");
        Map<String, String> map1 = Collections.synchronizedMap(map);


    }
}
