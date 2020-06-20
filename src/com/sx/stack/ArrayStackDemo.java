package com.sx.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            System.out.println("show：表示显示栈");
            System.out.println("exit：表示退出");
            System.out.println("push：表示入栈");
            System.out.println("pop：表示出栈");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.show();
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
                case "push":
                    System.out.println("请输入入栈数据：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int value2 = stack.pop();
                        System.out.printf("%d出栈\n", value2);
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}

//数组结构实现栈
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}