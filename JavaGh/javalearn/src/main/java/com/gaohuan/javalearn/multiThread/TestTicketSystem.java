package com.gaohuan.javalearn.multiThread;

/**
 * 测试火车购票系统
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/10 15:32
 */
public class TestTicketSystem {
    public static void main(String[] args) {
        //创建一个火车售票系统，全国只有一个火车售票系统，也即仅有一个火车售票系统对象
        TicketSystemForMultiThreadSecurity ticketSystem = new TicketSystemForMultiThreadSecurity();
        //创建多个地方的售票窗口
        Thread thread1 = new Thread(ticketSystem);//武昌窗口
        Thread thread2 = new Thread(ticketSystem);//汉口窗口
        Thread thread3 = new Thread(ticketSystem);//光谷窗口
        //三个售票窗口同时售票，出现下述的不正常场景
        /**
         * 不正常1：多个窗口在其售票后，显示同一剩余票数？？？
         * 恭喜您，成功抢到票！！！尚有余票24张
         * 恭喜您，成功抢到票！！！尚有余票24张
         *
         * 不正常2：购票后，剩余-1张？？？
         * 恭喜您，成功抢到票！！！尚有余票-1张
         */
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
