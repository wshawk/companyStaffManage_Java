package com.hawk.company_staff_manage.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.common.RP;
import com.hawk.company_staff_manage.staff.entity.Staff;
import com.hawk.company_staff_manage.staff.mapper.StaffMapper;
import com.hawk.company_staff_manage.staff.service.StaffService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author hawk
 * @desc 员工service实现类
 * @date 2021/7/21 0:30
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Override
    public R<Boolean> add(Staff staff) {
        return null;
    }

    @Override
    public R<Boolean> login(Staff staff) {
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
