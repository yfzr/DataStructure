package com.gaohuan.javalearn.dataStructure;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/7/20 10:49
 */
public class LinkedListGH {
    public static void main(String[] args) {
//        LinkedList<String> linkedList = new LinkedList<>();
//        System.out.println("添加元素前====>");
//        System.out.println(linkedList.toString());
//        linkedList.add("addElement");//添加
//        System.out.println("添加元素后====>");
//        System.out.println(linkedList.toString());
//        //按索引修改
//        linkedList.set(0,"高欢");//修改【有索引作为指示】
//        System.out.println("修改元素后====>");
//        System.out.println(linkedList.toString());
//        //按值修改
//        //System.out.println(linkedList.indexOf("哈哈"));//list中不存在的元素返回索引为-1
//        Integer index = linkedList.indexOf("高欢");
//        if (index!=-1) {
//            linkedList.set(index,"家庭");
//        }
        LocalDateTime dateTime = LocalDateTime.parse("1970-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);
        System.out.println(LocalDateTime.parse("1999-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        System.out.println(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
//        System.out.println(LocalDateTime.now());
    }
}
