package com.hawk.company_staff_manage.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hawk.company_staff_manage.common.entity.staff.Staff;
import com.hawk.company_staff_manage.test.mapper.StaffMapper;
import com.hawk.company_staff_manage.test.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author wsHawk
 * @Title: TestServiceImpl
 * @ProjectName company-staff-manage
 * @Description: TODO
 * @since 2021/7/21 0:30
 */
@Service
public class TestServiceImpl extends ServiceImpl<StaffMapper, Staff> implements TestService {

}
