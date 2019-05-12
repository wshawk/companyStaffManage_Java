package com.companystaffmanage.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wsHawk
 * @Title: Hello
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 0:13
 */
@RestController
public class Hello {
    @RequestMapping("/hello")
    public String sayHello(){
        return  "HELLO SPRINGBOOT";
    }
}
