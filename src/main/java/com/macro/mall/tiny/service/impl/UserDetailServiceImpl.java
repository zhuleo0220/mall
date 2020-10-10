package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.model.User;
import com.macro.mall.tiny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userModel = userService.getAdminByUsername(s);
        if (userModel == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new org.springframework.security.core.userdetails.User(userModel.getName(), userModel.getPassword(),
                createAuthority(userModel.getRole()));

    }





    private List<SimpleGrantedAuthority> createAuthority(String roles){
        String [] roleArray = roles.split(",");
        List<SimpleGrantedAuthority> authorityList=new ArrayList<>();
        for(String role : roleArray ){
            authorityList.add(new SimpleGrantedAuthority(role));
        }
        return authorityList;
    }
}