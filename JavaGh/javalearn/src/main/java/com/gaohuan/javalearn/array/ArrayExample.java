package com.gaohuan.javalearn.array;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * 数组是一种数据结构，用于存储同一类型数据的集合
 * 通过一个整型下标，可以访问到数组中相应的值
 * 数组下标是从0开始的，不是从1
 * @author gaoh28
 */
public class ArrayExample {

    private Integer lengthA;

    public void setLengthA(Integer lengthA) {
        this.lengthA = lengthA;
    }

    public Integer[] getArrayA(Integer length) {
        return new Integer[length];
    }

    private static Class printArray(String type) {
        Class a;
        switch (type) {
            case "int":
                a = int.class;
                break;
            case "double":
                a = double.class;
                break;
            case "Object":
                a = Object.class;
                break;
            default:
                System.out.println("输入类型需要为：int、double、Object三者之一");
                a = Class.class;
                break;
        }
        return a;
    }

    private static void printObjectArray(Object[] array) {
        System.out.print("输出未经赋值处理的"+array.getClass()+"数组所有元素的初始值：");
        for (Integer i=0;i<array.length;i++) {
            if (i==array.length-1) {
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i]+",");
        }
        System.out.println();
    }

    private static void printIntArray(int[] array) {
        System.out.print("输出未经赋值处理的int数组所有元素的初始值：");
        for (Integer i=0;i<array.length;i++) {
            if (i==array.length-1) {
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i]+",");
        }
        System.out.println();
    }

    private static void printDoubleArray(double[] array) {
        System.out.print("输出未经赋值处理的double数组所有元素的初始值：");
        for (Integer i=0;i<array.length;i++) {
            if (i==array.length-1) {
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i]+",");
        }
        System.out.println();
    }

    private static void printCharArray(char[] array) {
        System.out.print("输出未经赋值处理的double数组所有元素的初始值：");
        for (Integer i=0;i<array.length;i++) {
            if (i==array.length-1) {
                System.out.print(array[i]);
                continue;
            }
            System.out.print(array[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayExample arrayExample1 = new ArrayExample();
        //数组的声明，但没有初始化
        //也可以使用 Integer a[];
        //之所以使用Integer和Double，而非使用int和double，是为了便于利用Object模板化变量类型，
        // 比如当前类中的输出数组方法，其参数使用Object[]，可以代表Object的各种子类
        Integer[] a;
        //数组的初始化，初始化为一个可以存放10个Integer数据的数组
        //a = new Integer[10];
        //数组的初始化时，其长度可以不指定为常数，而用变量表示.但是一旦创建了数组，其length就不可以再改变
        //如果在运行过程中，要改变数组的大小length，应该使用另一种数据结构ArrayList
        arrayExample1.setLengthA(10);
        a = arrayExample1.getArrayA(arrayExample1.lengthA);
        System.out.println(a.length);
        //Object数组，所有元素初始化为null
        ArrayExample.printObjectArray(new Integer[10]);
        ArrayExample.printObjectArray(new Double[10]);
        ArrayExample.printObjectArray(new String[10]);
        //int数组和double数组初始值为0,，char数组的初始值为空格
        ArrayExample.printIntArray(new int[10]);
        ArrayExample.printDoubleArray(new double[10]);
        ArrayExample.printCharArray(new char[10]);
        //有个更简单的方式打印数组的值，使用Arrays.toString(各种数据类型的数组)
        System.out.println(Arrays.toString(new Object[10]));
        System.out.println(Arrays.toString(new int[10]));
        //数组初始化，数组的大小是大括号中初始值的个数
        //两种方式
        int[] small = {1,2,3,4,5};//方式1
        //方式2
        int[] small_backup;
        small_backup = new int[] {1,2,3,4,5};
        //输出初始化后的数组
        System.out.println(Arrays.toString(small));
        System.out.println(Arrays.toString(small_backup));
        //Java中允许数组长度为0，但长度为0的数组和null不同
        System.out.println(Arrays.toString(new int[0]));
        System.out.println(Arrays.toString(new int[0])==null);//输出false
        //数组拷贝
        int[] luckNumbers = small;
        System.out.println(luckNumbers[2]);
        System.out.println(Arrays.toString(luckNumbers));
        //luckNumbers和small是同一个数组的两个名字，两个变量将引用同一个数组
        luckNumbers[2] = 9;//now small[2] is alse 9
        System.out.println(small[2]);
        System.out.println(Arrays.toString(small));
        //如果希望将一个数组的所有值拷贝到一个新的数组中，需要用到Arrays的copyOf方法
        int[] newArray = Arrays.copyOf(luckNumbers,luckNumbers.length);
        System.out.println(Arrays.toString(newArray));
        //拷贝一个数组的前n个值到新的数组中，需要设置指定长度n【不大于原数组长度】
        int[] newArrayWithoutLast = Arrays.copyOf(luckNumbers,luckNumbers.length-1);
        System.out.println(Arrays.toString(newArrayWithoutLast));
        //该方法也可以用来增加数组长度，相对于原数组多余的元素补充默认值【0,false或者null】
        int[] newArrayWithDoubleNum = Arrays.copyOf(luckNumbers,2*luckNumbers.length);
        System.out.println(Arrays.toString(newArrayWithDoubleNum));

    }
}
