package com.byc.mapper;

import com.byc.bean.OrderList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Mapper
@Repository
public interface OrderListMapper {
    //添加新生成的订单（废弃）
    int addOrder(OrderList orderList);
    //通过订单号来查询订单
    OrderList selectOrderById(String id);
    //根据用户id来查询相关的订单
    List<OrderList> selectOrderByUserId(String userid);
    //回收人员来查询相关的订单
    List<OrderList> selectOrderByCycleId(String cycleid);
    //添加新生成的订单
    int generateOrder(String id,float payment,String address,String creationTime,String userid,int orderStatus);
    // 根据订单的状态来获取订单（用于回收人员接收）
    List<OrderList> getOrderInfoByOrderStatus(int orderStatus);
    // 改变订单的状态
    int changeOrderStatus(String id,String endTime,String cycleid,int orderStatus);
}
