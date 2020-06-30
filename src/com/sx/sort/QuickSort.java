package com.sx.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度O(nlog(n))
 * 测试大批量（80000）的排序时间约为20~30 ms
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {-9, 78, 0, 23, -567, 70};
        //quickSort(arr, 0, arr.length - 1);
        //System.out.println("快速排序的结果：" + Arrays.toString(arr));

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
        quickSort(arr, 0, arr.length - 1);
        //LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        LocalDateTime localDateTime2 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime2));
        System.out.println(localDateTime2);

    }

    /**
     * 快速排序：选定一个基准值，比基准值大（小）的放在基准值右边，比基准值小（大）的放在基准值左边
     *
     * @param arr   待排序数组
     * @param left  数组的左下标
     * @param right 数组的右下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        //数组中间值
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            //只要arr[l]小于中间值，表示满足条件，就继续往右查找
            while (arr[l] < pivot) {
                l += 1;
            }
            //只要arr[r]大于中间值，表示满足条件，就继续往左查找
            while (arr[r] > pivot) {
                r -= 1;
            }
            //因为l或r经历的索引值都表示已经满足排序条件，所以当l >= r时，必然左边都小于pivot，右边都大于pivot
            if (l >= r) {
                break;
            }
            //将不满足排序条件的左右值进行互换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //当右边没有找到值时，会在遍历至pivot时退出，与左边交换后，其值大于pivot，则需要往左一步，继续查找
            if (arr[l] == pivot) {
                r -= 1;
            }
            //当左边没有找到值时，会在遍历至pivot时退出，与右边交换后，其值小于pivot，则需要往右一步，继续查找
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果两边都没有找到，则l==r，需要各自往前一步，否则会有栈溢出的情况
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //用递归继续为两边的数据进行快速排序
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
