package com.sx.tree;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度O(nlog(n))
 * 测试大批量（800000）的排序时间约为20 ms
 */
public class HeapSort {
    public static void main(String[] args){
        //int[] arr = {4, 6, 8, 5, 9};
        //heapSort(arr);
        //System.out.println(Arrays.toString(arr));

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
        heapSort(arr);
        //LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.of("+8"));
        LocalDateTime localDateTime2 = LocalDateTime.now();
        //System.out.println(dtf.format(localDateTime2));
        System.out.println(localDateTime2);
    }

    /**
     * 堆排序
     * @param arr 待排序的数组
     */
    public static void heapSort(int[] arr){
        int temp = 0;
        //将无序序列构成一个大（小）顶堆，从最后一个的非叶子节点开始
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //将大（小）顶堆的根节点与最后的节点互换，每次交换结束都需要重新构建大（小）顶堆
        for (int i = arr.length-1; i > 0 ; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //每次都是将堆顶节点与最后一个节点交换，所以是0。当确定一个最大值后，就不需要变动，所以调整的节点数逐渐减少
            adjustHeap(arr, 0, i);
        }

    }

    /**
     * 调整二叉树，使其形成大（小）顶堆
     * @param arr 对应的数组
     * @param i 当前调整的非叶子节点索引
     * @param length 需要调整的节点数
     */
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        //从当前节点的左子节点开始
        for (int k = 2*i + 1; k < length; k = 2*k+1) {
            //如果右子节点大于左子节点，则指针需要指向右子节点
            if (k + 1 < length && arr[k] < arr[k+1]){
                k++;
            }
            //如果当前节点小于其子节点，则将当前节点换成子节点的值
            if (arr[i] < arr[k]){
                arr[i] = arr[k];
                //指针指向子节点，继续调整
                i = k;
            }else {
                break;
            }
        }
        //当前i为子节点的位置，子节点的值需要与前面父节点的值互换，最终完成堆调整的过程
        arr[i] = temp;
    }
}
