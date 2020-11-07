package com.companystaffmanage.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wsHawk
 * @Title: TestUser
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @since 2020/11/7 15:36
 */
@Data
@TableName("test_user")
public class TestUser implements Serializable {
    private static final long serialVersionUID = 6227881306950516152L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
