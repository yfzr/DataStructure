package com.sx.recursion;

public class MiGong {
    public static void main(String[] args){
        int[][] map = new int[8][7];
        //设置迷宫四周墙体，即值为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 1; i < 8-1; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板，值为1
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("迷宫初始化..");
        for (int[] row: map) {
            for (int value: row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        //setWay(map, 1, 1);
        setWay2(map, 1, 1);
        System.out.println("走出迷宫的路径如下");
        for (int[] row: map) {
            for (int value: row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 利用递归回溯来给小球找路
     * 约定：当map[i][j]为0表示该点未走过，1表示墙体，2表示通路，3表示走过但不是通路
     * 行进策略：下 -> 右 -> 上 -> 左，如果走不通，再回溯
     * @param map 地图
     * @param i 开始横坐标
     * @param j 开始纵坐标
     * @return 如果找到出口（6，5），返回true，否则false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                //递归向下试探
                if (setWay(map, i+1, j)){
                    return true;
                }
                //递归向右试探
                else if (setWay(map, i, j+1)){
                    return true;
                }
                //递归向上试探
                else if (setWay(map, i-1, j)){
                    return true;
                }
                //递归向左试探
                else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    //改变行进策略：上 -> 右 -> 下 -> 左
    public static boolean setWay2(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                //递归向上试探
                if (setWay2(map, i-1, j)){
                    return true;
                }
                //递归向右试探
                else if (setWay2(map, i, j+1)){
                    return true;
                }
                //递归向下试探
                else if (setWay2(map, i+1, j)){
                    return true;
                }
                //递归向左试探
                else if (setWay2(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
