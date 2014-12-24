package com.example;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-24
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
public class People {
    public String name;
    public String sex;
    public String age;

    public People() {
    }

    public People(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }
}
