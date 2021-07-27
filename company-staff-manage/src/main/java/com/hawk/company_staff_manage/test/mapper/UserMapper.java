package com.hawk.company_staff_manage.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hawk.company_staff_manage.common.entity.staff.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wsHawk
 * @Title: UserMapper
 * @ProjectName company-staff-manage
 * @Description: TODO
 * @since 2021/7/21 0:31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
