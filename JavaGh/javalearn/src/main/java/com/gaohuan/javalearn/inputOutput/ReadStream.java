package com.gaohuan.javalearn.inputOutput;

import java.io.Console;
import java.util.Scanner;

/**
 * 从控制台读取输入流
 * @author gaoh28
 * @version 1.0
 * @date 2020/3/25 9:21
 */
public class ReadStream {
    public static void main(String[] args) {
        //要想通过控制台输入，首先需要构造一个scanner对象，并与system.in关联
        Scanner scanner = new Scanner(System.in);
        //现在可以使用scanner类的各种输入操作
        System.out.println("what is your name?");
        String name = scanner.nextLine();//使用nextLine方法读取一行
        System.out.println("my name is "+name);
        System.out.println("what is your familyname?");
        String familyName = scanner.next();//使用next方法读取一个单词，该方法以空白作为分隔符
        System.out.println("my familyname is "+familyName);
        System.out.println("how old are you?");
        int age = scanner.nextInt();//使用nextInt方法读取整数
        System.out.println("i am "+age+" years old");
        System.out.println("how much is the basketball?");
        double price = scanner.nextDouble();//使用nextDouble方法读取浮点数
        System.out.println("the basketball is "+price+" yuan");

        //由于scanner类的输入可见，不适用于从控制台读取密码。console类可以实现不可见输入功能
        //System.console()方法与虚拟机是否具有控制台有关系，如果有，那么就可以使用，没有则该方法返回null
//        Console console = System.console();//Java se 6提供
//        String username = console.readLine("User name:");
//        char[] password = console.readPassword("password:");
//        System.out.println("username is "+username);
//        System.out.println("password is "+password);
    }
}
