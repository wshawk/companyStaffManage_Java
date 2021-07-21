package com.hawk.company_staff_manage.test;

import com.hawk.company_staff_manage.test.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wsHawk
 * @Title: TestController
 * @ProjectName company-staff-manage
 * @Description: TODO
 * @since 2021/7/21 0:10
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @RequestMapping("/get_count")
    public Integer getStaffCount(){
        return testService.count();
    }

    @RequestMapping("/get_staff_no")
    public String getStaffNo(){
        return testService.getById(1L).getStaffNo();
    }
}
