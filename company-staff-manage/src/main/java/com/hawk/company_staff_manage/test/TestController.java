package com.hawk.company_staff_manage.test;

import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.common.RP;
import com.hawk.company_staff_manage.common.exception.BizException;
import com.hawk.company_staff_manage.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wsHawk
 * @Title: TestController
 * @ProjectName company-staff-manage
 * @Description: 测试类
 * @since 2021/7/21 0:10
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TestService testService;

    @RequestMapping("/get_count")
    public R<Integer> getStaffCount(){
        log.info("TestController getStaffCount Method start");
        return R.success(testService.count());
    }

    @RequestMapping("/get_staff_no")
    public R<String> getStaffNo(){
        throw new BizException(RP.ACCOUNT_IS_DISABLED);
//        return R.success(testService.getById(1L).getStaffNo());
    }
}
