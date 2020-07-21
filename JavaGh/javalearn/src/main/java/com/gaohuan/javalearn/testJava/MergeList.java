package com.gaohuan.javalearn.testJava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/15 14:22
 */
public class MergeList {
    public static List<Integer> mergeIntegerList(List<Integer> a1,List<Integer> a2) {
        if (a1==null || a1.size()==0) {
            return a2;
        }
        if (a2==null || a2.size()==0) {
            return a1;
        }
        List<Integer> result = new ArrayList<>();
        Integer len1 = a1.size();
        Integer len2 = a2.size();
        if (a1.get(len1-1)<a2.get(0)) {
            getValue(result,a1,0);
            getValue(result,a2,0);
        } else if (a1.get(0)>a2.get(len2-1)) {
            getValue(result,a2,0);
            getValue(result,a1,0);
        } else {
            Integer idx = 0;
            for (int i=0;i<len1;) {
                for (int j=idx;j<len2;) {
                    if (a1.get(i)<a2.get(j)) {
                        result.add(a1.get(i));
                        i++;
                        break;
                    } else if (a1.get(i)>a2.get(j)) {
                        result.add(a2.get(j));
                        idx++;
                        j++;
                        continue;
                    } else {
                        result.add(a1.get(i));
                        i++;
                        idx++;
                        break;
                    }
                }
                if (idx==len2) {
                    getValue(result,a1,i);
                    break;
                }
                if (i==len1) {
                    getValue(result,a2,idx);
                    break;
                }
            }
        }
        return result;
    }

    private static void getValue(List<Integer> result,List<Integer> a,Integer startIdx) {
        for (int i=startIdx;i<a.size();i++) {
            result.add(a.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(3);
        a2.add(5);
        a1.add(2);
        a1.add(4);
        a1.add(6);
        System.out.println(mergeIntegerList(a1,a2).toString());
    }
}
