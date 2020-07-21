package com.gaohuan.javalearn.tryCatchThrow;

import java.io.IOException;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/7/13 15:03
 */
class ExceptionForString extends Exception {
    public ExceptionForString(String message) {
        super(message+"String");
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"String";
    }
}

class ExceptionForInteger extends ExceptionForString {
    public ExceptionForInteger(String message) {
        super(message+"Integer");
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"Integer";
    }
}

public class ThrowTryCatch {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void add3() throws ExceptionForInteger {
        if (this.getNumber()==null) {
            throw new ExceptionForInteger("number参数为空");
        }
        this.setNumber(this.getNumber()+3);
    }

    public void printName() throws ExceptionForString{
        String name = this.getName();
        if (name==null)
            throw new ExceptionForString("name参数为空");
        //没有抛出异常，则执行输出；出现异常，则抛出异常，不执行其后代码
        System.out.println(name);
    }

    public static void main(String[] args) {
        ThrowTryCatch tryCatch = new ThrowTryCatch();
//        tryCatch.setName("高欢");
        try {
            tryCatch.printName();
            tryCatch.add3();
        } catch (ExceptionForInteger exceptionForInteger) {
            System.out.println(exceptionForInteger.getMessage());
        } catch (ExceptionForString exceptionForString) {
            System.out.println(exceptionForString.getMessage());
        } finally {
            System.out.println("finally语句块执行了");
        }
        System.out.println("异常处理外的语句执行了");

        System.out.println("==================================分界线===================================");

        String[] array = {"高","欢"};

        for (int i=0;i<5;i++) {
            try {
                System.out.println(array[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("CATCH:"+e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("CATCH"+e.getMessage());
            } finally {
                System.out.println("finally语句执行了第"+(i+1)+"次");
            }
        }
    }
}
