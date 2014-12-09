package com.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-12-9
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String married;
    private String gender;

    public User() {
    }

    public User(Integer id, String username, String password, Integer age, String married, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.married = married;
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getMarried() {
        return married;
    }

    public String getGender() {
        return gender;
    }
}
