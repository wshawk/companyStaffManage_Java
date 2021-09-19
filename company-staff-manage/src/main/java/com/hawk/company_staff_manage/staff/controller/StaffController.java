package com.hawk.company_staff_manage.staff.controller;

import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.common.jsr303.DefaultOperateGroup;
import com.hawk.company_staff_manage.common.jsr303.StaffValidator;
import com.hawk.company_staff_manage.staff.entity.vo.StaffVO;
import com.hawk.company_staff_manage.staff.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.staff.controller
 * @desc 员工controller
 * @date 2021/9/19
 */
@Slf4j
@RestController
@RequestMapping("/csm/staff")
public class StaffController {
    @Resource
    StaffService staffService;

    @PostMapping("/login")
    public R<Boolean> login(@Validated(StaffValidator.Login.class) @RequestBody StaffVO staff){
        return staffService.login(staff);
    }

    @PostMapping("/add")
    public R<Boolean> add(@Validated(StaffValidator.Add.class) @RequestBody StaffVO staff){
        return staffService.add(staff);
    }
}
