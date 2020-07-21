package com.gaohuan.javalearn.multiThread;

/**
 * 测试多线程实现方式2：实现Runnable接口，重写run方法，构造Thread对象，start启动线程
 * 注：该方式不存在继承关系，比较流行的多线程实现方式
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/10 9:55
 */
public class TestForMethod2 {
    public static void main(String[] args) {
        //创建线程1
        Task3 task3 = new Task3();
        //创建线程2
        Task4 task4 = new Task4();
        //运行程序
        //不能按照顺序执行【有先后顺序，不是同时运行了】
        //由于Runnable接口中没有启动线程的start方法，需要利用Thread的有参【参数为Runnable对象】构造方法构造Thread类对象，调用其start方法，启动线程
        Thread thread1 = new Thread(task3);
        Thread thread2 = new Thread(task4);
        thread1.start();
        thread2.start();
        //实际执行情况，交叉打印

        //CPU与多线程的执行效果有直接关系
        /**
         * CPU是以毫秒为时间单位
         * 单核CPU：一会儿执行task1，一会儿执行task2，交叉执行，这里的“一会儿”是几毫秒
         * 注1：CPU给任务分配的时间是不均匀的【操作系统控制CPU给任务分配时间】
         * 注2：人眼的分辨率在0.1秒左右，也即100毫秒以内的时间差，在人看来是同时的。
         * 当任务非常多时，单核CPU会出现卡顿现象【点击一个软件，几秒没反应】【对于CPU，几核的CPU，相当于几个人同时做事情】。
         * 双核、四核、八核CPU
         */

        //为了降低因操作系统和CPU导致多线程时间调度不均衡的问题，可以采用“时间礼让”方式
        //在Thread类中有个静态方法yield()【时间礼让方法】，在Task任务类中直接使用类名调用该方法
        //在Thread类中有个静态方法sleep(毫秒数)【睡眠，但不让，只是隔多久不执行sleep后面的代码，自己唤醒】
    }
}
