package com.sx.stack;

import com.sun.javafx.css.PseudoClassState;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args){
        //逆波兰表达式
        //String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpression);
        System.out.println("list=" + list);
        int res = calculate(list);
        System.out.println("计算结果是：" + res);
    }

    //将一个逆波兰表达式的数据和符号依次存入List中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String item: split) {
            list.add(item);
        }
        return list;
    }

    //逆波兰表达式计算过程
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item: list) {
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num2 - num1;
                }else if (item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
