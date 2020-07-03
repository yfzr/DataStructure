package com.sx.search;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int res = insertSearch(arr, 0, arr.length-1, 88);
        System.out.println("res = " + res);
    }

    /**
     * 插值查找：自适应mid，进行二分查找
     *      1）mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left])
     *      2）适合数据量比较大，关键字分布较均匀的查找表，关键字分布不均匀的情况下，不一定比二分法好
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int insertSearch(int[] arr, int left, int right, int value) {
        System.out.println("开始查找了...");
        //value < arr[left] || value > arr[right] 是必须的，否则mid可能越界
        if (left > right || value < arr[left] || value > arr[right]){
            return -1;
        }
        //自适应mid，一定程度上减少查找次数
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value > midValue){
            return insertSearch(arr, mid + 1, right, value);
        }else if (value < midValue){
            return insertSearch(arr, left, mid - 1 , value);
        }else {
            return mid;
        }
    }
}
