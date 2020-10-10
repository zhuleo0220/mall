package com.macro.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.service.PmsBrandService;
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
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所以品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String getBrandList(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<PmsBrand> cs= demoService.listBrand(start,size);
        PageInfo<PmsBrand> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "brand/listBrand";
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value ="add",method = RequestMethod.POST)
    public String add(PmsBrand brand){
        demoService.createBrand(brand);
        return "redirect:listAll";
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value ="delete",method = RequestMethod.GET)
    public String delete(Long id){
        demoService.deleteBrand(id);
        return "redirect:listAll";
    }

    @RequestMapping(value ="edit")
    public String edit(Long id,Model model) {
        PmsBrand pb=demoService.getBrand(id);
        model.addAttribute("pb",pb);
        return "brand/updateBrand";

    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value ="update",method = RequestMethod.POST)
    public String update(PmsBrand brand){
        System.out.println(brand.getId());
        System.out.println(brand);
        demoService.updateBrand(brand.getId(),brand);
        return "redirect:listAll";
    }



}
