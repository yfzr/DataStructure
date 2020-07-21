package com.gaohuan.javalearn.classAndObject;

/**
 * 类之间的关系
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/13 13:37
 */
public class RelationshipOfClasses {
    public static void main(String[] args) {
        //类之间常见的关系：依赖【uses-a】、聚合【has-a】、继承【is-a】
        System.out.println("依赖【dependence】：即“uses-a”关系，一种最常见、最明显的关系。形容为：一个类的方法操作了另一个类的对象。");
        //开发中应尽可能避免相互依赖的类。术语：让类之间的耦合度最小。
        System.out.println("聚合【aggregation】：即“has-a”关系，一种具体且易于理解的关系。形容为：类A的对象包含类B的对象，类A的属性类型为类B。");
        System.out.println("继承【inheritance】：即“is-a”关系，一种用于表示特殊【个性，子类】与一般【共性，父类】的关系。");
    }
}
