package com.hawk.company_staff_manage.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hawk.company_staff_manage.common.entity.staff.Staff;
import com.hawk.company_staff_manage.staff.mapper.StaffMapper;
import com.hawk.company_staff_manage.staff.service.StaffService;
import org.springframework.stereotype.Service;

/**
 * @author hawk
 * @desc 员工service实现类
 * @date 2021/7/21 0:30
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

}
