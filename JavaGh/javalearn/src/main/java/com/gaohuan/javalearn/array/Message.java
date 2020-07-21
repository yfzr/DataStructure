package com.gaohuan.javalearn.array;

/**
 * 用以测试main函数的命令行参数args
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/12 15:37
 */
public class Message {
    public static void main(String[] args) {
        //命令行参数args是字符串数组，空格隔开，逐个读取命令行字符串
        //设置命令行参数标识：-h对应Hello，-g对应Goodbye
        if (args.length==0||args[0].equals("-h"))
            System.out.print("Hello,");
        else if (args[0].equals("-g"))
            System.out.print("Goodbye,");
        //输出命令行参数
        for (int i=1;i<args.length;i++) {
            System.out.print(" "+args[i]);
        }
        System.out.println("!");
    }
}
