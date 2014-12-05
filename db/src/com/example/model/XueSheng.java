package com.example.model;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-5
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class XueSheng implements Serializable {
    private static final long serialVersionUID = -5683263669918171030L;

    @DatabaseField(id=true)
    private String stuNO;
    @DatabaseField
    private String name;
    @DatabaseField
    private int age;
    @DatabaseField
    private String sex;
    @DatabaseField
    private double score;
    @DatabaseField
    private String address;

    public void setStuNO(String stuNO) {
        this.stuNO = stuNO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStuNO() {
        return stuNO;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getScore() {
        return score;
    }

    public String getAddress() {
        return address;
    }
}
