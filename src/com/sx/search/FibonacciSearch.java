package com.sx.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args){
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println("index=" + fibSearch(arr, 100));
    }

    //创建斐波那契数列
    public static int[] fib(){
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }

    /**
     * 斐波那契查找
     * 根据f[k] = f[k - 1] +f[k - 2]  -->  mid = row + f[k - 1] - 1
     * @param arr 原始有序数组
     * @param key 待查找的值
     * @return 返回对应的下标，如果不存在则返回-1
     */
    public static int fibSearch(int[] arr, int key){
        //原数组索引最小值
        int row = 0;
        //原数组索引最大值
        int high = arr.length - 1;
        //用于匹配相关的斐波那契数列的值
        int k = 0;
        //存放中间值
        int mid;
        //获取斐波那契数列
        int[] f = fib();
        //为原始数组匹配相当长度的斐波那契数列 k 值
        while (high > f[k] - 1){
            k++;
        }
        //将原始数组的数据放入一个暂时数组，这个暂时的数组长度根据斐波那契数列的 k 值设置
        int[] temp = Arrays.copyOf(arr, f[k] - 1);
        //超出原始数组的空间都用原始数组的最大值填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        //开始查找
        while (row <= high){
            //推算得到的mid
            mid = row + f[k - 1] - 1;
            //当目标值小于mid值，继续在左边f[k - 1]的数据中查找
            if (key < temp[mid]){
                high = mid - 1;
                k--;
            //当目标值大于mid值，继续在右边f[k - 2]的数据中查找
            }else if (key > temp[mid]){
                row = mid + 1;
                k -= 2;
            //找到mid
            }else {
                //如果mid在原数组长度内，则可直接返回mid
                if (mid <= high){
                    return mid;
                //mid可能在补充的长度内，则查找的值就是high
                }else {
                    return high;
                }
            }
        }
        //找不到，则返回-1
        return -1;
    }
}
