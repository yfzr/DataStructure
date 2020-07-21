package com.gaohuan.javalearn.variable;

/**
 * 要点：final常量【final修饰变量】、类常量【static final修饰类的属性】
 * 注意：
 *      1、final修饰后，变量一旦赋值，就不能更改了
 *      2、类变量必须在创建时初始化，不能先定义，后赋值
 * @author gaoh28
 */
public class Constants {
    //类常量【必须在创建时初始化，否则报错】
    public static final double AGE_GH = 28;

    public static void main(String[] args) {
        //final常量
        final double AGE_ONE;
        //final常量可以先定义后赋值
        AGE_ONE = 1.0;
        System.out.println("高欢的身份证年龄："+(AGE_GH+AGE_ONE)+"岁！");
        System.out.println("高欢的实际年龄："+AGE_GH+"岁。");

        //试着修改final修饰的变量，IDEA马上显示红色下划线，提示错误
//        AGE_ONE = 2;
//        AGE_GH = 3;
    }
}
