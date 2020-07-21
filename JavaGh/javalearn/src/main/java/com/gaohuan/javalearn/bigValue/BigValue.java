package com.gaohuan.javalearn.bigValue;

import com.gaohuan.javalearn.controlStream.Recycle;

import java.math.BigInteger;

/**
 * 测试Java中的大数值，java.math中的两个类：BigInteger和BigDecimal
 * 这两个类可以处理包含任意长度数字序列的数值
 * BigInteger类实现了任意精度的整数运算
 * BigDecimal实现了任意精度的浮点运算
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/10 9:30
 */
public class BigValue {
    //main方法是程序的入口，一个Java程序是从main方法开始执行
    //Java虚拟机在执行Java程序前会事先分配一个主线程，然后在主线程里面执行当前main方法
    //线程就是一个程序里面不同的执行路径
    public static void main(String[] args) {
//        Recycle.main(args);//由于Recycle的main方法是public static声明的，当前类可以直接调用它的main方法
        BigInteger a = BigInteger.valueOf(100);//使用静态的valueOf方法可以将普通的数值转换为大数值
        //大数值运算与普通数值运算不同，+和*的运算需要用add和multiply方法
        BigInteger b = BigInteger.valueOf(100);
        BigInteger c = a.add(b);//c=a+b
        BigInteger d = a.multiply(b.add(BigInteger.valueOf(2)));//d=a*(b+2)
        BigInteger f = d.divide(BigInteger.valueOf(2));//f=d/2
        BigInteger g = d.subtract(c);
        BigInteger h = g.mod(BigInteger.valueOf(3));
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c=a+b="+c);
        System.out.println("d=a*(b+2)="+d);
        System.out.println("f=d/2="+f);
        System.out.println("g=d-c="+g);
        System.out.println("h=g%3="+h);
        //BigDecimal与BigInteger类似，此处不再阐述
    }
}
