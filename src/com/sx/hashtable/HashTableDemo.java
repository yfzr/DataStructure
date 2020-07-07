package com.sx.hashtable;

import java.util.Scanner;

/**
 * 谷歌公司上机题：
 * 有一个公司，当有新员工来报到时，要求将该员工的信息（id，性别，年龄，住址...）加入。当输入该员工的id时，要求找到该员工的所有信息
 * 要求：不使用数据库
 */
public class HashTableDemo {
    public static void main(String[] args){
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (true){
            System.out.println("add：添加员工");
            System.out.println("list：显示所有员工");
            System.out.println("find：根据id查找员工");
            System.out.println("delete：根据id删除员工");
            System.out.println("exit：退出");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入添加的员工id：");
                    int id = scanner.nextInt();
                    System.out.println("请输入添加的员工姓名：");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入查找的员工id：");
                    id = scanner.nextInt();
                    Emp emp1 = hashTab.findEmpById(id);
                    System.out.println("id=" + emp1.id + "  " + "name=" + emp1.name);
                    break;
                case "delete":
                    System.out.println("请输入要删除的员工id：");
                    id = scanner.nextInt();
                    hashTab.deleteEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//员工类
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//存储员工的链表
class EmpLinkedList{
    //头指针，直接指向第一个emp
    private Emp head;
    //用于遍历的辅助指针
    public Emp curEmp;

    //添加员工
    public void add(Emp emp){
        //当添加的是第一个员工
        if (head == null){
            head = emp;
            return;
        }
        curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        //当前为链表的最后一个
        curEmp.next = emp;
    }
    //显示员工链表
    public void list(int no){
        if (head == null){
            System.out.println("第" + no + "条链表没有任何员工信息");
            return;
        }
        System.out.print("第" + no + "条链表的员工信息：");
        curEmp = head;
        while (true){
            System.out.printf("id=%d  name=%s\n", curEmp.id, curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        //System.out.println();
    }
    //根据id查询员工
    public Emp findByEmpId(int id){
        if (head == null){
            System.out.println("没有任何员工信息");
            return null;
        }
        curEmp = head;
        while (true){
            //找到员工
            if (curEmp.id == id){
                break;
            }
            //没有找到员工
            if (curEmp.next == null){
                System.out.printf("id为%d的员工不存在\n", id);
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
    //根据id删除员工
    public void deleteEmpById(int id){
        curEmp = head;
        while (true){
            if (head == null){
                System.out.println("没有任何员工信息");
                break;
            }else if (head.id == id){
                head = head.next;
            }else if (curEmp.next == null){
                System.out.printf("id为%d的员工不存在/n", id);
            }else if (curEmp.next.id == id){
                curEmp.next = curEmp.next.next;
            }
            curEmp = curEmp.next;
        }
    }
}

//哈希表，用于管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedLists;
    //链表数量
    private int size;
    public HashTab(int size){
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        //初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }
    //散列函数，使用简单的取模法
    public int hashFun(int id){
        return id % size;
    }
    //添加员工
    public void add(Emp emp){
        //根据员工id确定该员工处于哪条链表中
        int index = hashFun(emp.id);
        empLinkedLists[index].add(emp);
    }
    //显示员工
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }
    //根据id查询员工
    public Emp findEmpById(int id){
        //根据员工id确定该员工处于哪条链表中
        int index = hashFun(id);
        return empLinkedLists[index].findByEmpId(id);
    }
    //根据id删除员工
    public void deleteEmpById(int id){
        //根据员工id确定该员工处于哪条链表中
        int index = hashFun(id);
        empLinkedLists[index].deleteEmpById(id);
    }
}
