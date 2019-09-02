package com.example.information.service;

import com.example.information.dao.PersonMapper;
import com.example.information.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {

      @Autowired(required = false)
      private PersonMapper personMapper;
    @Override
    public List<Person> queryPersonList() {
        return personMapper.selectAll();
    }
}
