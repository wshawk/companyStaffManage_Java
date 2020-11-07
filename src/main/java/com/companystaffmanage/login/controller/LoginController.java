package com.companystaffmanage.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wsHawk
 * @Title: LoginController
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @since 2020/11/7 15:16
 */
@RestController
public class LoginController {

    @GetMapping("/hello")
    public String testLogin(){
        return "restart";
    }
}
