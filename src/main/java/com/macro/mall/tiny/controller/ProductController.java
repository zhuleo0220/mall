package com.macro.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.Category;
import com.macro.mall.tiny.mbg.model.Product;
import com.macro.mall.tiny.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * 品牌管理Controller
 * Created by macro on 2019/4/19.
 */
@Api(tags = "ProductController",description = "商品品牌管理")
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);


    @ApiOperation("获取所以品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Product>> getList(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Product> ProductList = demoService.listProduct(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(ProductList));
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value ="create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody Product product){
        product.setCreatedate(new Date());
        int count = demoService.createProduct(product);
        if(count >0){
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value ="delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
       int count= demoService.deleteProduct(id);
        if (count>0){
            return CommonResult.success(count);

        } else{
            return CommonResult.failed();
        }
    }



    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value ="update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id , @RequestBody Product product){
        int count =demoService.updateProduct(Long.valueOf(product.getId()),product);

            return CommonResult.success(count);


    }



}
