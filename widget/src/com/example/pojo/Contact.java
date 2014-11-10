package com.example.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-4
 * Time: 下午1:59
 * To change this template use File | Settings | File Templates.
 */
public class Contact {
    private Integer id;
    private String name;
    private String amount;
    private String mobile;

    public Contact(Integer id, String name, String amount, String mobile) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
