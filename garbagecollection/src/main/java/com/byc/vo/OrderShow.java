package com.byc.vo;


import com.byc.bean.CommodityList;

import java.util.List;

public class OrderShow {
    //订单商品集合
    private List<CommodityList> commodityLists;
    //该订单总价
    private float total;
    //上门回收地址
    private String address;
    //订单创建日期
    private String creationTime;
    //订单状态
    private int orderStatus;
    //订单id
    private String orderId;

    public OrderShow(){}

    public OrderShow(List<CommodityList> commodityLists, float total, String address, String creationTime, int orderStatus,String orderId) {
        this.commodityLists = commodityLists;
        this.total = total;
        this.address = address;
        this.creationTime = creationTime;
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }

    public List<CommodityList> getCommodityLists() {
        return commodityLists;
    }

    public void setCommodityLists(List<CommodityList> commodityLists) {
        this.commodityLists = commodityLists;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
