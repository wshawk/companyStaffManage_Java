package com.companystaffmanage.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.companystaffmanage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wsHawk
 * @Title: LoginController
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 18:28
 */
@RestController
public class UserController {
    @Autowired(required=true)
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Boolean loginCheck(@RequestBody JSONObject jsonObject){
//        return userService.loginCheck(userName,password);
        String userName = "";
        String password = "";
        if (jsonObject != null){
            userName = jsonObject.getString("userName");
            password = jsonObject.getString("password");
            return userService.loginCheck(userName,password);
        }
        return false;
    }
}
