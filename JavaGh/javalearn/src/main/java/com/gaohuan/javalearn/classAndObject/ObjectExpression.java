package com.gaohuan.javalearn.classAndObject;

/**
 * 对象的解释
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/13 13:12
 */
public class ObjectExpression {
    public static void main(String[] args) {
        //对象有三个特性
        System.out.println("对象的行为：可以对对象施加哪些操作？");
        System.out.println("对象的状态：当施加操作时，对象如何响应？");
        System.out.println("对象的标识：如何辨识具有相同行为与状态的不同对象？");
        //同一个类的所有对象实例，由于支持相同的行为而具有家族式的相似性。
        //对象的行为是由可调用的方法定义的。
        //对象保存着描述当前特征的信息，也即对象的状态。
        System.out.println("对象的状态可能会随着时间而发生改变，但这种改变不会是自发的。");
        System.out.println("对象状态的改变必须通过调用方法实现。");
        //对象的状态并不能完全描述一个对象。每个对象都有一个唯一的身份【identity】
        System.out.println("作为一个类的实例，每个对象的标识永远是不同的，状态常常也存在差异。");
        //对象的上述特性相互影响。对象的状态影响其行为【例如依据对象的属性值进行条件判断，进而调用操作对象的方法】
    }
}
