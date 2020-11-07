package com.companystaffmanage.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.companystaffmanage.common.entity.TestUser;
import com.companystaffmanage.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wsHawk
 * @Title: UserMapper
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @since 2020/11/7 15:33
 */
@Mapper
public interface UserMapper extends BaseMapper<TestUser>{
}
