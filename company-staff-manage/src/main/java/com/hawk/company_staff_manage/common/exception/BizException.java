package com.hawk.company_staff_manage.common.exception;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common
 * @desc 自定义业务异常类
 * @date 2021/7/21
 */
public class BizException extends RuntimeException{
    /**
     * 错误代码
     */
    private int errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    public BizException() {
        super();
    }

    public BizException(String message, String errorMsg) {
        super(message);
        this.errorMsg = errorMsg;
    }

    public BizException(String message, int errorCode, String errorMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(BaseError baseError) {
        super(String.valueOf(baseError.getCode()));
        this.errorCode = baseError.getCode();
        this.errorMsg = baseError.getMsg();
    }

    public BizException(BaseError baseError, Throwable cause) {
        super(String.valueOf(baseError.getCode()), cause);
        this.errorCode = baseError.getCode();
        this.errorMsg = baseError.getMsg();
    }

    public BizException(Throwable cause, int errorCode, String errorMsg) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
