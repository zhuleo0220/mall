package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.User;

import java.util.List;

public interface UserService {
    List<User> listAllUser();

    int createUser(User user);

    int updateUser(Long id, User user);

    int deleteUser(Long id);

    List<User> listUser(int pageNum, int pageSize);

    User getUser(Long id);

    int deleteAll();

    List<User> listUserByName(String name);

    User getAdminByUsername(String username);

    User register(User user);

}
