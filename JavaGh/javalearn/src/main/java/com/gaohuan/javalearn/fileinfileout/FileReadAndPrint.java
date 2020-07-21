package com.gaohuan.javalearn.fileinfileout;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 文件读取与写入
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/8 14:39
 */
public class FileReadAndPrint {
    public static void main(String[] args) {
        String curDir = System.getProperty("user.dir");//获取当前路径
        System.out.println(curDir);
        try {
            //如果用一个不存在的文件构造scanner，或者用一个不能被创建的文件名构造printwriter，则会发生异常

            //对文件进行读取操作，需要用一个file对象构造一个scanner对象
            Scanner scanner = new Scanner(Paths.get("D:\\gaohuan.txt"), "UTF-8");
            //构造一个从给定字符串读取数据的scanner，注意这里的gaohuan.txt不是文件，而是一个字符串
            Scanner scanner1 = new Scanner("gaohuan.txt");
            //写入内容到文件，需要构造一个printwriter对象，在构造器中只需要提供文件名
            //指定当前路径curDir下的gaohuanhuan.txt文件为输出目标，如果没有该文件，则新建
            //下述定义会默认每次清空文件内容，然后执行写入
//            PrintWriter printWriter = new PrintWriter("gaohaunhuan.txt","UTF-8");
            //为了追加文件内容，需要使用FileWriter进行如下声明
            PrintWriter printWriter = new PrintWriter(new FileWriter("gaohaunhuan.txt",true));
            //执行写入内容到文件的操作
//            printWriter.print("gaohuan");//print方法不换行写入
            //println方法换行写入
            printWriter.println(scanner1.next());//直接将从字符串读取的内容写入到文件
            printWriter.println(scanner.next());//将从文件中读取的内容写入到另一个文件中
            //append方法会在文件原有内容基础上，追加新的内容
            printWriter.println("高欢喜欢李丹");
            //关闭文件，否则无法保存之前写入的数据
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
