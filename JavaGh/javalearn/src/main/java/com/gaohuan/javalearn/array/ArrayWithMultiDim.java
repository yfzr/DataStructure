package com.gaohuan.javalearn.array;

import java.util.Arrays;

/**
 * 多维数组
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/13 6:03
 */
public class ArrayWithMultiDim {
    public static void main(String[] args) {
        //声明一个二维数组
        int[][] array;
        //与一维数组一样，在调用new对多维数组进行初始化之前不能使用它
        array = new int[5][5];
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                array[i][j] = (int) (100*Math.random());//0-100【不包含100】的随机整数
            }
        }
//        System.out.println((int)(9.7));//输出9，说明int取整为直接去小数取整
        for (int i2=0;i2<5;i2++)
            System.out.println(Arrays.toString(array[i2]));//输出二维数组
        //另一种二维数组初始化
        int[][] array1 = {{1,3,5},{2,4,6}};
        //Java中实际上没有多维数组，只有一维数组，多维数组被解释为“数组的数组”
        System.out.println(array1.length);//输出2，表示第一维的维数，也即二维数组中所包含一维数组的个数
        for (int i12=0;i12<array1.length;i12++)
            System.out.println(Arrays.toString(array1[i12]));
        System.out.println(Arrays.deepToString(array1));//快速打印二维数组
    }
}
