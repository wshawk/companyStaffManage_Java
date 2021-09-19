package com.hawk.company_staff_manage.common;

import java.io.Serializable;

/**
 * @author wsHawk
 * @Title: R
 * @ProjectName company-staff-manage
 * @Description: 全局统一返回类
 * @since 2021/7/20 22:46
 */
public final class R<T> implements Serializable {
    private static final long serialVersionUID = 6350328271121587814L;

    private static final int SUCCESS_CODE = RP.SUCCESS.getCode();
    private static final String SUCCESS_MESSAGE = RP.SUCCESS.getMsg();
    private static final int FAIL_CODE = RP.FAIL.getCode();
    private static final String FAIL_MESSAGE = RP.FAIL.getMsg();
    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 结果
     */
    private T data;

    private R(){

    }
    private R(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private R(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> R<T> success(){
        return new R<>(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static <T> R<T> success(T data){
        return new R<>(SUCCESS_CODE,SUCCESS_MESSAGE,data);
    }

    public static <T> R<T> fail(){
        return new R<>(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public static <T> R<T> fail(String errorMessage){
        return new R<>(FAIL_CODE, errorMessage,null);
    }

    public static <T> R<T> fail(int code, String errorMessage){
        return new R<>(code, errorMessage,null);
    }

    public static <T> R<T> fail(RP rp){
        return new R<>(rp.getCode(), rp.getMsg(),null);
    }
    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean checkSuccess(){
        return this.code == SUCCESS_CODE;
    }

    public boolean checkFailure(){
        return !checkSuccess();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}