package com.gaohuan.javalearn.classAndObject;

import java.util.Date;

/**
 * 不要编写返回引用可变对象的访问器方法
 * 下面以Date为例，Date类有一个更改器方法setTime，也即Date对象是可变的，可能会破坏封装性
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/1 9:54
 */
public class EmployeeByDate {


    private String name;

    private double salary;

    private Date hireDay;

    public EmployeeByDate(String name,double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary*byPercent/100;
        salary = salary+raise;
    }

    public Date getHireDay() {
        return (Date) hireDay.clone();
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public static void main(String[] args) {
        EmployeeByDate gh = new EmployeeByDate("高欢",150000);
        System.out.println("姓名："+gh.getName());
        System.out.println("工资："+gh.getSalary()+"元");
        System.out.println("入职时间："+gh.getHireDay().toString());
        Date date = gh.getHireDay();
        long oneYearInMilliSeconds = (long)(60*60*1000*24)*(long)(365*1);//注意当乘积结果超出默认int位数时，会进行截取，导致后续计算结果不准确。解决：提前进行long类型转换
        date.setTime(date.getTime()-oneYearInMilliSeconds);
        //可以看到EmployeeByDate对象的hireDay属性被Date对象的setTime方法更改了，这破坏了类的的封装性
        //解决办法：在关于属性hireDay的get方法中，添加clone操作，返回一个Date对象【该对象克隆了gh对象的hireDay属性，更改该对象，不会影响gh对象的hireDay属性】
        System.out.println("入职时间："+gh.getHireDay().toString());
        System.out.println("经过setTime操作后的Date对象："+date.toString());
    }
}
