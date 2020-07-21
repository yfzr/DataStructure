package com.gaohuan.javalearn.classAndObject;

/**
 * 类的解释
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/13 11:00
 */
public class ClassExpression {
    public static void main(String[] args) {
        //类是构造对象的模板【蓝图】
        //类构造【construct】对象的过程，称为创建类的实例【instance】
        //封装【encapsulation，数据隐藏】，与对象有关的重要概念。
        System.out.println("封装在形式上，是将数据和行为组合在一个包里，并对对象的使用者隐藏了数据的实现形式。");
        //对象中的数据称为实例域【instance field】，操作数据的过程称为方法【method】。
        //对于每个特定的类实例【对象】，都有一组特定的实例域值，这些值的集合称为该对象的当前状态【state】
        //无论何时，只要向对象发送一个消息【调用对象的方法】，其状态就有可能发生变化
        System.out.println("实现封装的关键在于绝对不能让类中的方法直接访问其他类的实例域，程序仅通过对象的方法与对象数据进行交互");
        System.out.println("封装给对象赋予了“黑盒子”的特征。这是提高重用性和可靠性【意味着一个类可以全面地改变存储数据的方式，只要仍旧使用同样的方法操作数据，其他对象就不会知道或者介意所发生的变化】的关键");
        //面向对象编程会让用户自定义Java类变得轻而易举
        //Java中所有的类都源自于Object类！！！
        System.out.println("可以通过扩展一个类【父类】来建立另外一个新类【子类】。新类【子类】具有所扩展类【父类】的全部属性和方法。");
        System.out.println("在新类中，只需提供适用于新类的新方法和数据域就可以了。");
        System.out.println("通过扩展一个类来建立另外一个类的过程称为“继承");
    }
}
