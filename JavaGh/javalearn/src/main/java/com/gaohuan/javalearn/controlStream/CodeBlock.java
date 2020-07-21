package com.gaohuan.javalearn.controlStream;

/**
 * 代码块
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/8 15:58
 */
public class CodeBlock {
    //代码块，block。用一对大括号括起来的若干条简单语句。
    //块确定了变量的作用域。
    public static void main(String[] args) {
        int i = 2;//i的作用域为整个main函数代码块
        {
//            int i = 2;//不能在嵌套的两个代码块中声明同名的变量
            //在嵌套的两个代码块中声明两个同名的变量时，相对于大代码块中的变量，小代码块中的对应同名变量显然重复了
            int j=1;
            System.out.println(i+j);
        }//j的作用域仅在该代码块内部
//        System.out.println(j);//超出j的作用域，报错
        System.out.println(i);
        {
            //两个不同的代码块可以定义同名的变量
            int j =4;
            System.out.println(j);
        }
        System.out.println(i);
    }
}
