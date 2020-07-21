package com.gaohuan.javalearn.ailiyun;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/24 15:10
 */
public class AliyunQuestion2 {

    public static void main(String[] args) {
        /**
         * 关于自增运算的说明
         */
        int k=0;
        System.out.println(k++);//0
        /**
         * System.out.println(k++);
         * ||
         * System.out.println(k);
         * k=k+1;
         */
        System.out.println(k);//1

        int p=0;
        System.out.println(++p);//1
        /**
         * System.out.println(++p);
         * ||
         * p=p+1;
         * System.out.println(p);
         */
        System.out.println(p);//1

        int i=1;
        //先执行赋值，再执行自增
        int j=i++;
        /**
         * int j=i++;
         * ||
         * int j=i;
         * i=i+1;
         */
        //由于自增运算的优先级高于比较运算符，这里的小括号是否存在，对比较结果没有影响
        /**
         * (i==(++j))
         * ||
         * j=j+1;
         * i==j;
         *
         *
         * ((i++)==j)
         * ||
         * i==j;
         * i=i+1;
         */
        if ((i==(++j))&&((i++)==j)) {
            i+=j;
        }
        System.out.println("i="+i);
    }
}
