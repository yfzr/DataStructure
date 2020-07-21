package com.gaohuan.javalearn.createString;

/**
 * 字符串构造器创建字符串
 * @author gaoh28
 * @version 1.0
 * @date 2020/3/25 9:06
 */
public class CreateString {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();//构造一个空的字符串构造对象
        builder.append("gaohuan");
        builder.append(" love");
        String temp = builder.toString();
        builder.append(" lidan");
        /**
         * output:
         * gaohuan love lidan
         * gaohuan love
         * 形象解释：builder就像一个字符串收集器，
         * 其toString方法就是把当前builder中所有的字符串取出来给字符串对象temp，
         * 后续builder可继续收集字符串，而temp中的值和原先不变
         */
        System.out.println(builder);
        System.out.println(temp);
    }
}
