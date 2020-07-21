package com.gaohuan.javalearn.fatherson;

/**
 * 子类
 * @author gaoh28
 * @version 1.0
 * @date 2020/6/23 16:34
 */
public class Son extends Father {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Son{" +
                "familyName='" + this.getFamilyName() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
