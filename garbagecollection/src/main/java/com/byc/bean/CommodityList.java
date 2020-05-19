package com.byc.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CommodityList {
    @ApiModelProperty(value="单列商品id")
    private String id;
    @ApiModelProperty(value="商品id")
    private String commodity;
    @ApiModelProperty(value="商品数量")
    private float amount;
    @ApiModelProperty(value="商品价格")
    private float gPrice;

    public CommodityList(){}

    public CommodityList(String id, String commodity, float amount,float gPrice) {
        this.id = id;
        this.commodity = commodity;
        this.amount = amount;
        this.gPrice = gPrice;
    }

    public String getId() {
        return id;
    }

    public String getCommodity() {
        return commodity;
    }

    public float getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getgPrice() {
        return gPrice;
    }

    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
    }
}
