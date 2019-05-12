package com.companystaffmanage.user.service;

import org.springframework.stereotype.Service;

/**
 * @author wsHawk
 * @Title: LoginService
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 19:13
 */

public interface UserService {

    Boolean loginCheck(String userName,String password);
}
