package com.sx.hashtable;

public class HashTableDemo {
    public static void main(String[] args){

    }
}

//员工类
class Emp{
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//存储员工的链表
class EmpLinkedList{
    public Emp head;

    public EmpLinkedList(Emp head){
        this.head = head;

    }
    //添加员工
    public void add(Emp emp){

    }
    //显示员工链表
    public void list(){

    }
    //根据id查询员工
    public Emp findByEmpId(int id){

        return null;
    }
    //根据id删除员工
    public void deleteEmpById(int id){

    }
}

//哈希表
class HashTab{
    public EmpLinkedList[] empLinkedLists;

    public HashTab(int size){
        empLinkedLists = new EmpLinkedList[size];

    }
    //添加员工
    public void add(Emp emp){

    }
    //显示员工
    public void list(){

    }
    //根据id查询员工
    public Emp findEmpById(int id){
        return null;
    }
    //根据id删除员工
    public void deleteEmpById(int id){

    }
}
