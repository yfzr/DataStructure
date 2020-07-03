package com.sx.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        //int res = binarySearch(arr, 0, arr.length - 1, 89);
        //System.out.println("res=" + res);

        List<Integer> list = binarySearch2(arr, 0, arr.length-1, 1000);
        System.out.println("list=" + list);
    }

    /**
     * 二分查找
     *
     * @param arr   有序序列
     * @param left  序列左下标
     * @param right 序列右下标
     * @param value 待查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {
        //当找不到目标值时，返回-1
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        //递归查找
        if (value > midValue) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (value < midValue) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找：可以找到多个相同的值
     *
     * @param arr   有序序列
     * @param left  序列左下标
     * @param right 序列右下标
     * @param value 待查找的值
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        //当找不到目标值时，返回空集合
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        //递归查找
        if (value > midValue) {
            return binarySearch2(arr, mid + 1, right, value);
        } else if (value < midValue) {
            return binarySearch2(arr, left, mid - 1, value);
        } else {
            int temp = mid - 1;
            List<Integer> list = new ArrayList<>();
            //当找到目标值时，向左扫描，查找相同值
            while (true) {
                if (temp < 0 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);
            //当找到目标值时，向右扫描，查找相同值
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != value) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
