package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();

    int createProduct(Product category);

    int updateProduct(Long id, Product category);

    int deleteProduct(Long id);

    List<Product> listProduct(int pageNum, int pageSize,int cid);

    List<Product> listProduct(int pageNum, int pageSize);

    Product getProduct(Long id);

    int deleteAll();
}
