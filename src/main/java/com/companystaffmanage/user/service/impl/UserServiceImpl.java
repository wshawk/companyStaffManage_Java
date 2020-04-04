package com.companystaffmanage.user.service.impl;

import com.companystaffmanage.entity.User;
import com.companystaffmanage.user.dao.UserDao;
import com.companystaffmanage.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
//        if (userName != ""){
//            User user = userDao.findByUserNo(userName);
//            if (user != null && user.getPwd().equals(password)){
//                return true;
//            }
//        }
        return true;
    }

    @Override
    public Boolean changePassword(String userNo,String password){

        if (userNo != ""){
            User user = userDao.findByUserNo(userNo);
            if (user != null && !"".equals(password)){
                user.setPwd(password);
                userDao.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String userName){
        return userDao.findByUserNo(userName);
    }
}
