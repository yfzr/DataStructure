package com.sx.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 基数排序
 * 时间复杂度O(n*k) k-桶的个数
 * 测试大批量（800000）的排序时间约为90 ms
 */
public class RadixSort {
    public static void main(String[] args){
        //int[] arr = {53,3,542,748,14,214};
        //radixSort(arr);
        //System.out.println("基数排序的结果：" + Arrays.toString(arr));

        //大批量插入排序测试
        int[] arr = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        //String s = "yyyy-MM-dd hh:mm:ss";
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(s);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime1));
        System.out.println(localDateTime1);
        //shellSort(arr);
        radixSort(arr);
        //LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        LocalDateTime localDateTime2 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime2));
        System.out.println(localDateTime2);
    }

    public static void radixSort(int[] arr){
        //找出数组中的最大值，并确定其有几位
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //创建桶，由于放入每个桶中的数据量未知，所以桶的大小定义为数组的长度，经典的空间换时间算法
        int[][] bucket = new int[10][arr.length];
        //用于统计每个桶中的数据个数
        int[] bucketElementCounts = new int[10];

        //开始排序，排序的次数即为最大值的位数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //遍历数组，将其放入对应的桶中
            for (int j = 0; j < arr.length; j++) {
                //获取数据在每次排序中对应位上的值，从而放入对应的桶中
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            //将桶中的值依次取出，放入原数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0){
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        arr[index] = bucket[k][j];
                        index++;
                    }
                }
                //每取出一个桶的数据，需要将改桶的数据统计归零，用于下一次的重新统计
                bucketElementCounts[k] = 0;
            }
            //System.out.println("第" + (i+1) +"轮的排序结果：" + Arrays.toString(arr));
        }
    }
}
