package com.sx.sort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n^2)
 * 测试大批量（80000）的排序时间约为3s
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 1, -1, 90, 123};
        //selectSort(arr);

        //大批量选择排序测试
        String s = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(s);
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("+8"));
        System.out.println(dtf.format(localDateTime1));

        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        selectSort(arr);

        LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        System.out.println(dtf.format(localDateTime2));
    }

    public static void selectSort(int[] arr) {
        int minIndex, min;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //如果本身为最小值，则不用执行交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println("第" + (i + 1) + "次排序");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
