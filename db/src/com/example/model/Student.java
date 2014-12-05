package com.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-5
 * Time: 上午10:45
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    Integer id;
    String name;
    Integer age;
    Integer grade;
    String info;

    public Student(String name, Integer age, Integer grade, String info) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.info = info;
    }

    public Student() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getInfo() {
        return info;
    }
}
