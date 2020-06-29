package com.sx.sort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n^2)
 * 测试大批量（80000）的排序时间约为1400 ms
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1, -1, 89};
        //insertSort(arr);

        //大批量插入排序测试
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        //String s = "yyyy-MM-dd hh:mm:ss";
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(s);
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("+8"));
        //System.out.println(dtf.format(localDateTime1));
        System.out.println(localDateTime1);
        insertSort(arr);
        LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        //System.out.println(dtf.format(localDateTime2));
        System.out.println(localDateTime2);
    }

    /**
     * 插入排序
     * 将第一个数默认为有序表，后面第（n-1）个数看成无序表。每次将无序表的第一个数与有序表最后一个数进行比较插入（排序为从小到大）。
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //待插入的位置
        int insertIndex;
        //待插入的值
        int insertValue;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
            //System.out.println("第" + i +"轮插入");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
