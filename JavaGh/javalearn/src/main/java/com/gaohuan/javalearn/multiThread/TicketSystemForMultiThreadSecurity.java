package com.gaohuan.javalearn.multiThread;

/**
 * 多线程安全问题示例之“火车购票系统”
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/10 15:14
 */
public class TicketSystemForMultiThreadSecurity implements Runnable{

    //武汉-->上海的火车票初始总数
    private static Integer ticketNumber = 200;

    //模拟一个售票窗口的购票场景
    @Override
    public void run() {
        //模拟1000人抢票
        try {
            for (int i=0;i<1000;i++) {
                //使用synchronized对购票核心步骤上锁，解决线程安全问题
                synchronized (TicketSystemForMultiThreadSecurity.class) {
                    if (ticketNumber > 0) {
                        Thread.sleep(50);//模拟单人购票时长
                        ticketNumber--;//购票后，车票总数减少1张
                        System.out.println("恭喜您，成功抢到票！！！尚有余票" + ticketNumber + "张");
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("很遗憾，操作有误，请重试！！！");
        }
    }
}
