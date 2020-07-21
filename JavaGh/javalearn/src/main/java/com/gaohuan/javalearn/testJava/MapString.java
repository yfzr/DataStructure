package com.gaohuan.javalearn.testJava;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/30 15:38
 */
public class MapString {
    public static void main(String[] args) throws NoSuchAlgorithmException {
//        Map<String,Object> gMap = new HashMap<>();
//        List<String> gao = new ArrayList<>();
//        gao.add("高");
//        gao.add("欢");
//        System.out.println(gao.toString());
//        gMap.put("gao",gao);
//        gMap.put("huan","[gao,huan]");
//        System.out.println(gMap.toString());
//        System.out.println(gao.get(0));
//        System.out.println(4909+1052+302);
        System.out.println(Math.random());
        SecureRandom number = SecureRandom.getInstance("SHA1PRNG");

        System.out.println(number.nextInt(10));
    }
}
