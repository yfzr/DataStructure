package com.sx.sort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {3, 9, -1, 10, 20};

        //测试大批量数据的排序时间
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("+8"));
        System.out.println(localDateTime1.toString());

        bubbleSort(arr);

        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2.toString());
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //优化：如果没有进行交换，则可以结束排序
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            //System.out.println("第" + (i + 1) + "次冒泡排序");
            //System.out.println(Arrays.toString(arr));
        }
    }

}
