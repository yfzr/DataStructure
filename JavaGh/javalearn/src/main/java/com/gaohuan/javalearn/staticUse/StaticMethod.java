package com.gaohuan.javalearn.staticUse;

/**
 * static的作用：属于类且不属于类对象的变量和函数
 * 使用static的场景：
 *  1、一个方法不需要访问对象状态，其所需参数都是通过显式参数提供
 *  2、一个方法只需要访问类的静态域
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/8 5:55
 */
public class StaticMethod {

    private static String age;

    //场景2，只需要访问类的静态域
    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        StaticMethod.age = age;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //场景1，该方法不需要访问对象状态
    private static void printGH() {
        System.out.println("gaohuan");
    }


    public static void main(String[] args) {
        //通过类调用其静态方法
        StaticMethod.printGH();

        StaticMethod.setAge("28岁");

        System.out.println(StaticMethod.getAge());

        //可以通过类的对象调用其静态方法，但其实与对象的状态无关，且易造成混淆，不推荐使用对象调用类的静态方法
        StaticMethod method = new StaticMethod();
        method.printGH();
        method.setAge("28岁");
        System.out.println(method.getAge());
    }
}
