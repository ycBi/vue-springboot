package com.byc.mapper;

import com.byc.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Mapper
@Repository
public interface UserMapper {
    //添加新的用户
    int addNewUser(User user);
    //更新用户
    int updateUser(User user);
    //查询用户根据用户名
    User getUserByName(String name);
    //查询所有的用户
    List<User> getUserList();
    //根据用户名查询出该用户是否存在
    int checkUser(String name);
    //验证密码的正确性
    User checkUserByPassword( String name,  String password);
    //改变用户的使用状态
    int updateUserStatus(String id, int status);
     //管理员界面展示部分的用户信息
    List<User> getPartUserInfo();
    //根据用户名来删除用户信息
    int deleteUser(String uname);
    // to improve user information
    int improveInfo(@Param("uname") String uname,@Param("telphone")String telphone,@Param("email")String email,@Param("address")String address);
    //根据用户id来获取信息
    User getUserInfoById(String id);
    // 修改用户的金额（用于接单成功）
    int updateUserMoney(String id,float money);


}
