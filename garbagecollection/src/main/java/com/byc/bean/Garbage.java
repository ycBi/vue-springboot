package com.byc.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Garbage {
    @ApiModelProperty(value="垃圾id")
    private String id;
    @ApiModelProperty(value="垃圾名称")
    private String gName;
    @ApiModelProperty(value="垃圾类型")
    private String gType;
    @ApiModelProperty(value="垃圾价格")
    private float gPrice;
    @ApiModelProperty(value="垃圾描述")
    private String gDesc;
    @ApiModelProperty(value="是否可回收")
    private int isCycle;
    @ApiModelProperty(value = "图片存储服务器的地址")
    private String image;

    public void setId(String id) {
        this.id = id;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
    }

    public void setgDesc(String gDesc) {
        this.gDesc = gDesc;
    }

    public void setIsCycle(int isCycle) {
        this.isCycle = isCycle;
    }

    public void setimage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getgName() {
        return gName;
    }

    public String getgType() {
        return gType;
    }

    public float getgPrice() {
        return gPrice;
    }

    public String getgDesc() {
        return gDesc;
    }

    public int getIsCycle() {
        return isCycle;
    }

    public String getimage() {
        return image;
    }

    public  Garbage(){

    }

    public Garbage(String id, String gName, String gType, float gPrice, String gDesc, int isCycle, String image) {
        this.id = id;
        this.gName = gName;
        this.gType = gType;
        this.gPrice = gPrice;
        this.gDesc = gDesc;
        this.isCycle = isCycle;
        this.image = image;
    }
}
