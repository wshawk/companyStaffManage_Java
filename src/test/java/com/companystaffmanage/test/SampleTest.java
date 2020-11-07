package com.companystaffmanage.test;

import com.companystaffmanage.common.entity.TestUser;
import com.companystaffmanage.common.entity.User;
import com.companystaffmanage.login.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wsHawk
 * @Title: SampleTest
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @since 2020/11/7 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<TestUser> userList = userMapper.selectList(null);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

}
