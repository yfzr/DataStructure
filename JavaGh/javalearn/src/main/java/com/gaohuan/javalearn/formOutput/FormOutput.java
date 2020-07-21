package com.gaohuan.javalearn.formOutput;

import java.util.Date;

/**
 * 格式化输出
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/8 9:20
 */
public class FormOutput {
    public static void main(String[] args) {
        double x = 1000/3.0;
        System.out.print(x);//输出不换行
        System.out.println();//换行
        System.out.printf("Hello, %s, Next year, you'll be %d years old.","高欢",29);//格式化输出，不换行
        System.out.println();//换行
        System.out.println(new Date());
    }

    public static void outputMyName(String name) {
        System.out.printf("我的名字叫%s！",name);
        System.out.println();//换行
    }
}
