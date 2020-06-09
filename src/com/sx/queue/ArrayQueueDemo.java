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
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������");
			System.out.println("g(get):ȡ������");
			System.out.println("h(head):��ʾ����ͷ");

			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					queue.showQueue();
					break;
				case 'e':
					loop = false;
					break;
				case 'a':
					System.out.println("��������ӵ����֣�");
					int value = scanner.nextInt();
					queue.addQueue(value);
					break;
				case 'g':
					try {
						int data = queue.getQueue();
						System.out.printf("ȡ���������ǣ�%d\n", data);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int head = queue.headQueue();
						System.out.printf("ͷ���������ǣ�%d\n", head);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		}
		System.out.println("���˳�����");
	}

	
}

/**
 *ʹ������ģ��һ������ 
 */
class ArrayQueue{
	private int maxSize;
	private int front;	//����ͷ
	private int rear;	//����β
	private int[] arr;
	//�������й�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
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