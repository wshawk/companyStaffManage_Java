package com.companystaffmanage.user.controller;

import com.companystaffmanage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/login")
    public Boolean loginCheck(String userName,String password){

        return userService.loginCheck(userName,password);
    }
}
