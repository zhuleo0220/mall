package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.OrderitemMapper;
import com.macro.mall.tiny.mbg.mapper.ProductMapper;
import com.macro.mall.tiny.mbg.model.Orderitem;
import com.macro.mall.tiny.mbg.model.OrderitemExample;
import com.macro.mall.tiny.mbg.model.Product;
import com.macro.mall.tiny.service.OrderitemService;
import com.macro.mall.tiny.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * OrderitemService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class OrderitemServiceImpl implements OrderitemService {
    @Resource
    private OrderitemMapper orderitemMapper;

    @Resource
    private ProductService productService;

    @Override
    public List<Orderitem> listAllOrderitem() {
        return orderitemMapper.selectByExample(new OrderitemExample());
    }

    @Override
    public int createOrderitem(Orderitem orderitem) {
        return orderitemMapper.insertSelective(orderitem);
    }

    @Override
    public int updateOrderitem(Long id, Orderitem orderitem) {
        orderitem.setId(Math.toIntExact(id));
        return orderitemMapper.updateByPrimaryKeySelective(orderitem);
    }

    @Override
    public int deleteOrderitem(Long id) {
        return orderitemMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public List<Orderitem> listOrderitem(int pageNum, int pageSize,int oid) {
        PageHelper.startPage(pageNum, pageSize);
        if (0==oid) return orderitemMapper.selectByExample(new OrderitemExample());
        OrderitemExample orderitemExample=new OrderitemExample();
        orderitemExample.createCriteria().andOidEqualTo(oid);
        orderitemExample.setOrderByClause("id desc");
        return orderitemMapper.selectByExample(orderitemExample);
    }

    @Override
    public Orderitem getOrderitem(Long id) {
        return orderitemMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public int deleteAll() {
        return orderitemMapper.deleteByExample(new OrderitemExample());
    }

    @Override
    public List<Product> getProductList(int pageNum, int pageSize, int oid){
        List<Orderitem> orderitems=this.listOrderitem(pageNum,pageSize,oid);
        List<Product> products=new LinkedList<>();
        for(Orderitem orderitem : orderitems){
            products.add(productService.getProduct(Long.valueOf(orderitem.getPid())));


        }
        return products;

    }
}
