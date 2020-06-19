package com.sx.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        System.out.println("创建约瑟夫环");
        csll.addBoy(5);
        csll.showBoy();
        System.out.println("----------");
        csll.countBoy(2, 2, 5);
    }
}

/**
 * 创建环形单向链表
 */
class CircleSingleLinkedList {
    private Boy first = null;

    //添加节点
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("节点数至少大于1");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {    //添加第一个节点时单独讨论
                first = boy;
                first.setNext(first);
                curBoy = first;
            }
            curBoy.setNext(boy);
            boy.setNext(first);
            curBoy = boy;
        }
    }

    //遍历环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("%d号小孩\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入计算小孩的出圈顺序
     * @param startNo 表示从哪个小孩开始
     * @param countNum 表示数几下
     * @param nums 表示小孩初始个数
     */
    public void countBoy(int startNo, int countNum, int nums){
        //1.参数校验
        if (startNo < 1 || startNo > nums){
            System.out.println("参数有误");
            return;
        }
        Boy helper = first;
        //2.将辅助指针helper指向first的前一个节点
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //3.helper和first默认为第一个节点设置，现在将其移动到用户输入的开始节点设置
        for (int i = 0; i < startNo - 1; i++){
            first  = first.getNext();
            helper = helper.getNext();
        }
        //4.开始报数出圈
        while (true){
            if (first == helper){
                break;
            }
            for (int i = 0; i < countNum - 1; i++){
                first  = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("%d号小孩出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留下的小孩是%d号\n", first.getNo());
    }
}

/**
 * 创建Boy节点
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
