package com.hawk.company_staff_manage.common;

import lombok.Setter;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common
 * @desc 返回码及提示信息 Response Prompt
 * @date 2021/7/21
 */
public enum RP {
    /**
     * 默认成功的返回码
     */
    SUCCESS(10000, "SUCCESS"),
    /**
     * 默认失败的返回码
     */
    FAIL(20000, "系统内部错误, 请联系业务系统运维管理员");



    @Setter
    private int code;
    @Setter
    private String msg;

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }
    RP(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
