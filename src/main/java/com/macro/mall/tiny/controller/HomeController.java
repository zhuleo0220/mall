package com.macro.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.Category;
import com.macro.mall.tiny.mbg.model.User;
import com.macro.mall.tiny.service.CategoryService;
import com.macro.mall.tiny.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 品牌管理Controller
 * Created by macro on 2019/4/19.
 */
@Api(tags = "homeController",description = "商品品牌管理")
@Controller
@RequestMapping("")
public class HomeController {


    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @ApiOperation("主页")
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getCategoryList(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {

        return "home/homePage";
    }

    @ApiOperation("注册")
    @RequestMapping(value="register")
    public String register(Model model, User user) {

        
        User user1 = userService.register(user);
        if(user1==null) {
            String m="用户名已经使用!";
            model.addAttribute("msg",m);
            model.addAttribute("user",null);
            return "home/registerPage";
        }

        return "redirect:/home/";

    }
    @ApiOperation("注册页面")
    @RequestMapping(value="registerPage")
    public String registerPage(Model model,User user){
        return "home/registerPage";
    }

    @ApiOperation("空白页面")
    @RequestMapping(value="",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult emptyPage(){
        return CommonResult.success("ok");
    }


}
