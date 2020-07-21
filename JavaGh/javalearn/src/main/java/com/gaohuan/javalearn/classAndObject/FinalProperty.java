package com.gaohuan.javalearn.classAndObject;

/**
 * 类的final关键字：
 * 构建对象时必须初始化final修饰的属性
 * 初始化后，不能对其进行修改
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/1 10:53
 */
public class FinalProperty {

    // 注意final尽量不要修饰可变类型【有更改器方法的类型】
    // 可以直接在类中设定值【灵活性小，对于类的所有对象，该属性一致】
    // 可以利用构造函数对其进行初始化【灵活性高，仅对于当前对象，该值在创建当前对象时，被初始化，且后续不得更改】
//    private final String name = "高欢";
    private final String name;
    //使用构造函数对final变量初始化
    public FinalProperty(String name) {
        this.name=name;
    }
    private String power;

    public String getName() {
        return name;
    }//注意final属性不能有set方法，其初始化有两种方式：1、声明时初始化；2、构造函数初始化

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public static void main(String[] args) {
        FinalProperty gh = new FinalProperty("高欢");
        FinalProperty hkj = new FinalProperty("韩科技");
        gh.setPower("big");
//        hkj.name="韩科技";//cannot assign a value to final variable "name"
        System.out.println(gh.name);
        System.out.println(gh.getName());
        System.out.println(gh.getPower());
        System.out.println(hkj.name);
    }
}
