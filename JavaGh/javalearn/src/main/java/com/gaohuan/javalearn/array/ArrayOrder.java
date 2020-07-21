package com.gaohuan.javalearn.array;

import java.util.Arrays;

/**
 * 数组排序
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/12 16:46
 */
public class ArrayOrder {
    public static void main(String[] args) {
        //对数组进行排序，可以使用Arrays类中的sort方法
        int[] a = {14,15,11,2,5,7,38};
        System.out.print("排序前的数组：");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);//直接该变数组结构，即排序后的数组赋值于原数组
        System.out.print("排序后的数组：");
        System.out.println(Arrays.toString(a));
        int[] sub2 = ArrayOrder.randomForK(a,a.length-3);
        System.out.println(Arrays.toString(sub2));
    }

    private static int[] randomForK(int[] array,int k) {
        int[] result = new int[k];
        //如果要随机选择元素的个数k大于原始数组的长度，则返回null
        if (k>array.length)
            return null;
        int r = 0;//初始化随机索引为0
        int n = array.length;
        for (int i=0;i<k;i++){
            //Math.random方法返回一个[0,1)之间的随机浮点数，用数组长度array.length乘以该随机浮点数，可以得到一个[0,n-1]之间的随机整数
            r = (int) (Math.random()*n);
            result[i] = array[r];
            array[r] = array[n-1];//避免抽取重复元素
            //经过上述main函数的实际应用，该算法还是会抽取重复元素【array[n-1]会被重复多次】，需要加上下述语句，以不断更新n和array[n-1]
            n=n-1;//不断更新n，以避免重复
        }
        return result;
    }
}
