package com.sx.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircleArray queue = new CircleArray(4);
        Character key;
        boolean loop = true;
        while (loop) {
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
 * ʹ�û�������ģ��һ������
 */
class CircleArray {
    private int maxSize;
    private int front;    //����ͷ��Ĭ��Ϊ0
    private int rear;    //����β��Ĭ��Ϊ0
    private int[] arr;

    //�������й�����
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //�ж϶����Ƿ���
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //��ȡ��������
    public int getQueue() {
        if (isEmpity()) {
            throw new RuntimeException("�ն��У��޷�ȡ������");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //��ʾ������������
    public void showQueue() {
        if (isEmpity()) {
            System.out.println("�ն��У�������");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }
    //�����ǰ������Ч���ݸ���
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //��ʾ���е�ͷ����
    public int headQueue() {
        if (isEmpity()) {
            throw new RuntimeException("�ն��У�������");
        }
        return arr[front];
    }
}
