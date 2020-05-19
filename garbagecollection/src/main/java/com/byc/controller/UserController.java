package com.byc.controller;

import com.byc.bean.User;
import com.byc.common.ServerResponse;
import com.byc.mapper.UserMapper;
import com.byc.service.serviceImpls.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录用户接口")
    //@ApiImplicitParams(@ApiImplicitParam(name = "user", value = "用户相关信息"))
    public ServerResponse<User> login(@RequestParam("username") String username, @RequestParam("password") String password, @ApiIgnore HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute("currentUser", response.getData());
        }
        return response;
    }

    @PostMapping("/register")
    @ApiOperation("注册用户接口")
    public ServerResponse<User> register(@RequestParam("username") String username) {
        ServerResponse<User> register = userService.register(username);
        return register;
    }

    @PostMapping("/insert")
    @ApiOperation("注册用户")
    public boolean insertUser(String username, String password) {
        boolean b = userService.insertUser(username, password);
        return b;
    }

    @GetMapping("/name")
    @ApiOperation("查询用户信息")
    //根据用户名来查找用户信息
    public User getUser(@RequestParam("name") String name) {
        User user = userService.getUser(name);
        return user;
    }

    @PutMapping("/password/{uname}")
    @ApiOperation("根据用户名来修改用户密码")
    //根据用户名来修改用户密码
    public User updateUserPassword(String password, @PathVariable("uname") String uname) {
        User user = userService.updateUserPassword(password, uname);
        return user;
    }

    @PutMapping("/phone/{uname}")
    @ApiOperation("根据用户名来修改用户电话")
    //根据用户名来修改用户电话
    public User updateUserTelphone(@PathVariable("uname") String uname, String telphone) {
        User user = userService.updateUserTelphone(uname, telphone);
        return user;
    }
    @PutMapping("/status")
    @ApiOperation("管理员来修改用户状态")
    //根据用户id来修改用户的状态
    public int updateUserStatus(String id ,int status ){
        int i = userService.updateUserStatus(id, status);
        return i;
    }
    @GetMapping("/getPartInfo")
    @ApiOperation("拿到部分用户")
    //拿到部分的用户
    public List<User> getPartUserInfo(){
        List<User> partUserInfo = userService.getPartUserInfo();
        return partUserInfo;
    }

    @DeleteMapping("/deleteUserInfo")
    @ApiOperation("删除用户信息（用户可能违规）")
    //根据用户名来删除用户信息
    public int deleteUser(@RequestParam("uname") String uname){
        int i = userService.deleteUserService(uname);
        return i;

    }
    
    @PutMapping("/improveInfo")
    @ApiOperation("完善用户信息")
    public int improveInfo(@RequestParam("uname") String uname,@RequestParam("telphone") String telphone,@RequestParam("email") String email,@RequestParam("address") String address) {
        int i = userService.improveInfoServie(uname, telphone, email, address);
        return i;
    }
}
