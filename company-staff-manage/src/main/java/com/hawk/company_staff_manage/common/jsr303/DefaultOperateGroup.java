package com.hawk.company_staff_manage.common.jsr303;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common.jsr303
 * @desc
 * @date 2021/9/19
 */
public interface DefaultOperateGroup {
    /**
     * 新增
     */
    interface Add{};

    /**
     * 编辑
     */
    interface Edit{};

    /**
     * 查询列表
     */
    interface List{};

    /**
     * 查询详情
     */
    interface Detail{};

    /**
     * 删除
     */
    interface Delete{};
}
