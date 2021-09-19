package com.hawk.company_staff_manage.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hawk.company_staff_manage.common.constants.Constants;
import com.hawk.company_staff_manage.common.RP;
import com.hawk.company_staff_manage.common.constants.staff.StaffConstant;
import com.hawk.company_staff_manage.common.entity.staff.Staff;
import com.hawk.company_staff_manage.common.exception.BizException;
import com.hawk.company_staff_manage.staff.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author hawk
 * @desc 用户登录验证
 * @date 2021/9/19 14:44
 */
@Slf4j
public class StaffRealm extends AuthorizingRealm {
    @Resource
    StaffService staffService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行认证");
        //连接真实数据库

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //所以可以通过token对象获得密码和用户名
        LambdaQueryWrapper<Staff> queryWrapper = Wrappers.lambdaQuery(Staff.class)
                .eq(Staff::getStaffNo, token.getUsername())
                .eq(Staff::getEnabledFlag, Constants.ENABLED);

        Staff staff = staffService.getOne(queryWrapper);

        if(staff == null){
            throw new BizException(RP.LOGIN_FAILED);
        }
        if (staff.getState() == StaffConstant.ACCOUNT_IS_DISABLED){
            throw new BizException(RP.ACCOUNT_IS_DISABLED);
        }
        if (staff.getState() == StaffConstant.ACCOUNT_IS_LOCKED){
            throw new BizException(RP.ACCOUNT_IS_LOCKED);
        }
        //第一个参数将user对象传进去 使得后续授权可以获得user对象
        //第二个参数要吧密码传进去 让shiro做密码验证
        //第三个参数可以为空
        return new SimpleAuthenticationInfo(staff, staff.getPassword(), "");
    }
}
