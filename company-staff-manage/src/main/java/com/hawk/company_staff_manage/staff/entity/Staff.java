package com.hawk.company_staff_manage.staff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hawk
 * @date 2021/7/20 23:49
 */
@Data
@TableName("staff")
public class Staff {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 员工账号
     */
    private String staffNo;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别 0-男，1-女
     */
    private Integer gender;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色表id
     */
    private Integer roleId;
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
