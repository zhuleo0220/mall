package com.macro.mall.tiny.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.mbg.model.User;
import com.macro.mall.tiny.service.UserService;
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
@Api(tags = "UserController",description = "商品品牌管理")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @ApiOperation("获取所以品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String getUserList(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<User> cs= userService.listUser(start,size);
        PageInfo<User> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "user/listUser";
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value ="add",method = RequestMethod.POST)
    public String add(User user ){
        userService.createUser(user);
        return "redirect:listAll";
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value ="delete",method = RequestMethod.GET)
    public String delete(Long id){
        userService.deleteUser(id);
        return "redirect:listAll";
    }

    @RequestMapping(value ="edit")
    public String edit(Long id,Model model) {
        User pb=userService.getUser(id);
        model.addAttribute("pb",pb);
        return "user/updateUser";

    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value ="update",method = RequestMethod.POST)
    public String update(User user){
        userService.updateUser(Long.valueOf(user.getId()),user);
        return "redirect:listAll";
    }



}
