package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.Orderitem;
import com.macro.mall.tiny.mbg.model.Product;

import java.util.List;

public interface OrderitemService {
    List<Orderitem> listAllOrderitem();

    int createOrderitem(Orderitem orderitem);

    int updateOrderitem(Long id, Orderitem orderitem);

    int deleteOrderitem(Long id);

    List<Orderitem> listOrderitem(int pageNum, int pageSize,int oid);

    Orderitem getOrderitem(Long id);

    int deleteAll();

    List<Product> getProductList(int pageNum, int pageSize, int oid);
}
