package com.gaohuan.javalearn.classAndObject;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 编写一个日历程序，包含具体日期对应星期几和用*标注当前日期
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/1 8:40
 */
public class CalendarByLocalDate {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();//获取当前日期

        int month = date.getMonthValue();//获取当前月份，用以后续循环打印日期时，当月界限的判断

        int today = date.getDayOfMonth();//获取当前日期【当前月的第几天】，用于获取当月第一天和后续打印日期时是否为当前日期的判断

        //将date设置为这个月的第1天，并得到当前月的第一天属于星期几
        date = date.minusDays(today-1);//生成当前日期之前【参数大于0】today-1天的日期，也即得到当前月的第一天；【当该方法的参数小于0时，是生成当前日期之后多少天的日期】

        DayOfWeek weekday = date.getDayOfWeek();//获取此时date【当月的第一天】属于星期几

        int value = weekday.getValue();//星期几与数字的对应关系【Monday<-->1，...，Sunday<-->7】，获取当前月第一天属于星期几对应的数字，用于日历的日期第一行缩进使用

        //除非该月的第一天正好是星期一，否则日历中日期的第一行是缩进的
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");//打印日历第一行，也即星期几
        //打印缩进量，注意循环变量i是从1开始的
        for (int i=1;i<value;i++) {
            System.out.print("    ");//4个空格为一个缩进【因为星期几有三个字母，再加上两个星期几之间的一个空格】
        }

        //现在打印日历的主体【每一天的日期】
        while (date.getMonthValue() == month) {
            System.out.printf("%3d",date.getDayOfMonth());//每个日期占用3个空格，与星期几的三个字符保持位置对应
            //判断日期是否属于当月的当前日期，若属于，则用*标注
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);//日期递增1天
            //日历打印换行【若日期对应星期一，则换行】
            if (date.getDayOfWeek().getValue()==1) {
                System.out.println();
            }
        }
    }
}
