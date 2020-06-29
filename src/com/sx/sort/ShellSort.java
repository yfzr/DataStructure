package com.sx.sort;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n^3)
 * 测试大批量（80000）的排序时间
 *      交换式：约为14s
 *      移位式：20-35 ms
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr = {8,9,1,7,2,3,5,4,6,0};
        //shellSort(arr);

        //大批量插入排序测试
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        //String s = "yyyy-MM-dd hh:mm:ss";
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(s);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime1));
        System.out.println(localDateTime1);
        //shellSort(arr);
        shellSort2(arr);
        //LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        LocalDateTime localDateTime2 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime2));
        System.out.println(localDateTime2);
    }

    //交换式希尔排序
    public static void shellSort(int[] arr) {
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("第" + (++count) + "轮希尔排序");
            //System.out.println(Arrays.toString(arr));
        }
    }

    //优化交换式希尔排序为移位式希尔排序
    public static void shellSort2(int[] arr) {
        int temp;
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                if (arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && arr[j] < arr[j-gap]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //找到插入的位置
                    arr[j] = temp;
                }
            }
            //System.out.println("第" + (++count) + "轮希尔排序");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
