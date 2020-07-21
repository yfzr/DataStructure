package com.gaohuan.javalearn.classAndObject;

import java.time.LocalDate;

/**
 * 类的实例域、更改器方法【set方法】和访问器方法【get方法】
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/1 9:36
 */
public class Employee {

    private String name;

    private double salary;

    private LocalDate hireDay;

    public Employee(String name,double salary,int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
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

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public static void main(String[] args) {
        Employee gh = new Employee("高欢",150000,2019,7,15);
        System.out.println("姓名："+gh.getName());
        System.out.println("工资："+gh.getSalary()+"元");
        System.out.println("入职时间："+gh.getHireDay().toString());
    }

}
