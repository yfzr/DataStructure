package com.gaohuan.javalearn.fatherson;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/23 16:35
 */
public class Test {

    public static void main(String[] args) {
        Father father = new Father();
        father.setFamilyName("高");
        father.setName("留成");
        System.out.println(father.toString());//Father{familyName='高', name='高留成'}

        Son son = new Son();
        son.setFamilyName("高");
        son.setName("欢");
        son.setSchool("北京邮电大学");
        System.out.println(son.toString());//Son{familyName='null', name='高欢', school='北京邮电大学'}

        Father a = new Son();
        System.out.println(a.toString());//Son{familyName='null', name='null', school='null'}
        ((Son) a).setSchool("河南大学");
        System.out.println(a.toString());//Son{familyName='null', name='null', school='河南大学'}

        // Son b = new Father(); // 报错
    }
}
