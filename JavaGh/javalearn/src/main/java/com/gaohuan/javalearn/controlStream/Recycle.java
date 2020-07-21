package com.gaohuan.javalearn.controlStream;

import com.gaohuan.javalearn.formOutput.FormOutput;

import java.util.*;

/**
 * 循环语句
 * 当一个方法希望只被本类使用【private】，并且该方法与本类的内部状态无关【static】【不需要创建类的实例，就可以使用该方法】时，要声明该方法为private static
 * @author gaoh28
 * @version 1.0
 * @date 2020/4/8 16:28
 */
public class Recycle {
    public static void main(String[] args) {
        //测试FormOutput类的public static声明的方法outputMyName
        FormOutput.outputMyName("高欢");
        //测试当前类的private static声明的方法LoveLiDan
        Recycle.LoveLiDan("高欢");
        //测试while循环【由于先判断循环变量是否满足条件，有可能循环体一次也不执行】
        int i=0;
        int sum=0;
        while (i<10) {
            sum=sum+i;
            i++;
        }
        System.out.println("测试while循环，1+2+...+9="+sum);
        //测试for循环【由于先判断循环变量是否满足条件，有可能循环体一次也不执行】
        sum = 0;
        for (int j=0;j<10;j++) {
            sum=sum+j;
        }
        System.out.println("测试for循环，1+2+...+9="+sum);
        //测试do...while循环【循环体至少执行一次】
        int k=0;
        sum=0;
        do {
            sum=sum+k;
            k++;
        } while (k<10);
        System.out.println("测试do...while循环，1+2+...+9="+sum);
        //测试for循环之循环变量为浮点数的情况
        // 由于浮点数有舍入误差，无法精准判断是否相等，从而无法使用循环条件使其终止，这里使用if判断循环执行次数及break跳出循环
        int number=0;
        for (double n=0.1;n!=10.0;n=n+0.1) {
            number++;
            if (n>100) {
                System.out.println("循环次数："+number+"次！！！通过break语句才跳出循环。");
                break;
            }
        }
        //测试switch语句
        Scanner scanner = new Scanner(System.in);
        System.out.println("select an option (1,2,3,4)");
        int choice = scanner.nextInt();
        //case条件只是决定了当前分支结构执行的起点，并不是终点，
        //因此为了仅执行对应case的语句块，需要在每个case语句块的最后加上break
        //如果不加break，代码会从满足case条件的起点开始执行，直至后续所有case执行完毕
        //case标签可以是整数、字符串
        switch (choice) {
            case 1:
                System.out.println("您选择了1，请嫁给高欢吧。");
                break;//break语句可以用于退出循环体和switch语句
            case 2:
                System.out.println("您选择了2，请和高欢结婚吧。");
                break;
            case 3:
                System.out.println("您选择了3，请和高欢白头到老。");
                break;
            case 4:
                System.out.println("您选择了4，请和高欢相守一生");
                break;
            default:
                System.out.println("奶奶的，你输入了啥？请去咨询高欢：猪是怎么笨死的？");
                break;
        }
        //Java中带标签的break语句，用于跳出多重嵌套的循环语句
        for (int bi=0;bi<10;bi++) {
            gaohuan://带标签的break语句之第一组成部分
            for (int bj=10;bj>bi;bj--) {
                for (int bk=1;bk<29;bk++) {
//                    System.out.println("执行第"+bk+"次循环。");
                    if (bi>5) {
                        /**
                         * break语句输出：
                         * 当前bi值和bj值分别为：6和10
                         * 跳出循环。
                         * 当前bi值和bj值分别为：6和9
                         * 跳出循环。
                         * 当前bi值和bj值分别为：6和8
                         * 跳出循环。
                         * 当前bi值和bj值分别为：6和7
                         * 跳出循环。
                         * 当前bi值和bj值分别为：7和10
                         * 跳出循环。
                         * 当前bi值和bj值分别为：7和9
                         * 跳出循环。
                         * 当前bi值和bj值分别为：7和8
                         * 跳出循环。
                         * 当前bi值和bj值分别为：8和10
                         * 跳出循环。
                         * 当前bi值和bj值分别为：8和9
                         * 跳出循环。
                         * 当前bi值和bj值分别为：9和10
                         * 跳出循环。
                         *
                         * 分析：
                         * bi=6,7,8,9表明满足了bi>5的条件，触发break， 而bj的值一直满足bj>bi，表明进入了第二层循环体。
                         * 由上可知break语句的功能是跳出其所在的当前循环体，即跳出一层循环体
                         */
                        /**
                         * 带标签的break语句执行结果：
                         * 当前bi值和bj值分别为：6和10
                         * 跳出循环。
                         * 当前bi值和bj值分别为：7和10
                         * 跳出循环。
                         * 当前bi值和bj值分别为：8和10
                         * 跳出循环。
                         * 当前bi值和bj值分别为：9和10
                         * 跳出循环。
                         *
                         * 分析：
                         * bi=6,7,8,9表明满足了bi>5的条件，触发break gaohuan， bj=10表明没有进行第二层循环。
                         * 满足条件时，break gaohuan直接跳到了标签gaohuan所在位置。
                         */
                        System.out.println("当前bi值和bj值分别为："+bi+"和"+bj);
                        System.out.println("跳出循环。");
                        break gaohuan;//带标签的break语句之第二组成部分
//                        break;
                    }
                }
            }
        }
        //Java中除了break语句，还有continue语句，用于跳出当前一次循环，继续进行下一次循环
        for (int ci=0;ci<4;ci++) {
            System.out.println("高欢喜欢李丹。");
            if (ci>2) {
                System.out.println("已经说三次了");
                continue;
            }
            System.out.println("只说三次就可以了。");
        }
        //for each循环，一种功能增强的for循环，对数组或者集合直接进行遍历
        for (int element : new int[10]) {
            System.out.println(element);
        }
        List<String> list = new ArrayList<>();
        list.add("高欢");
        list.add("李丹");
        list.add("百年好合");
        for (String element : list) {
            System.out.print(element);
        }
        System.out.println();
        Collection<String> collection = new ArrayList<>();
        ((ArrayList<String>) collection).add(0,"高欢");
        ((ArrayList<String>) collection).add(1,"喜欢");
        ((ArrayList<String>) collection).add(2,"李丹");
        for (String item:collection) {
            System.out.print(item);
        }
        System.out.println();
        Collection<String> stringCollection = new HashSet<>();
        stringCollection.add("高欢");
        stringCollection.add("爱");
        stringCollection.add("李丹");
        System.out.println(stringCollection.toString());//无序输出：[爱, 李丹, 高欢]
        Collection<String> strings = new LinkedList<>();
        ((LinkedList<String>) strings).add(0,"高欢");
        strings.add("爱");
        ((LinkedList<String>) strings).addFirst("李丹");
        System.out.println(strings.toString());
    }

    private static void LoveLiDan(String me) {
        System.out.printf("%s爱李丹！",me);
        System.out.println();//换行
    }
}
