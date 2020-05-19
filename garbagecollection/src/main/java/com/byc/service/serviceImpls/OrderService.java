package com.byc.service.serviceImpls;

import com.byc.bean.CommodityList;
import com.byc.bean.OrderList;
import com.byc.bean.User;
import com.byc.mapper.CommodityListMapper;
import com.byc.mapper.OrderListMapper;
import com.byc.mapper.UserMapper;
import com.byc.service.IOrderService;
import com.byc.vo.OrderShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class OrderService implements IOrderService, Serializable {
    @Autowired
    OrderListMapper orderMapper;
    @Autowired
    CommodityListMapper commodityListMapper;
    @Autowired
    UserMapper userMapper;
    //生成订单
//    public boolean addOrder(float payment, String orderItemList,  String userId,  String cycleId){
//        OrderList orderList = new OrderList();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //订单号
//        orderList.setId(UUID.randomUUID().toString());
//        orderList.setPayment(payment);
//        orderList.setOrderItemList(orderItemList);
//        orderList.setUserid(userId);
//        orderList.setCycleid(cycleId);
//        orderList.setCreationTime(simpleDateFormat.format(new Date()));
//        orderList.setEndTime(simpleDateFormat.format(new Date()));
//        int i = orderMapper.addOrder(orderList);
//        return i>0?true:false;
//    }
    //通过订单号id来查询订单信息
    public OrderList selectOrderById(String id){
        OrderList orderList = orderMapper.selectOrderById(id);
        return orderList;
    }

    //用户根据相关的用户id来查找与自己相关的订单信息
    public List<OrderList> selectOrderByUserId(String userId){
        List<OrderList> orderLists = orderMapper.selectOrderByUserId(userId);
        return orderLists;
    }

    //回收人员来查询相关的订单
    public List<OrderList> SelectOrderByCycleId(String cycleId){
        List<OrderList> orderLists = orderMapper.selectOrderByCycleId(cycleId);
        return orderLists;
    }

    //生成订单
    public int generateOrderService(String userInfoAddress,String userInfoId,List<Map> maps){
        String orderId = UUID.randomUUID().toString();
        String address = userInfoAddress;
        String userId = userInfoId;
        int orderStatus = 0;
        float payment = 0;
//        float v = Float.parseFloat(amount);
//        float payment = gPrice*v;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creationTime = simpleDateFormat.format(new Date());
//        int i = orderMapper.generateOrder(orderId, payment, address, creationTime, userId, orderStatus);
//        if(i==0){
//            //代表插入失败
//            return 0;
//        }
        for (Map p: maps
             ) {
            payment = payment + ((Float.parseFloat(p.get("amount").toString()))*(Float.parseFloat(p.get("gPrice").toString())));
            int i1 = commodityListMapper.insertCommodity(UUID.randomUUID().toString(), p.get("gName").toString(), Float.parseFloat(p.get("amount").toString()), orderId,Float.parseFloat(p.get("gPrice").toString()));
            if (i1==0){
                //代表插入失败
                return 0;
            }
        }
        int i = orderMapper.generateOrder(orderId, payment, address, creationTime, userId, orderStatus);
        if(i==0){
            //代表插入失败
            return 0;
        }
        return 1;
    }

    //根据用户id来获取订单页面的展示数据
    public List<OrderShow> getOrderShowService(String userId){
//        float total=0;
        ArrayList<OrderShow> orderShows = new ArrayList<>();
        List<OrderList> orderLists = orderMapper.selectOrderByUserId(userId);
//        OrderShow orderShow = new OrderShow();
        for (OrderList orderList:orderLists
             ) {
            OrderShow orderShow = new OrderShow();
//            //筛选出没有接单的订单
//            if(orderList.getOrderStatus()==1)
//                continue;
//            total+=orderList.getPayment();
            orderShow.setAddress(orderList.getAddress());
            orderShow.setCreationTime(orderList.getCreationTime());
            orderShow.setOrderStatus(orderList.getOrderStatus());
            orderShow.setTotal(orderList.getPayment());
            orderShow.setOrderId(orderList.getId());
            List<CommodityList> commodityLists = commodityListMapper.selectOrderListInfo(orderList.getId());
            orderShow.setCommodityLists(commodityLists);
            orderShows.add(orderShow);
        }
        return  orderShows;
    }

    // 根据订单id来搜索订单
    public Map<String,Object> getOrderByOrderId(String orderId){
        OrderList orderList = orderMapper.selectOrderById(orderId);
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("garbageOrder",orderList);
        List<CommodityList> commodityLists = commodityListMapper.selectOrderListInfo(orderId);
        stringObjectMap.put("commodityList",commodityLists);
        User userInfoById = userMapper.getUserInfoById(orderList.getUserid());
        stringObjectMap.put("user",userInfoById);
        User cycleInfoById = userMapper.getUserInfoById(orderList.getCycleid());
        stringObjectMap.put("cycle",cycleInfoById);
        return stringObjectMap;
    }
    //根据订单的状态来获取订单
    public List<Map<String,Object>> getOrderInfoByOrderStatus(int status){
//        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        ArrayList<Map<String, Object>> lists = new ArrayList<>();
        List<OrderList> orderInfoByOrderStatus = orderMapper.getOrderInfoByOrderStatus(status);
        // 没有接单的订单
//        stringObjectHashMap.put("garbageOrder",orderInfoByOrderStatus);
        //
        for (OrderList orderList:orderInfoByOrderStatus
             ) {
            User userInfoById = userMapper.getUserInfoById(orderList.getUserid());
            List<CommodityList> commodityLists = commodityListMapper.selectOrderListInfo(orderList.getId());
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("garbageOrder",orderList);
            stringObjectHashMap.put("user",userInfoById);
            stringObjectHashMap.put("commodity",commodityLists);
            lists.add(stringObjectHashMap);
        }
        return  lists;
    }

    /*
    * 改变订单的状态，将回收金额加到订单用户账户的金额上
    * */
    public int receiveOrderService(String orderId,String userId){
        OrderList orderList = orderMapper.selectOrderById(orderId);
        //订单的金额加上已有的金额
        float newAmount= userMapper.getUserInfoById(orderList.getUserid()).getMoney()+orderList.getPayment();
        int i = userMapper.updateUserMoney(orderList.getUserid(), newAmount);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTime = simpleDateFormat.format(new Date());
        int i1 = orderMapper.changeOrderStatus(orderId, endTime,userId,2);
        if (i==1&&i1==1){
            return 1;
        }
        return 0;
    }

    //根据回收人员id来获取订单
    public List<Map<String,Object>> getOrderInfoByCycleId(String cycleId){
//        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        ArrayList<Map<String, Object>> lists = new ArrayList<>();
        List<OrderList> orderLists = orderMapper.selectOrderByCycleId(cycleId);
        for (OrderList orderList:orderLists
             ) {
            // 通过订单的用户id获取用户的信息
            User userInfoById = userMapper.getUserInfoById(orderList.getUserid());
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("userInfo",userInfoById);
            // 拿到改订单的商品信息(list)
            List<CommodityList> commodityLists = commodityListMapper.selectOrderListInfo(orderList.getId());
            stringObjectHashMap.put("commodity",commodityLists);
            // 添加该订单信息
            stringObjectHashMap.put("orderInfo",orderList);
            lists.add(stringObjectHashMap);
        }
        return  lists;
    }

}
