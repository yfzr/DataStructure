package com.sx.queue;

import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {

	public static void main(String[] args) {

	}

	
}

/**
 *使用数组模拟一个队列 
 */
class ArrayQueue{
	int maxSize;
	int front;	//队列头
	int rear;	//队列尾
	private int[] arr;
	//创建队列构造器
	public ArrayQueue(int arrMaxSize) {
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