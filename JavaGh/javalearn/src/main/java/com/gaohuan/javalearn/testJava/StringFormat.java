package com.gaohuan.javalearn.testJava;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/24 16:42
 */
public class StringFormat {

    public static final String GAO = "高%s";//%s是占位符，用以拼接后面的字符串

    public static void main(String[] args) {
        System.out.println(String.format(GAO,"欢"));
    }
}
