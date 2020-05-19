package com.byc.controller;

import com.byc.mapper.GcSystemRouterMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "权限管理相关接口")
@RequestMapping("/router")
public class GcRouterController {

    @Autowired
    GcSystemRouterMapper gcSystemRouterMapper;

    @ApiOperation("添加新的垃圾种类信息")
    @GetMapping("/getRouterInfo")
    //根据登录的角色权限不同获得不同的路由
    public String getRouterInfo(int permission){
        String routerByPermission = gcSystemRouterMapper.getRouterByPermission(permission);
        return routerByPermission;
    }

}
