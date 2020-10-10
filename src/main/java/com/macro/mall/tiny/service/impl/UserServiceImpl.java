package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.UserMapper;
import com.macro.mall.tiny.mbg.model.User;
import com.macro.mall.tiny.mbg.model.UserExample;
import com.macro.mall.tiny.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int createUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(Long id, User user) {
        user.setId(Math.toIntExact(id));
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public List<User> listUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample userExample=new UserExample();
        userExample.setOrderByClause("id desc");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public int deleteAll() {
        return userMapper.deleteByExample(new UserExample());
    }

    @Override
    public List<User> listUserByName(String name) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNameEqualTo(name);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public User getAdminByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(username);
        List<User> UserList = userMapper.selectByExample(example);
        if (UserList != null && UserList.size() > 0) {
            User user = UserList.get(0);
            return user;
        }
        return null;
    }

    @Override
    public User register(User user) {
        User umsAdmin = new User();
        BeanUtils.copyProperties(user, umsAdmin);
        UserExample example = new UserExample();

        example.createCriteria().andNameEqualTo(umsAdmin.getName());
        List<User> umsAdminList = userMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        userMapper.insert(umsAdmin);
        return umsAdmin;
    }




}
