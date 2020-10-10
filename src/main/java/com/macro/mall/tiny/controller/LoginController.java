package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.Result;
import com.macro.mall.tiny.common.api.ResultCode;
import com.macro.mall.tiny.mbg.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getName();
       // username = HtmlUtils.htmlEscape(username);

        System.out.println("test_api/login");
        System.out.println(username);
        System.out.println(requestUser.getName());
        System.out.println(requestUser.getPassword());

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
