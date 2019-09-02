package com.yuanian.five.controller;

import com.yuanian.five.jsondate.JsonReturn;
import com.yuanian.five.model.User;
import com.yuanian.five.service.UserService;
import com.yuanian.five.service.UserServiceImpl;
import jdk.nashorn.internal.runtime.logging.Logger;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/8/30 9:32
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/test")
    public String test() {
        return "test success";
    }

    @GetMapping("/get")
    public JSONObject ShowJson() throws Exception{
        JsonReturn jsonReturn = new JsonReturn();
        JSONObject o = jsonReturn.JsonGet();
        return o;
    }

    @PostMapping("/select/{usercode}")
    public User selectByPrimaryKey(@PathVariable("usercode") String usercode){
        User o = userService.selectByPrimaryKey(usercode);
        System.out.println(o);
        return o;
    }

    @GetMapping("/insert")
    public  int insert(User user) throws ParseException {
        return userService.insert(user);
    }

    @PostMapping("/getbydate")
    public List<User> getbydate(@RequestParam("StartTime") String starttime,@RequestParam("LastTime") String lasttime){
        return userService.SeByDa(starttime,lasttime);
    }

}
