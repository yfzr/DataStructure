package com.sx.linkedlist;

public class SingleLinkedList {

    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedListDemo slld = new SingleLinkedListDemo();
        slld.add(hero1);
        slld.add(hero2);
        slld.add(hero3);
        slld.add(hero4);

        slld.list();
    }
}

class SingleLinkedListDemo{
    //初始化一个头节点，头节点不动，且不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");
    /**
     * 添加节点到单向链表
     * 当不考虑编号顺序时，思路：
     *  1.找到当前链表的最后节点
     *  2.将最后节点的next指向新的节点
     */
    public void add(HeroNode heroNode){
        //由于头节点不动，所以创建一个辅助节点用于遍历
        HeroNode temp = head;
        //遍历列表，找到最后节点
        while (true){
            if (temp.next == null){
                //System.out.println("这是一个空链表");
                break;
            }
            //如果没有找到最后，就继续后移
            temp = temp.next;
        }
        //当退出循环时，temp为最后节点，需要将其指向新节点
        temp.next = heroNode;
    }
    //显示链表
    public void list(){
        if (head.next == null){
            System.out.println("这是一个空链表");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/**
 * 定义HeroNode，每一个HeroNode就是一个节点
 */
class HeroNode{
    private int no;
    private String name;
    private String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
