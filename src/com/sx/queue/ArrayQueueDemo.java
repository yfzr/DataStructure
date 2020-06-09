package com.sx.queue;

import javax.management.RuntimeErrorException;
import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayQueue queue = new ArrayQueue(3);
		Character key;
		boolean loop = true;
		while (loop){
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据");
			System.out.println("g(get):取出数据");
			System.out.println("h(head):显示队列头");

			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					queue.showQueue();
					break;
				case 'e':
					loop = false;
					break;
				case 'a':
					System.out.println("请输入添加的数字：");
					int value = scanner.nextInt();
					queue.addQueue(value);
					break;
				case 'g':
					try {
						int data = queue.getQueue();
						System.out.printf("取出的数据是：%d\n", data);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int head = queue.headQueue();
						System.out.printf("头部的数据是：%d\n", head);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		}
		System.out.println("已退出程序");
	}

	
}

/**
 *使用数组模拟一个队列 
 */
class ArrayQueue{
	private int maxSize;
	private int front;	//队列头
	private int rear;	//队列尾
	private int[] arr;
	//创建队列构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		front = -1;
		rear = -1;
		arr = new int[arrMaxSize];
	}
	//判断队列是否满
	public boolean isFull() {
		return rear == maxSize - 1;
	} 
	//判断队列是否空
	public boolean isEmpity() {
		return rear == front;
	} 
	//添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列已满，无法添加数据");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	//获取队列数据
	public int getQueue() {
		if (isEmpity()) {
			throw new RuntimeException("空队列，无法取出数据");
		}
		front++;
		return arr[front];
	}
	//显示队列所有数据
	public void showQueue() {
		if (isEmpity()) {
			throw new RuntimeException("空队列，无数据");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	//显示队列的头数据
	public int headQueue() {
		if (isEmpity()) {
			throw new RuntimeException("空队列，无数据");
		}
		return arr[front + 1];
	}
}