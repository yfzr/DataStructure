package com.sx.recursion;

public class Queens {
    int max = 8;
    //可以使用一个一维数组存放皇后的位置，索引表示行坐标，值表示列坐标
    int[] arr = new int[max];
    //统计摆放的方法总数
    static int count = 0;
    //统计经历的冲突判断次数
    static int judgeCount = 0;
    public static void main(String[] args){
        Queens queens = new Queens();
        queens.setQueen(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共经历了%d次的冲突判断\n", judgeCount);
    }

    //显示皇后的位置
    private void print(){
        //统计方法总数
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //判断当摆放第n个皇后时（初始为0），是否存在冲突
    private boolean judge(int n){
        //统计经历的冲突判断
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //判断当前放置的皇后和前面的皇后是否在同一列或者在同一斜线上（两者不会在同一行上），若是，则冲突
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        //当前无冲突
        return true;
    }

    //第n个皇后的放置方法,从0开始
    private void setQueen(int n){
        //当n=8，表示0~7一共8个皇后放置完毕
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //每个皇后都从行的第一列开始放置
            arr[n] = i;
            //如果没有冲突，则继续放置下一个皇后
            if (judge(n)){
                setQueen(n + 1);
            }
            //当存在冲突时，需要将当前皇后右移一位，继续判断，则进入下一层循环即可
        }
    }
}
