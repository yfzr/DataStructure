package com.sx.linkedlist;

import java.util.Stack;

public class SingleLinkedList {

    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero41 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "张青", "菜园子");

        SingleLinkedListDemo slld = new SingleLinkedListDemo();

        //测试添加方法1
//        slld.add(hero1);
//        slld.add(hero2);
//        slld.add(hero3);
//        slld.add(hero4);
        //测试添加方法2
        slld.addByOrder(hero1);
        slld.addByOrder(hero4);
        slld.addByOrder(hero2);
        slld.addByOrder(hero3);
        slld.addByOrder(hero2);
        //测试更新节点
        slld.list();
        slld.update(hero41);
        slld.list();
        //测试删除节点
        slld.delete(5);
        slld.list();

        System.out.printf("单链表中的有%d个有效节点\n", slld.getLength(slld.getHead()));

        System.out.printf("单链表中倒数第%d个节点为：" + slld.findLastIndexNode(slld.getHead(), 2) + "\n", 2);

        slld.reverseList(slld.getHead());
        System.out.println("反转后的单链表如下");
        slld.list();

        System.out.println("逆序打印单链表如下");
        slld.reversePrint(slld.getHead());
        //slld.list();


    }
}

class SingleLinkedListDemo{
    //初始化一个头节点，头节点不动，且不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //获取头节点
    public HeroNode getHead(){
        return head;
    }

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

    /**
     * 当考虑按编号顺序添加
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){ //说明英雄添加在最后
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }
            if (temp.next.no == heroNode.no){   //存在重复编号
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("准备插入的编号%d英雄已经存在，无法插入\n", heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息，但不能修改no，否则相当于添加
    public void update(HeroNode newHeroNode){
        HeroNode temp = head;
        boolean flag = false;
        if (head.next == null){
            System.out.println("链表为空，无法修改");
            return;
        }
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
            System.out.printf("编号%d的英雄信息已被修改\n", newHeroNode.no);
        }else {
            System.out.printf("没有找到编号%d的节点，修改失败\n", newHeroNode.no);
        }
    }

    //删除节点
    public void delete(int no){
        HeroNode temp = head;
        if (head.next == null){
            System.out.println("空链表，删除失败");
            return;
        }
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
            System.out.printf("已成功删除编号%d的英雄节点\n", no);
        }else {
            System.out.printf("找不到编号%d的英雄节点,删除失败\n", no);
        }
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

    //获取单链表的节点个数
    public int getLength(HeroNode head){
        if (head.next == null){
            return  0;
        }
        HeroNode current = head.next;
        int len = 0;
        while (current != null){
            len++;
            current = current.next;
        }
        return len;
    }

    //查找单链表中倒数第K个节点
    public HeroNode findLastIndexNode(HeroNode head, int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size){
            return null;
        }
        HeroNode current = head.next;
        for (int i = 0; i < size-index; i++){
            current = current.next;
        }
        return current;
    }

    //单链表反转
    public void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            //System.out.println(next == cur.next); //结果为false
            reverseHead.next = cur; //反向链表与当前节点连接
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //逆序打印单链表，如果先反转后打印，则会破坏链表结构，不可取，因此采用栈结构
    public void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);    //入栈
            cur = cur.next;
        }
        while (stack.size() != 0){
            System.out.println(stack.pop());    //出栈
        }
    }

    //合并两个单链表，合并后的链表依然有序
    public HeroNode combine(HeroNode head1, HeroNode head2){
        HeroNode newHead = new HeroNode(0, "", "");

        return newHead;
    }
}

/**
 * 定义HeroNode，每一个HeroNode就是一个节点
 */
class HeroNode{
    public int no;
    public String name;
    public String nickName;
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
