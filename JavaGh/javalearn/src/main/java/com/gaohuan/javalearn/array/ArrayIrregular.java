package com.gaohuan.javalearn.array;

import java.util.Arrays;

/**
 * 不规则数组
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/13 9:52
 */
public class ArrayIrregular {
    public static void main(String[] args) {
        //不规则数组，即数组的每一行有不同的长度
        //数组声明时，仅指定第一维的长度，不指定第二维
        int[][] array = new int[2][];
        for (int i=0;i<array.length;i++) {
            array[i] = new int[i+1];//需要对每一行分配数组维数，然后才能赋值处理
            for (int j=0;j<i+1;j++)
                array[i][j]=i+j;
        }
        //输出不规则数组
        for (int i=0;i<array.length;i++)
            System.out.println(Arrays.toString(array[i]));
    }
}
