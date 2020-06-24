package com.sx.stack;

import com.sun.javafx.css.PseudoClassState;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args){
        //逆波兰表达式
        //String suffixExpression = "30 4 + 5 * 6 -";
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> list = getListString(suffixExpression);
//        System.out.println("list=" + list);
//        int res = calculate(list);
//        System.out.println("计算结果是：" + res);

        String expression = "10+((2+3)*4)-5";
        List<String> list1 = infixToList(expression);
        System.out.println("中缀表达式：" + list1);

        List<String> list2 = parseSuffixList(list1);
        System.out.println("中缀转后缀：" + list2);

        System.out.println(calculate(list2));
    }

    //将中缀表达式存放在List中
    public static List<String> infixToList(String expression){
        List<String> list = new ArrayList<>();
        int index = 0;
        char c;
        String temp;
        do {
            //判断该字符是否非数字
            if ((c = expression.charAt(index)) < 48 || (c = expression.charAt(index)) > 57){
                list.add("" + c);
                index++;
            }else {
                temp = "";
                while (index < expression.length() && (c = expression.charAt(index)) >= 48 && (c = expression.charAt(index)) <=57){
                    temp += c;
                    index++;
                }
                list.add(temp);
            }
        }while (index < expression.length());
        return list;
    }

    //将中缀表达式转换为后缀表达式，仍然放在List中
    public static List<String> parseSuffixList(List<String> list){
        //s1为符号栈
        Stack<String> s1 = new Stack<>();
        //由于另一个栈实际上没有出栈的操作，而且最后如果根据栈结构要进行逆序打印，所以可用List代替
        List<String> s2 = new ArrayList<>();
        for (String s: list) {
            if (s.matches("\\d+")){
                s2.add(s);
            }else if (s.equals("(")){
                s1.push(s);
            }else if (s.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //弹出最后的“（”
                s1.pop();
            }else {
                while (s1.size() > 0 && Operation.getValue(s1.peek()) >= Operation.getValue(s)){
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (s1.size() > 0){
            s2.add(s1.pop());
        }
        return s2;
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

//解决操作符优先级对比问题
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 1;
    private static int DIV = 1;
    //不同操作符对应不同的优先级数字
    public static int getValue(String operation){
        int res = 0;
        switch (operation){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                System.out.println("异常的运算符");
                break;
        }
        return res;
    }

}
