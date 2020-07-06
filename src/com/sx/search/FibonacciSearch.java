package com.sx.search;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args){

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
     * @param arr
     * @param key 待查找的值
     * @return 返回对应的下标，如果不存在则返回-1
     */
    public static int fibSearch(int[] arr, int key){
        //TODO
        return -1;
    }
}
