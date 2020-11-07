package com.companystaffmanage.login.controller;

import com.companystaffmanage.common.entity.TestUser;
import com.companystaffmanage.common.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public R testLogin(){
        List<TestUser> list = new ArrayList<>(11);
       for (int i=0; i<10; i++){
           TestUser testUser = new TestUser();
           testUser.setAge(10+i);
           testUser.setEmail("test@qq.com");
           testUser.setId(152L+i);
           testUser.setName("test");
           list.add(testUser);
       }
//        Map<String,Object> res = new HashMap<>();
//        res.put("testUser",testUser);
        return R.success(list);
    }
}
