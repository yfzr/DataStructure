package com.gaohuan.javalearn.multiThread;

/**
 * 测试多线程实现方式1：继承Thread类，重写run方法，start启动
 * 注：由于存在继承关系，不提倡使用
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/10 9:55
 */
public class TestForMethod1 {
    public static void main(String[] args) {
        //创建线程1
        Task1 task1 = new Task1();
        //创建线程2
        Task2 task2 = new Task2();
        //运行程序
        //不能按照顺序执行【有先后顺序，不是同时运行了】
        //使用Thread中的start方法【Runnable接口中没有start方法】，先后启动【只启动，不等执行】，同时执行
        task1.start();
        task2.start();
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
