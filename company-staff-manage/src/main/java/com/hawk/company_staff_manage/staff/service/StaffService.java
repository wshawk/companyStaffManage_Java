package com.hawk.company_staff_manage.staff.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.staff.entity.Staff;

/**
 * @author hawk
 * @desc
 * @date 2021/7/21 0:16
 */
public interface StaffService extends IService<Staff> {

    R<Boolean> add(Staff staff);

    R<Boolean> login(Staff staff);
}
