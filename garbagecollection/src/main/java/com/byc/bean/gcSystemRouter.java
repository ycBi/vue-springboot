package com.byc.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

@ApiModel
public class gcSystemRouter {
    @ApiModelProperty(value = "权限")
    private int gcPermission;
    @ApiModelProperty(value = "路由")
    private String gcRouter;

    public gcSystemRouter(){}

    public gcSystemRouter(int gcPermission, String gcRouter) {
        this.gcPermission = gcPermission;
        this.gcRouter = gcRouter;
    }

    public int getGcPermission() {
        return gcPermission;
    }

    public void setGcPermission(int gcPermission) {
        this.gcPermission = gcPermission;
    }

    public String getGcRouter() {
        return gcRouter;
    }

    public void setGcRouter(String gcRouter) {
        this.gcRouter = gcRouter;
    }
}
