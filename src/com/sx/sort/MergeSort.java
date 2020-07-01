package com.sx.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度O(nlog(n))
 * 测试大批量（800000）的排序时间约为150 ms
 */
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        //int[] temp = new int[arr.length];
        //mergeSort(arr, 0, arr.length-1, temp);
        //System.out.println("归并排序结果：" + Arrays.toString(arr));

        //大批量插入排序测试
        int[] arr = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        int[] temp = new int[arr.length];
        //String s = "yyyy-MM-dd hh:mm:ss";
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(s);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime1));
        System.out.println(localDateTime1);
        //shellSort(arr);
        mergeSort(arr, 0, arr.length - 1, temp);
        //LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        LocalDateTime localDateTime2 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime2));
        System.out.println(localDateTime2);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            //System.out.println("开始归并...");
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并排序的合并过程
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的初始索引
     * @param temp  用于中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        //1.对比两边有序序列的当前索引值，小的值放入temp，然后索引向前，继续比较
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t += 1;
                l += 1;
            } else {
                temp[t] = arr[r];
                t += 1;
                r += 1;
            }
        }
        //2.当一边的数据都放入temp时，需要将另一边可能还没有存放的数据全部放入temp
        while (l <= mid) {
            temp[t] = arr[l];
            t += 1;
            l += 1;
        }
        while (r <= right) {
            temp[t] = arr[r];
            t += 1;
            r += 1;
        }
        //3.将temp中的有序数据放回原数组
        //注意：并不是每次都放回原数组全部的数据，因为原数组会经历多次的递归回溯，可能只是处理部分的数据
        int leftTemp = left;
        t = 0;
        //System.out.println("left=" + left + " " + "right=" + right);
        while (leftTemp <= right) {
            arr[leftTemp] = temp[t];
            leftTemp += 1;
            t += 1;
        }
    }
}
