package com.gaohuan.javalearn.ailiyun;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/24 15:01
 */
public class AliyunQuestion1 {
    static int i;//java的static只能出现在类关于属性的定义中，不能出现在方法中
    static Integer i1;
    public int aMethod() {
        i=0;//
        i++;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(AliyunQuestion1.i1);//Integer默认值为null
        System.out.println(AliyunQuestion1.i);//静态int属性i的初始值默认为1
        AliyunQuestion1 question1 = new AliyunQuestion1();
        question1.aMethod();//对象调用方法，更改了静态属性i，此时i的值为1
        System.out.println(AliyunQuestion1.i);
        int j=question1.aMethod();
        System.out.println(j);
    }
}
