package com.byc.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrderList {
    @ApiModelProperty(value="订单id")
    private String id;
    @ApiModelProperty(value="支付金额")
    private float payment;
    @ApiModelProperty(value="地址")
    private String address;
    @ApiModelProperty(value="创建时间")

    private String creationTime;
    @ApiModelProperty(value="结束时间")

    private String endTime;
    @ApiModelProperty(value="用户id")
    private String userid;
    @ApiModelProperty(value="回收人员id")
    private String cycleid;
    @ApiModelProperty(value="订单状态")
    private int orderStatus;

    public OrderList(){}
    public OrderList(String id, float payment, String address, String creationTime, String endTime, String userid, String cycleid,int orderStatus) {
        this.id = id;
        this.payment = payment;
        this.address = address;
        this.creationTime = creationTime;
        this.endTime = endTime;
        this.userid = userid;
        this.cycleid = cycleid;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public float getPayment() {
        return payment;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getUserid() {
        return userid;
    }

    public String getCycleid() {
        return cycleid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }


    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setCycleid(String cycleid) {
        this.cycleid = cycleid;
    }

    public String getAddress() {
        return address;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
