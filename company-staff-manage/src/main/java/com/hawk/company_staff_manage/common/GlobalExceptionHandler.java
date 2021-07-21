package com.hawk.company_staff_manage.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common
 * @desc 全局异常处理类
 * @date 2021/7/21
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public R<Object> bizExceptionHandler(HttpServletRequest httpServletRequest, BizException ex) {
        return R.fail(ex.getErrorCode(), ex.getErrorMsg());
    }

    /**
     * 空指针异常处理程序
     *
     * @param req
     * @param e   e
     * @return {@link R}
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public R<Object> exceptionHandler(HttpServletRequest req, NullPointerException e) {
        return R.fail(RP.NULL_POINTER_EXCEPTION);
    }

    /**
     * 其他异常处理程序
     *
     * @param req
     * @param e   e
     * @return {@link R<Object>}
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R<Object> exceptionHandler(HttpServletRequest req, Exception e) {
        return R.fail(RP.FAIL);
    }
}
