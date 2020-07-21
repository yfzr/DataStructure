package com.gaohuan.javalearn.abstractAndExtend;

import java.util.HashMap;

/**
 * 测试抽象类在继承背景下的特点
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/24 8:51
 */

/**
 * 没有抽象方法的抽象基类
 */
abstract class GrandFather {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

/**
 * 父亲类继承抽象爷爷类
 */
class Father extends GrandFather {

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + this.getName() + '\'' +
                ", age='" + this.getAge() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

/**
 * 儿子类继承父亲类
 */
class Son extends Father {

    private String girlFriends;

    public String getGirlFriends() {
        return girlFriends;
    }

    public void setGirlFriends(String girlFriends) {
        this.girlFriends = girlFriends;
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + this.getName() + '\'' +
                ", age='" + this.getAge() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", girlFriends='" + girlFriends + '\'' +
                '}';
    }
}

/**
 * 含有抽象方法的抽象基类
 */
abstract class GrandMother {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //抽象方法
    public abstract void printName();
}

/**
 * 母亲类继承含有抽象方法的抽象基类
 */
abstract class Mother extends GrandMother{

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Mother{" +
                "name='" + this.getName() + '\'' +
                ", age='" + this.getAge() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    /**
     * 实现其基类中定义的抽象方法
     */
    @Override
    public void printName() {
        System.out.println(this.getName());
    }

    //由于定义了抽象方法，必须将母亲类声明为抽象类
    public abstract void printPhoneNumber();
}

/**
 * 女儿类继承含有抽象方法的母亲类
 */
class Daugther extends Mother {

    private String boyFriends;

    public String getBoyFriends() {
        return boyFriends;
    }

    public void setBoyFriends(String boyFriends) {
        this.boyFriends = boyFriends;
    }

    @Override
    public String toString() {
        return "Daugther{" +
                "name='" + this.getName() + '\'' +
                ", age='" + this.getAge() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", boyFriends='" + boyFriends + '\'' +
                '}';
    }

    /**
     * 实现其基类中定义的抽象方法
     */
    @Override
    public void printPhoneNumber() {
        System.out.println(this.getPhoneNumber());
    }
}

public class Test {

    public static void main(String[] args) {
        System.out.println("==========================抽象基类中没有抽象方法，其子类和孙子类可皆不为抽象类============================");
        GrandFather grandFather;//可以定义抽象基类的对象变量，但不可用抽象基类对其实例化
        grandFather = new Father();//可利用抽象基类的子类进行实例化
        System.out.println(grandFather.getClass());//看看grandFather到底引用的是什么对象？猜测：Father类对象
        grandFather.setName("高留成");
        grandFather.setAge("47岁");//调用抽象基类中已定义的属性和方法，可以不用加类型转换
        ((Father) grandFather).setPhoneNumber("15518367228");//调用子类中特有的属性和方法，需要加上类型说明
        System.out.println(grandFather.toString());

        //Java中有两种变量：基本数据类型和引用类型【需要new才能使用的对象，一般为用户自定义的类和List、Map、Set等集合】
        //基本类型的变量，其变量存储的是相应类型的值，不可改变其类型，若要强制改变，需要进行强制类型转换
        int a = 0;
        a = (int) 0.1;//如果不进行强制类型转换，则报错
        Integer a1 = 0;
        //此时即使进行强制类型转换，亦会出错，因为int是属于基本类型，而Integer属于Object的子类
        //正确的做法是：先将0.1强制转换为int类型，然后再使用Integer.valueOf()赋值为a1【Integer.valueOf()可以省略】
        a1 = Integer.valueOf((int) 3.1);
        System.out.println(a1);
        //Integer.valueOf()的入参为int或者String 猜一猜会输出什么？不会是0.1吧？实际结果是：编译通过，运行报错java.lang.NumberFormatException: For input string: "0.1"
        //之所以出错，打开Integer.valueOf()的源码，发现这里的String参数需要是“整数字符串”，例如"0","-123","456"等，输出的结果也是相应的整数，即0，-123，456
        a1 = Integer.valueOf("123");
        System.out.println(a1);

        //对于引用类型的变量，其变量存储的是一个地址，该地址指向该变量要引用的对象。因此，引用类型的变量是可以随时改变其引用指向的，但是有一个范围，即为定义该对象变量的祖先类及其所有后代中的非抽象类对象。
        grandFather = new Son();
        //grandFather = new HashMap<>();//报错，因为对象变量grandFather只能引用抽象基类GrandFather及其后代中的非抽象类对象
        System.out.println(grandFather.getClass());//看看grandFather到底引用的是什么对象？猜测：Son类对象
        grandFather.setName("高欢");
        grandFather.setAge("28岁");//调用抽象基类中已定义的属性和方法，可以不用加类型转换
        ((Father) grandFather).setPhoneNumber("15120078199");//调用子类中特有的属性和方法，需要加上类型转换【注意：这里使用Father进行类型说明也可以】
//        ((Son) grandFather).setPhoneNumber("15120078199");//调用子类中特有的属性和方法，需要加上类型说明
        ((Son) grandFather).setGirlFriends("活泼可爱温柔体贴");//调用孙子类中特有的属性和方法，需要加上类型说明
        System.out.println(grandFather.toString());

        System.out.println("==========由此，得出结论：一个原则，当前类有的方法和属性，其及其子类对象可以直接调用；当前类没有的方法和属性，其对象不可调用============");

        System.out.println("==========================抽象基类中有抽象方法，其子类和孙子类可皆不为抽象类============================");

        GrandMother grandMother;
        Mother mother;

        grandMother = new Daugther();
        System.out.println(grandMother.getClass());//class com.gaohuan.javalearn.abstractAndExtend.Daugther
        grandMother.setName("王青美");
        grandMother.setAge("51岁");
        //注意进行类型说明的类不能是抽象类，因为关于phoneNumber的属性和方法是在Mother中定义的，理论上这里默认会用Mother进行类型说明，但Mother类是抽象类
        ((Daugther) grandMother).setPhoneNumber("15638362158");
        System.out.println(grandMother.toString());//调用的是Daughter的toString方法

        mother = new Daugther();
        System.out.println(mother.getClass());//class com.gaohuan.javalearn.abstractAndExtend.Daugther
        mother.setName("女儿");
        mother.setAge("20岁");
        mother.setPhoneNumber("18601725759");
        ((Daugther) mother).setBoyFriends("正值善良忠诚专一");
        System.out.println(mother.toString());//调用的是Daughter的toString方法

        System.out.println("==========由此，得出结论：抽象父类的抽象方法，其子类必须实现，子类也可以定义自己的抽象方法【若定义了抽象方法，则必须声明为抽象类】============");
    }
}
