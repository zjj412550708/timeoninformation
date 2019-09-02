package com.yuanian.informationto.service;

import com.yuanian.informationto.model.User;

import java.util.List;

public interface UserService {
    int insert(User user);

    User selectByPrimaryKey(String usercode);

    List<User> SeByDa(String starttime, String  lasttime);
}
