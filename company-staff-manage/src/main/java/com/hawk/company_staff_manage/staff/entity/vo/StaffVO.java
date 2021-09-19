package com.hawk.company_staff_manage.staff.entity.vo;

import com.hawk.company_staff_manage.common.jsr303.DefaultOperateGroup;
import com.hawk.company_staff_manage.common.jsr303.StaffValidator;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.staff.entity.vo
 * @desc StaffVO 类
 * @date 2021/9/19
 */
@Data
public class StaffVO implements Serializable {
    private String id;
    /**
     * 员工账号
     */
    @NotBlank(message = "员工编号不能为空", groups = StaffValidator.Login.class)
    private String staffNo;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空", groups = StaffValidator.Add.class)
    private String name;
    /**
     * 性别 0-男，1-女
     */
    @NotBlank(message = "性别不能为空", groups = StaffValidator.Add.class)
    @Size(min = 1, max = 1, message = "性别格式错误", groups = StaffValidator.Add.class)
    private String gender;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = StaffValidator.Login.class)
    private String password;
    /**
     * 角色表id
     */
    private String roleId;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改人
     */
    private String  modifyBy;
}
