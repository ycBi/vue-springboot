package com.byc.service;

import com.byc.bean.User;


public interface IUserService {
    public boolean insertUser(String uname,String password);
    public User getUser(String name);
    public User updateUserPassword(String password,String uname);
    public User updateUserTelphone(String uname, String telphone);
}
