package com.byc.service.serviceImpls;

import com.byc.bean.User;
import com.byc.common.ServerResponse;
import com.byc.mapper.UserMapper;
import com.byc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService implements IUserService, Serializable {
    @Autowired
    UserMapper userMapper;
    //添加新的用户
    public boolean insertUser(String uname,String password){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUname(uname);
        user.setUpassword(password);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegisterTime(simpleDateFormat.format(new Date()));
        //返回修改的行数
        int i = userMapper.addNewUser(user);
        if(i>0)
            return true;
        else
            return false;
    }
    //根据名字查出用户信息
    public User getUser(String name){
        User user=userMapper.getUserByName(name);
        return user;
    }

    //根据用户的用户名来判断用户已经存在（用户注册界面）
    public ServerResponse<User> register(String username){
        int i = userMapper.checkUser(username);
        if(i>0){
            return ServerResponse.createByWarnMessage("用户已存在");
        }
        return ServerResponse.createByErrorMessage("用户名不存在");
    }
    //根据用户输入的用户名来判断是否存在（用于登录界面）
    public ServerResponse<User> login(String username, String password) {
        int i = userMapper.checkUser(username);
        if ( i== 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        User user = userMapper.checkUserByPassword(username, password);
        if ( user==null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登陆成功", user);
    }
    //根据名称来修改密码
    public User updateUserPassword(String password,String uname){
        User user = userMapper.getUserByName(uname);
        user.setUpassword(password);
        userMapper.updateUser(user);
        return user;
    }
    //根据名称来修改电话
    public User updateUserTelphone(String uname, String telphone){
        User user = userMapper.getUserByName(uname);
        user.setTelphone(telphone);
        userMapper.updateUser(user);
        return user;
    }

    //根据id来修改用户的状态
    public int updateUserStatus(String id , int status){
        int i = userMapper.updateUserStatus(id, status);
        return i;

    }

    //管理员拿到部分用户信息展览到界面
    public List<User> getPartUserInfo(){
        List<User> partUserInfo = userMapper.getPartUserInfo();
        return  partUserInfo;
    }

    //根据用户名来删除用户信息
    public int deleteUserService(String uname){
        int i = userMapper.deleteUser(uname);
        return i;
    }

    //improve user information service
    public int improveInfoServie(String uname,String telphone,String email,String address){
        int i = userMapper.improveInfo(uname, telphone, email, address);
        return i;
    }

}
