package com.hawk.company_staff_manage.common.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

/**
 * @author wsHawk
 * @Title: User
 * @ProjectName company-staff-manage
 * @Description: TODO
 * @since 2021/7/20 23:49
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 员工账号
     */
    private String staffNo;
    /**
     * 个人基础信息表id
     */
    private Long baseInfoId;
    /**
     * 公司任职信息表id
     */
    private Long companyInfoId;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色：0-管理员，1-普通用户
     */
    private Integer role;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改人
     */
    private String  modifyBy;
    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;
    /**
     * 账号状态：0：正常，1：已锁定，2：已禁用
     */
    private Integer state;
    /**
     * 0：有效，1：无效
     */
    private Integer enabledFlag;
}
