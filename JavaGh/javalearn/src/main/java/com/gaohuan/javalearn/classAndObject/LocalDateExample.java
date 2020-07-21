package com.gaohuan.javalearn.classAndObject;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Date类是表示时间点，还有一个日历表示法的LocalDate类
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/14 8:26
 */
public class LocalDateExample {
    public static void main(String[] args) {
        //不要使用构造器构造LocalDate类的对象，应当使用静态工厂方法
        System.out.println(LocalDate.now());//输出2020-04-14
        //可以提供特定的年月日来构造对应的日期
        System.out.println(LocalDate.of(1992,11,22));//输出1992-11-22
        //将构造的日期对象保存在变量中
        LocalDate localDate = LocalDate.of(1992,11,22);
        System.out.println("高欢的生日："+localDate);
        //一旦有了LocalDate对象，可以用方法getYear、getMonthValue、getDayOfMonth
        int year = localDate.getYear();
        System.out.println("高欢出生于哪一年："+year);
        int month = localDate.getMonthValue();
        System.out.println("高欢出生在哪一月："+month);
        int day = localDate.getDayOfMonth();//一月中的第几天
        System.out.println("高欢出生在一月中的第几天："+day);
        day = localDate.getDayOfYear();//一年中的第几天
        System.out.println("高欢出生在一年中的第几天："+day);
        DayOfWeek dayOfWeek =localDate.getDayOfWeek();//一周中的第几天
        System.out.println("高欢出生在星期几："+dayOfWeek);//输出SUNDAY

        //plusDays方法会得到一个由localDay加上相应天数后的新日期对象
        //判断一个方法是更改器方法【修改原有对象，不生成新的对象】，还是访问器方法【只访问原有对象，不修改原有对象，可能生成新的对象】，只需要观察方法的返回值类型即可。
        LocalDate newDate = localDate.plusDays(10000);
        System.out.println(newDate);
        //计算我从出生到现在生活了多少天
        System.out.println("我活了"+LocalDateExample.daysOfAge(1992,11,22)+"天！");
    }

    /**
     * 计算给定日期距离当前日期相差的天数
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 天数
     */
    private static long daysOfAge(int year,int month,int day) {
        LocalDate birthday = LocalDate.of(year,month,day);
        LocalDate nowDate = LocalDate.now();
        long resultDaysOfAge = 0;
        resultDaysOfAge = DAYS.between(birthday,nowDate);
        return resultDaysOfAge;
    }
}
