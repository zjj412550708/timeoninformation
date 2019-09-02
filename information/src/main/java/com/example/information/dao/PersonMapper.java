package com.example.information.dao;

import com.example.information.pojo.Person;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(String usercode);

    List<Person> selectAll();

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String usercode);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}