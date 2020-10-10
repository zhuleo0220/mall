package com.macro.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.mapper.CategoryMapper;
import com.macro.mall.tiny.mbg.model.Category;
import com.macro.mall.tiny.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 品牌管理Controller
 * Created by macro on 2019/4/19.
 */
@Api(tags = "CategoryController",description = "商品品牌管理")
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @ApiOperation("获取所以品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Category>> getList(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Category> productCategoryList = demoService.listCategory(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value ="add",method = RequestMethod.POST)
    public String add(Category category){
        demoService.createCategory(category);
        return "redirect:listAll";
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value ="delete",method = RequestMethod.GET)
    public String delete(Long id){
        demoService.deleteCategory(id);
        return "redirect:listAll";
    }

    @RequestMapping(value ="edit")
    public String edit(Long id,Model model) {
        Category pb=demoService.getCategory(id);
        model.addAttribute("pb",pb);
        return "category/updateCategory";

    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value ="update",method = RequestMethod.POST)
    public String update(Category category){
        System.out.println(category.getId());
        System.out.println(category);
        demoService.updateCategory(Long.valueOf(category.getId()),category);
        return "redirect:listAll";
    }



}
