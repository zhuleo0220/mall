package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> listAllOrder();

    int createOrder(Order user);

    int updateOrder(Long id, Order user);

    int deleteOrder(Long id);

    List<Order> listOrder(int pageNum, int pageSize);

    Order getOrder(Long id);

    int deleteAll();
}
