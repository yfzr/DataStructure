package com.sx.queue;

import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {

	public static void main(String[] args) {

	}

	
}

/**
 *ʹ������ģ��һ������ 
 */
class ArrayQueue{
	int maxSize;
	int front;	//����ͷ
	int rear;	//����β
	private int[] arr;
	//�������й�����
	public ArrayQueue(int arrMaxSize) {
		front = -1;
		rear = -1;
		arr = new int[arrMaxSize];
	}
	//�ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
	} 
	//�ж϶����Ƿ��
	public boolean isEmpity() {
		return rear == front;
	} 
	//������ݵ�����
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�����������޷��������");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	//��ȡ��������
	public int getQueue() {
		if (isEmpity()) {
			throw new RuntimeException("�ն��У��޷�ȡ������");
		}
		front++;
		return arr[front];
	}
	//��ʾ������������
	public void showQueue() {
		if (isEmpity()) {
			throw new RuntimeException("�ն��У�������");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	//��ʾ���е�ͷ����
	public int headQueue() {
		if (isEmpity()) {
			throw new RuntimeException("�ն��У�������");
		}
		return arr[front + 1];
	}
}