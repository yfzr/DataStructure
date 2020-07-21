package com.gaohuan.javalearn.interfaceAndExtend;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/24 10:58
 */

//泛型接口
interface Father<T> {

    /**
     * 接口与抽象类：
     * Java仅支持单继承，也即Java类只能继承一个类，不能继承多个类
     * Java支持一个类可以实现多个接口
     * 抽象类与接口的区别：
     * 抽象类可以定义实例域，而接口的域自动定义为public static final
     * 一个类可以实现多个接口，而一个类仅能继承另一个类，不能继承多个类
     *
     */
    //接口特性1、接口中的属性必须初始化，且不可为private，默认为public static final
    String name = "高欢";
    //接口特性2、接口中的方法自动地被设置为public，但实现接口方法的类在其对应方法上需要添加修饰符public
    void printName();

    String age = "28岁";
    void printAge();

    void printThings(T thing);
}

//Java类之间可以继承扩展，接口之间同样可以继承扩展
//当父接口中有泛型时，为了保持泛型的可扩展性，建议子接口同样具有泛型，即使子接口中没有定义新的泛型方法
interface Son<T> extends Father<T> {

    String phoneNumber = "15120078199";
    void printPhoneNumber();
}

interface Uncle<T> {
    T add(T t1,T t2);
}

class ClassTest1 implements Father<String> {


//    public void setName(String name) {
//        this.name = name;//接口中定义的属性，为public final，不可更改
//    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public void printAge() {
        System.out.println(this.age);
    }

    @Override
    public void printThings(String thing) {
        System.out.println(thing);
    }

    @Override
    public String toString() {
        return "ClassTest1{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}

class ClassTest2 implements Father<String> {

    //可以在实现接口的类中增加与接口同名同类型的属性，此时这些属性会覆盖接口中定义且已初始化的属性
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

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public void printAge() {
        System.out.println(this.age);
    }

    @Override
    public void printThings(String thing) {
        System.out.println(thing);
    }

    @Override
    public String toString() {
        return "ClassTest1{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

//父接口中有泛型方法，实现子接口的类如何处理泛型？要求子接口中保持泛型形式【interface Son<T> extends Father<T>】。实现子接口的类照旧实现泛型方法即可。
class ClassTest3 implements Son<Integer>,Uncle<Integer> {

    @Override
    public void printName() {
        System.out.println("test3："+this.name);
    }

    @Override
    public void printAge() {
        System.out.println("test3："+this.age);
    }

    @Override
    public void printThings(Integer thing) {
        System.out.println("test3："+thing);
    }

    @Override
    public void printPhoneNumber() {
        System.out.println("test3："+this.phoneNumber);
    }

    @Override
    public Integer add(Integer t1, Integer t2) {
        if (t1==null && t2==null) {
            return null;
        } else if (t1!=null && t2!=null) {
            return t1+t2;
        } else {
            return (t1==null) ? t2 : t1;
        }
    }

    @Override
    public String toString() {
        return "ClassTest3{"+
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

public class Test {

    public static void main(String[] args) {
        ClassTest1 test1 = new ClassTest1();
        test1.printName();
        test1.printAge();
        System.out.println(test1.getClass());
        System.out.println(test1.toString());

        ClassTest2 test2 = new ClassTest2();
        test2.setName("高冲");
        test2.setAge("17岁");
        test2.printName();
        test2.printAge();
        test2.printThings(test2.toString());
        System.out.println(test2.getName());
        System.out.println(test2.getAge());
        System.out.println(test2.getClass());
        System.out.println(test2.toString());

        ClassTest3 test3 = new ClassTest3();
        test3.printThings(test3.add(1,2));
        test2.printThings(test3.toString());
        test3.printThings(test3.add(1,null));

        //接口变量
        Father father;
        //接口变量可以引用实现其接口方法的类对象，即使该类中包含其他方法和实现了其他接口
        father = new ClassTest3();
        System.out.println(father.getClass());
        //father变量可以调用ClassTest3中的所有方法
        father.printThings(((ClassTest3) father).add(1,2));
        father.printName();
        father.printAge();
        ((ClassTest3) father).printPhoneNumber();
    }
}
