package com.gaohuan.javalearn.variable;

/**
 * 要点：类型转换
 * 注意：自动转换和强制转换
 * @author gaoh28
 */
public class TypeConversion {

    public static void main(String[] args) {

        //新冠肺炎截止至2020年2月28日的病死率：死亡人数/患病人数
        //需要将数字先进行强制类型转换，转换为double，然后再进行计算。否则，输出0
        //输出0.03534656349337015，也即当前死亡率为3.5%
        //两次输出结果相同，说明当整型与浮点型double进行计算时，整型先转换为double型，然后再参与计算
        System.out.println("新冠肺炎截止至2020年2月28日的病死率："+(2791/((double)78961)));
        System.out.println("新冠肺炎截止至2020年2月28日的病死率："+(((double)2791)/((double)78961)));
        //输出0.035346564，说明当整型与浮点型float进行计算时，整型先转换为float型，然后再参与计算
        System.out.println("新冠肺炎截止至2020年2月28日的病死率："+(2791/((float)78961)));

        System.out.println("浮点数除以0等于无穷大。例如1.0/0="+(double)1/0);

        try {
            System.out.println("整数除以0不会出现异常。例如1/0="+1/0);
        } catch (Exception e) {
            System.out.println("整数除以0出现异常。报错信息："+e.getMessage());
        }
    }
}
