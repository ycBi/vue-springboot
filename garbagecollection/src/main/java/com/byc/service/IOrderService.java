package com.byc.service;

import com.byc.bean.OrderList;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    public OrderList selectOrderById(String id);
    public List<OrderList> selectOrderByUserId(String userId);
    public List<OrderList> SelectOrderByCycleId(String cycleId);
}
