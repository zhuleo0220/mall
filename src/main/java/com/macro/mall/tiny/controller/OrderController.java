package com.macro.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.mbg.model.Order;
import com.macro.mall.tiny.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


/**
 * 品牌管理Controller
 * Created by macro on 2019/4/19.
 */
@Api(tags = "OrderController",description = "商品品牌管理")
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @ApiOperation("获取所以订单列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String getOrderList(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Order> cs= orderService.listOrder(start,size);
        PageInfo<Order> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "order/listOrder";
    }

    @ApiOperation("添加订单")
    @RequestMapping(value ="add",method = RequestMethod.POST)
    public String add(Order order ){
        order.setCreatedate(new Date());

        orderService.createOrder(order);

        return "redirect:listAll";
    }

    @ApiOperation("删除指定id的订单")
    @RequestMapping(value ="delete",method = RequestMethod.GET)
    public String delete(Long id){
        orderService.deleteOrder(id);
        return "redirect:listAll";
    }

    @RequestMapping(value ="edit")
    public String edit(Long id,Model model) {
        Order pb=orderService.getOrder(id);
        model.addAttribute("pb",pb);
        return "order/updateOrder";

    }

    @ApiOperation("更新指定id订单信息")
    @RequestMapping(value ="update",method = RequestMethod.POST)
    public String update(Order order){
        orderService.updateOrder(Long.valueOf(order.getId()),order);
        return "redirect:listAll";
    }



}
