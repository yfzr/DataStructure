package com.gaohuan.javalearn.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/7/20 9:32
 */
public class ArrayGH {

    Integer[] array;

    public static void main(String[] args) {
        ArrayGH arrayGH = new ArrayGH();
        arrayGH.array = new Integer[]{11,12,13,14};
        System.out.println("数组初始化前=======>");
        for (Integer i:arrayGH.array) {
            System.out.print(i+" ");
        }
        System.out.println();
        //数组初始化赋值
        for (int j=0;j<arrayGH.array.length;j++) {
            arrayGH.array[j]=j;
        }
        System.out.println("数组初始化后======>");
        for (Integer k:arrayGH.array) {
            System.out.print(k+" ");
        }
        System.out.println();

        //给数组添加元素，需要list作为中介
        List<Integer> integerList = new ArrayList(Arrays.asList(arrayGH.array));
        integerList.add(10);//给列表添加元素
        Integer[] newArray = new Integer[integerList.size()];
        integerList.toArray(newArray);//将列表转化为array
        System.out.println("添加元素后的数组========>");
        for (Integer i : newArray) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
