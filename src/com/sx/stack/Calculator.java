package com.sx.stack;

public class Calculator {
    public static void main(String[] args){
        String expression = "40+7*20-5";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int num1 = 0, num2 = 0, operator = 0;
        int index = 0, res = 0;
        char ch;
        String keepNum = "";
        //扫描表达式
        while (true){
            ch = expression.substring(index, index+1).charAt(0);
            if (operStack.isOperator(ch)){
                if (!operStack.isEmpty()){  //判断非空，表示有操作符
                    //进行当前操作符与符号栈中顶层操作符的优先级比较
                    if (operStack.priority(ch) <= operStack.priority((char) operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operStack.pop();
                        res = numStack.calculate(num1, num2, (char) operator);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        //当前操作符的优先级大于符号栈中顶层操作符的优先级，直接入栈
                        operStack.push(ch);
                    }
                }else {
                    //如果符号栈为空，直接入栈
                    operStack.push(ch);
                }
            }else {
                //如果是数字，入数栈
                //numStack.push(ch-48);
                //如果是多位数，则需要判断当前index后的一位是否是符号位，如果是符号位，才可以入栈，否则需要拼接扫描到的字符
                keepNum += ch;
                //当已经扫描至最后一位，则直接入栈
                if (index >= expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        //扫描完毕，顺序进行计算
        while (true){
            //当符号栈为空时，表示计算已经结束，数栈中剩余最后的结果
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operStack.pop();
            res = numStack.calculate(num1, num2, (char) operator);
            numStack.push(res);
        }
        System.out.printf("%s = %d", expression, numStack.pop());
    }
}

//数组结构实现栈
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //获取栈顶数据，但不出栈
    public int peek(){
        return stack[top];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，数字越大，优先级越高
    public int priority(char operator){
        if (operator == '*' || operator == '/'){
            return 1;
        }else if (operator == '+' || operator == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOperator(char val){
        return val == '+' || val =='-' || val == '*' || val == '/';
    }

    //计算方法
    public int calculate(int num1, int num2, char operator){
        int res = 0;
        switch (operator){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
