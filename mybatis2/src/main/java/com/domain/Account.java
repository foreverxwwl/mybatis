package com.domain;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-04 20:23
 * 账户表
 */
public class Account {
    //基本属性
    private int id;
    private int uid;
    private double money;


    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", users=" + user +
                '}';
    }
}
