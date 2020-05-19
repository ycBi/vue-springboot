package com.byc.controller;

import com.byc.bean.Garbage;
import com.byc.bean.OrderList;
import com.byc.service.serviceImpls.OrderService;
import com.byc.vo.Commodity;
import com.byc.vo.OrderShow;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(tags = "订单管理相关接口")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

//    @ApiOperation("生成订单接口")
//    @PostMapping("/")
//    public boolean addOrder(float payment, String orderItemList, String userId, String cycleId){
//        boolean b = orderService.addOrder(payment, orderItemList, userId, cycleId);
//        return b;
//    }
    @ApiOperation("查看订单号信息")
    @GetMapping("/getInfo/{id}")
    public OrderList selectOrderById(@PathVariable("id") String id){
        OrderList orderList = orderService.selectOrderById(id);
        return orderList;
    }
    @ApiOperation(("通过用户id查找订单信息"))
    @GetMapping("/getInfoByUserID/{id}")
    public List<OrderList> selectOrderByUserId(@PathVariable("id") String userId){
        List<OrderList> orderLists = orderService.selectOrderByUserId(userId);
        return orderLists;
    }
    @ApiOperation("通过回收人员id")
    @GetMapping("/getInfoByCycleID/{id}")
    public List<OrderList> SelectOrderByCycleId(@PathVariable("id") String cycleId){
        List<OrderList> orderLists = orderService.SelectOrderByCycleId(cycleId);
        return orderLists;
    }
//    @PostMapping("/generateOrder")
//    public boolean generateOrder(@RequestBody List<Commodity> commodities){
//        System.out.println(commodities);
////        System.out.println(userInfoId);
////        System.out.println(userInfoAddress);
//        return true;
//    }

    @PostMapping("/generateOrder")
    public int generateOrder(@RequestBody Map<String,Object> map){
//        System.out.println(map);
//        System.out.println(map.get("commodities"));
//        System.out.println(map.get("userInfoId"));
//        System.out.println(map.get("userInfoAddress"));
        List<Map> maps= (List<Map>) map.get("commodities");
        int i = orderService.generateOrderService(map.get("userInfoAddress").toString(), map.get("userInfoId").toString(), maps);
        if (i==0)
            return  0;
//        for ( Map p: maps
//             ) {
//            System.out.println(p);
//        }
//        System.out.println(objects);
//        List<Commodity> commodities=(List<Commodity>)map.get("commodities");
//        System.out.println(commodities);
//        for (Commodity commodity:commodities
//             ) {
//            System.out.println(commodity);
//        }

              return 1;
    }

    @GetMapping("/getShopInfo")
    //根据用户id来查找与自己相关的订单（等待接收的订单）
    public List<OrderShow> getOrderShoData(String userId){
        List<OrderShow> orderShowService = orderService.getOrderShowService(userId);
        return  orderShowService;
    }

    @GetMapping("/getShopInfoByOrderId")
    //根据订单id来获取信息
    public Map<String,Object> getOrderByOrderId(String orderId){
        Map<String, Object> orderByOrderId = orderService.getOrderByOrderId(orderId);
        return orderByOrderId;
    }

    @GetMapping("/getOrderInfoForCycle")
    public List<Map<String,Object>> getOrderInfoForCycle(int status){
        List<Map<String, Object>> orderInfoByOrderStatus = orderService.getOrderInfoByOrderStatus(status);
        return  orderInfoByOrderStatus;
    }

    @PutMapping("/receiveOrder")
    /*
    * id为订单id
    * */
    public int receiveOrder(String id,String userId){
        int i = orderService.receiveOrderService(id,userId);
        return i;
    }

    @GetMapping("/getShopInfoByCycleId")
    //根据用户id来查找与自己相关的订单（等待接收的订单）
    public  List<Map<String, Object>> getCycleOrderData(String cycleId){
        List<Map<String, Object>> orderInfoByCycleId = orderService.getOrderInfoByCycleId(cycleId);
        return  orderInfoByCycleId;
    }

}
