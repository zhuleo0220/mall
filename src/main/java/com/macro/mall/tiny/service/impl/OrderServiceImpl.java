package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.OrderMapper;
import com.macro.mall.tiny.mbg.model.Order;
import com.macro.mall.tiny.mbg.model.OrderExample;
import com.macro.mall.tiny.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * OrderService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> listAllOrder() {
        return orderMapper.selectByExample(new OrderExample());
    }

    @Override
    public int createOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public int updateOrder(Long id, Order order) {
        order.setId(Math.toIntExact(id));
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int deleteOrder(Long id) {
        return orderMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public List<Order> listOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OrderExample orderExample=new OrderExample();
        orderExample.setOrderByClause("id desc");
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public Order getOrder(Long id) {
        return orderMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public int deleteAll() {
        return orderMapper.deleteByExample(new OrderExample());
    }
}
