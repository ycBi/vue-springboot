package com.byc.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.UUID;

/*
* create by byc*/
@ApiModel
public class User implements Serializable {
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String uname;
    @ApiModelProperty(value = "用户密码")
    private String upassword;
    @ApiModelProperty(value = "用户角色")
    private int role=0;
    @ApiModelProperty(value = "用户电话")
    private String telphone;
    @ApiModelProperty(value = "用户状态")
    // 1代表正常使用，0代表禁用
    private  int userStatus =1;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "注册时间")
    private String registerTime;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "账户金额")
    private float money;
    
    //有参构造器
    public User(String id, String uname, String upassword, int role, String telphone,int userStatus,String email,String registerTime,String address,float money) {
        this.id = id;
        this.uname = uname;
        this.upassword = upassword;
        this.role = role;
        this.telphone = telphone;
        this.userStatus = userStatus;
        this.email = email;
        this.registerTime = registerTime;
        this.address = address;
        this.money = money;
    }
   
	//无参构造器
    public User(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}



}
