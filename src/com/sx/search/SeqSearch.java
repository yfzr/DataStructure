package com.sx.search;

import java.util.Scanner;

public class SeqSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 9, 11, -1, 34, 89};
        System.out.println("请输入要查找的数据：");
        int value = scanner.nextInt();
        int index = seqSearch(arr, value);
        if (index == -1){
            System.out.println("不存在这个值");
        }else {
            System.out.printf("%d的索引是%d", value, index);
        }
    }

    /**
     * 线性查找
     * @param arr 数据
     * @param value 待查找的值
     * @return 如果存在查找的值，则返回其索引；如果不存在就返回-1
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
