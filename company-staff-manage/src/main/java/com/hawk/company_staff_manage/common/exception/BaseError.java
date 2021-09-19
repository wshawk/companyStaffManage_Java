package com.hawk.company_staff_manage.common.exception;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common
 * @desc
 * @date 2021/7/21
 */
public interface BaseError {
    /**
     * 得到错误码
     *
     * @return {@link String}
     */
    int getCode();

    /**
     * 得到错误信息
     *
     * @return {@link String}
     */
    String getMsg();
}
