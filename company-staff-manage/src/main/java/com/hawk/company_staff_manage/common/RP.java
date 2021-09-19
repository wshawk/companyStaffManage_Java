package com.hawk.company_staff_manage.common;

import com.hawk.company_staff_manage.common.exception.BaseError;
import lombok.Setter;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common
 * @desc 返回码及提示信息 Response Prompt
 * @date 2021/7/21
 */
public enum RP implements BaseError {
    /**
     * 10000-success
     */
    SUCCESS(10000, "success"),
    /**
     * 20000-系统内部错误, 请联系业务系统运维管理员
     */
    FAIL(20000, "系统内部错误, 请联系业务系统运维管理员"),
    /**
     * 20001-空指针异常
     */
    NULL_POINTER_ERROR(20001, "空指针异常"),
    /**
     * 20002-请求参数异常
     */
    REQUEST_FIELD_ERROR(20002, "请求参数异常"),

    /*
     * ****************************************************
     *                  登录模块-返回码
     * ****************************************************
     */
    /**
     * 20100-用户名或密码输入错误, 或该用户不存在
     */
    LOGIN_FAILED(20100, "用户名或密码输入错误, 或该用户不存在"),
    /**
     * 20101-该账号已被禁用
     */
    ACCOUNT_IS_DISABLED(20101, "该账号已被禁用"),
    /**
     * 20102-该账号已被锁定
     */
    ACCOUNT_IS_LOCKED(20102, "该账号已被锁定"),
;
    @Setter
    private int code;
    @Setter
    private String msg;
    @Override
    public int getCode(){
        return this.code;
    }
    @Override
    public String getMsg(){
        return this.msg;
    }
    RP(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
