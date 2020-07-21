package com.gaohuan.javalearn.testJava;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/4 13:20
 */
public class TempTest {
    public static void main(String[] args) {
//        if (1==1) {
//            System.out.println(1);
//        } else if (2==2) {
//            System.out.println(2);
//        }
//        HttpPost httpPost = new HttpPost("");
//        // 配置请求参数实例
//        //RequestConfig使用了lombok工具包，使用下述代码创建实例对象并设置各字段的值
//        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
//                .setConnectionRequestTimeout(35000)// 设置连接请求超时时间
//                .setSocketTimeout(60000)// 设置读取数据连接超时时间
//                .build();
//        // 为httpPost实例设置配置
//        httpPost.setConfig(requestConfig);
//        // 设置请求头
//        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
//        httpPost.setHeader("Accept", "application/json");
//        //token不为null时，设置请求头中的token认证项
//        httpPost.setHeader("Authorization", "Bearer AccessToken");
//        Header header = httpPost.getFirstHeader("cookie");
//        System.out.println(header.getName()+header.getValue());
//        System.out.println(header.getElements());
//        int count = 0;
//        for (int i=0;i<100;i++) {
//            int index = (int) Math.floor(Math.random() * 10);
//            System.out.println(index);
//            if (index>=10) {
//                count=count+1;
//            }
//        }
//        System.out.println("不小于10的个数"+count);

//        System.out.println(ThreadLocalRandom.current().nextInt(100, 999));

//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))
//                + LocalDateTime.now().toString().substring(20));

        SecureRandom randomNumber = null;
        try {
            randomNumber = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(randomNumber.nextInt(999));

        System.out.println(LocalDateTime.now().toString().substring(20));
    }
}
