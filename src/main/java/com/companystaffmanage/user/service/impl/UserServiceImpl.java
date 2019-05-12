package com.companystaffmanage.user.service.impl;

import com.companystaffmanage.entity.User;
import com.companystaffmanage.user.dao.UserDao;
import com.companystaffmanage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wsHawk
 * @Title: LoginServiceImpl
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 19:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean loginCheck(String userName,String password){
        if (userName != ""){
            User user = userDao.findByUserNo(userName);
            if (user != null && user.getPwd().equals(password)){
                return true;
            }
        }
        return false;
    }
}
