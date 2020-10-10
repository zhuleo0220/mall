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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value ="add",method = RequestMethod.POST)
    public String add(Product product ){
        product.setCreatedate(new Date());
        demoService.createProduct(product);
        return "redirect:listAll";
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value ="delete",method = RequestMethod.GET)
    public String delete(Long id){
        demoService.deleteProduct(id);
        return "redirect:listAll";
    }

    @RequestMapping(value ="edit")
    public String edit(Long id,Model model) {
        Product pb=demoService.getProduct(id);
        model.addAttribute("pb",pb);
        return "product/updateProduct";

    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value ="update",method = RequestMethod.POST)
    public String update(Product product){
        System.out.println(product.getId());
        System.out.println(product);
        demoService.updateProduct(Long.valueOf(product.getId()),product);
        return "redirect:listAll";
    }



}
