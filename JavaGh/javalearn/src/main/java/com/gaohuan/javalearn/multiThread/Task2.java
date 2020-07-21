package com.gaohuan.javalearn.multiThread;

/**
 * 实现多线程的方式之一：继承Thread类，重写run方法
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/10 9:41
 */
public class Task2 extends Thread{


    @Override
    public void run() {
        for (int j=0;j<1000;j++) {
            System.out.println("高欢的老婆");
            //线程礼让
            Thread.yield();//当前线程执行一次，将时间让给下一个线程，但不是绝对的，会受到CPU的影响
        }
    }
}
