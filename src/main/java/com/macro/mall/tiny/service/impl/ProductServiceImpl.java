package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.ProductMapper;
import com.macro.mall.tiny.mbg.model.Product;
import com.macro.mall.tiny.mbg.model.ProductExample;
import com.macro.mall.tiny.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProductService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> listAllProduct() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public int createProduct(Product product) {
        return productMapper.insertSelective(product);
    }

    @Override
    public int updateProduct(Long id, Product product) {
        product.setId(Math.toIntExact(id));
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int deleteProduct(Long id) {
        return productMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public List<Product> listProduct(int pageNum, int pageSize,int cid) {
        PageHelper.startPage(pageNum, pageSize);
        if (0==cid) return productMapper.selectByExample(new ProductExample());
        ProductExample productExample=new ProductExample();
        productExample.createCriteria().andCidEqualTo(cid);
        productExample.setOrderByClause("id desc");
        return productMapper.selectByExample(productExample);
    }

    @Override
    public List<Product> listProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectByExample(new ProductExample());
    }


    @Override
    public Product getProduct(Long id) {
        return productMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public int deleteAll() {
        return productMapper.deleteByExample(new ProductExample());
    }
}
