package com.gaohuan.javalearn.classAndObject;

import java.util.Date;

/**
 * 使用类和对象
 * Java所有对象存储在堆中
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/13 14:00
 */
public class UseClassAndObject {
    /**
     * 对于基本类型数据来说：
     * 1) 局部变量
     * $范围：定义在一个方法内部的变量；
     * $作用域：其作用域为所在代码块，也称为临知时变量、栈变量；
     * $生命周期：从创建开始到方法（函数）结束为止；
     * $特点：在使用之前必须要对其初始化；
     * $一律存放道在栈中。
     * 2) 实例变量
     * $范围：定义在一个类内部但不在方法中的变量；
     * $作用域：其作用域为整个类，能够被操作的范围是类的内部；
     * $生命周期：对象被创建的时候开始，对象被垃圾回收的时间结束；
     * $特点：如未定义其初值，系统会自动对实例内变量进行默容认初始化（默认值为null），使用之前必须创建类的实例；
     * $每一个对象的实例变量的值是相互独立的；
     * $一律存放在堆中。
     * 对于复杂类型来说：
     * 引用存放在栈中，而其所指向的值存放在堆中。
     */
    private static Date globalVarDate;//全局变量

    public static void main(String[] args) {
        //使用类，即使用类的属性【类有哪些属性，如何初始化【set方法】，如何获取【get方法】】和方法【方法的功能【方法名】、输入参数和输出参数】，不用了解类内部的具体实现过程。
        //除了一些特别的类【例如Math类，只封装了功能，没有数据】，使用类一般是通过使用其实例化对象实现的。
        //要想使用对象，必须先通过类构造对象，并对其进行初始化
        //在Java中，使用构造器【constructor】来构造新实例。
        System.out.println("构造器是一种特殊的方法，用来构造并初始化对象。");
        //对于一些标准库工具类，提供了满足常用需求的方法和属性，如果开发者有特殊需求，可以继承这些Java提供的工具类，在自己的工具类中添加满足自己需求的内容。
        System.out.println("构造器的名字应该和类名保持一致。");
        //使用new操作符实例化类的对象
        //可以对象作为参数传给其他类的方法
        System.out.println(new Date());//输出当前日期时间
        //Date类表示的时间是用距离一个固定时间点的毫秒数表示的，这个时间点称为纪元【UTC时间1970年1月1日0点0分0秒】
        //也可以调用对象的方法，将对应方法的返回值赋值给别的对象
        String date = new Date().toString();//Date对象的toString方法返回日期的字符串形式，赋值给字符串date
        System.out.println(date);
        //为了使得构造的对象可以多次使用，需要将对象存放在一个变量中
        Date today = new Date();
        System.out.println(today);
        //对象与对象变量之间存在重要的区别，上述today是一个对象，下面定义一个对象变量
        Date today_new;//定义了一个对象变量，可以引用Date类型的对象，但是对象变量不是一个对象【没有new】
        today_new = today;//引用Date类型的对象today，此时today_new是today的别名
        System.out.println(today_new);
        //today和today_new的hashCode相同，即二者引用同一个对象
        //由此可知，一个对象变量并没有实际包含一个对象，而仅仅引用了一个对象。从这个角度，today和today_new是一样的，都可以理解为对象变量，真正的对象是new Date()
        System.out.println(today.hashCode());
        System.out.println(today_new.hashCode());
        //新Date对象的hashCode与上述不同，说明是不同的对象
        System.out.println((new Date()).hashCode());
        //局部变量不会自动初始化为null，而必须通过new或者将其设置为null进行初始化
        System.out.println(globalVarDate);//全局变量，自动初始化为null
        Date varDate;
        varDate = null;//如果不加这一句，会报错
        System.out.println(varDate);
        //Java中使用clone()方法获得对象的完整拷贝
        System.out.println(today.clone());
    }
}
