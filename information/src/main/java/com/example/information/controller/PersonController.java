package com.example.information.controller;

import com.example.information.pojo.Person;
import com.example.information.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Person> personList(){
       return personService.queryPersonList();
    }
}
