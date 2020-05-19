package com.byc.vo;

import java.io.Serializable;

public class Commodity implements Serializable {
    //可回收物id
    private String id;
    //可回收物名称
    private String gName;
    //可回收物价格
    private float gPrice;
    //可回收物数量
    private  float amount;
    //单项商品回收总价
    private float cycleMoney;

    public Commodity(){}

    public Commodity(String id, String gName, float gPrice, float amount, float cycleMoney) {
        this.id = id;
        this.gName = gName;
        this.gPrice = gPrice;
        this.amount = amount;
        this.cycleMoney = cycleMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public float getgPrice() {
        return gPrice;
    }
    // 单项商品的总价为单价乘以数量
    public void setgPrice() {
        this.gPrice = this.amount*this.gPrice;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getCycleMoney() {
        return cycleMoney;
    }

    public void setCycleMoney(float cycleMoney) {
        this.cycleMoney = cycleMoney;
    }
}
