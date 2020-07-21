package com.gaohuan.javalearn.fatherson;

/**
 * 父类
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/23 16:29
 */
public class Father {
    private String familyName;

    private String name;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = this.familyName+name;
    }

    @Override
    public String toString() {
        return "Father{" +
                "familyName='" + familyName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
