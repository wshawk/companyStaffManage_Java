package com.hawk.company_staff_manage.common;

import java.io.Serializable;

/**
 * @author wsHawk
 * @Title: R
 * @ProjectName company-staff-manage
 * @Description: TODO
 * @since 2021/7/20 22:46
 */
public class R implements Serializable {
    private static final long serialVersionUID = 6350328271121587814L;

    private static final int SUCCESS_CODE = 20000;
    private static final String SUCCESS_MESSAGE = "success";
    private static final int FAIL_CODE = 30000;
    private static final String FAIL_MESSAGE = "fail";
    /**
     * 状态码
     */
    private final int code;
    /**
     * 提示信息
     */
    private final String message;
    /**
     * 结果
     */
    private Object data;

    private R(int code, String message){
        this.code = code;
        this.message = message;
    }

    private R(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static R success(Object data){
        return new R(SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }

    public static R success(){
        return new R(SUCCESS_CODE, SUCCESS_MESSAGE,null);
    }

    public static R fail(int code, String errorMessage){
        return new R(code, errorMessage,null);
    }

    public static R fail(){
        return new R(FAIL_CODE, FAIL_MESSAGE, null);
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}