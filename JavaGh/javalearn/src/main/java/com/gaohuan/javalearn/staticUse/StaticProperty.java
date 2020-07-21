package com.gaohuan.javalearn.staticUse;

/**
 * static修饰的属性【域】属于类，而不属于某个具体对象
 * 对于某个类，其每个对象都有其自身的属性【非static修饰】，然而static修饰的属性是唯一的【不属于任何独立的对象】
 * 每个对象都可以更改static属性【如果为static成员设置了set方法】，并且以最后一次修改为准【之前所有对象和类的该static属性值保持一致】
 * 为了使用static属性的特性，最好不要为其设置set方法
 *
 * static变量使用的比较少，但静态常量【public static final double PI = 3.141592653】使用得比较多
 *
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/2 8:36
 */
public class StaticProperty {

    private static String name="高山";

    public static final double PI = 3.141592653;//其他类可以直接使用StaticProperty.PI来访问该变量，就像使用System.out.println一样

    private String power;

    public static String getName() {
        return name;
    }
// 不要为static设置set方法，所有对象的name值为“高山”
//    public static void setName(String name) {
//        StaticProperty.name = name;
//    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "StaticProperty{" +
                "power='" + power + '\'' +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        StaticProperty gh = new StaticProperty();

        gh.setPower("big");

//        gh.setName("高欢");

        StaticProperty hkj = new StaticProperty();

        hkj.setPower("not too big");

//        hkj.setName("韩科技");

        //在给static成员变量赋予初始值“高山”的情况下，类的实例对象可以对其进行更改，但以最后一个对象的最后一次更改为准，对该类的所有对象生效。

        //全部输出为：韩科技
        System.out.println(gh.toString());

        System.out.println(hkj.toString());

        //输出：韩科技
        System.out.println(StaticProperty.name);//即使没有实例化对象，可以直接通过类名获取static成员name


    }
}
