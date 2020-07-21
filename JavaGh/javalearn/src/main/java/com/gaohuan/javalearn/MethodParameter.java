package com.gaohuan.javalearn;

import java.util.ArrayList;
import java.util.List;

/**
 * java程序采用按值传递的方式调用参数
 *  1、不会修改基本数据类型的参数
 *  2、可以改变一个对象参数的状态
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/16 8:40
 */
public class MethodParameter {

    public static void doubleValue(double x) {
        x=2*x;
        System.out.println(x);
    }

    public static void tripleValue(Double x) {
        x=3*x;
        System.out.println(x.hashCode());
    }

    public static void addElement(List<Integer> list) {
        System.out.println(list.hashCode());
        list.add(2);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void modifyName(MethodParameter parameter) {
        parameter.setName("高欢");
        System.out.println(parameter);
        System.out.println(parameter.hashCode());
    }

    public static void main(String[] args) {

        /**
         *  一、局部变量存储在方法栈中
         * 　　　在方法中声明的变量，即该变量是局部变量，每当程序调用方法时，系统都会为该方法建立一个方法栈，其所在方法中声明的变量就放在方法栈中，当方法结束系统会释放方法栈，其对应在该方法中声明的变量随着栈的销毁而结束，这就局部变量只能在方法中有效的原因。在方法中声明的变量可以是基本类型的变量，也可以是引用类型的变量。
         *
         *          （1）当声明是基本类型的变量的时，其变量名及值（变量名及值是两个概念）是放在JAVA虚拟机栈中
         *
         *          （2）当声明的是引用变量时，所声明的变量（该变量实际上是在方法中存储的是内存地址值）是放在JAVA虚拟机的栈中，该变量所指向的对象是放在堆类存中的。
         *
         * 二、全局变量存储在堆中
         * 　　在类中声明的变量是成员变量，也叫全局变量，放在堆中的（因为全局变量不会随着某个方法执行结束而销毁）。同样在类中声明的变量即可是基本类型的变量 也可是引用类型的变量
         *
         *        （1）当声明的是基本类型的变量其变量名及其值放在堆内存中的
         *
         *        （2）引用类型时，其声明的变量仍然会存储一个内存地址值，该内存地址值指向所引用的对象。引用变量名和对应的对象仍然存储在相应的堆中
         */

        double y=1.0;
        doubleValue(y);
        System.out.println(y);//依然是1.0

        Double x=1.0;
        System.out.println(x.hashCode());
        tripleValue(x);//hashCode前后不一致，
        System.out.println(x);//依然是1.0

        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.hashCode());
        addElement(list);//hashCode前后一致
        System.out.println(list);

        MethodParameter parameter = new MethodParameter();
        System.out.println(parameter);
        System.out.println(parameter.hashCode());
        parameter.setName("未知");
        System.out.println(parameter.getName());
        modifyName(parameter);//hashCode前后一致
        System.out.println(parameter.getName());//不管是调用类的方法，还是重新写的Java语句，都可以更改对象的属性状态

        System.out.println("========================解释分界线==========================");
        /**
         * java是按值传递
         */
        System.out.println("基本数据类型【int，double，float，long，boolean】，按值传递相当于下述操作");
        int i1=2;
        int i2=i1;
        i2=i2*3;
        System.out.println(i1);
        System.out.println(i2);

        //Java封装类型
        List<String> nameList = new ArrayList<>();
        nameList.add("高欢");
        List<String> nameList_backup = nameList;
        nameList_backup.add("老婆");
        System.out.println(nameList);
        System.out.println(nameList_backup);

        //引用类型
        MethodParameter parameter1 = new MethodParameter();
        parameter1.setName("高欢");
        MethodParameter parameter2 = parameter1;
        parameter2.setName("老婆");
        System.out.println(parameter1.getName());
        System.out.println(parameter2.getName());
    }
}
