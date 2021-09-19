package com.hawk.company_staff_manage.login.controller;

import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.common.RP;
import com.hawk.company_staff_manage.common.entity.staff.Staff;
import com.hawk.company_staff_manage.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wsHawk
 * @Title: LoginController
 * @ProjectName company-staff-manage
 * @Description: TODO
 * @since 2021/9/19 15:02
 */
@Slf4j
@RequestMapping("/csm")
@RestController
public class LoginController {

    @PostMapping("/toLogin")
    public R<Boolean> login(@RequestBody Staff staff){
        if (staff == null || staff.getStaffNo() == null || staff.getPassword() == null){
            return R.fail(RP.REQUEST_FIELD_ERROR);
        }
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        //封装当前用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(staff.getStaffNo(), staff.getPassword());
        //执行登录方法
        subject.login(token);

        return R.success(Boolean.TRUE);
    }
}
