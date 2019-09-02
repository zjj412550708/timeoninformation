package com.yuanian.informationto.service;

import com.yuanian.informationto.dao.UserMapper;
import com.yuanian.informationto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/8/30 10:04
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private com.yuanian.informationto.dao.UserMapper userMapper;

    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    @Override
    public User selectByPrimaryKey(String usercode){
        return userMapper.selectByPrimaryKey(usercode);
    }

    @Override
    public List<User> SeByDa(String starttime, String  lasttime){
        List<User> list = new ArrayList<>();
        list = userMapper.selectByhiredate(starttime,lasttime);
        return list;
    }
}
