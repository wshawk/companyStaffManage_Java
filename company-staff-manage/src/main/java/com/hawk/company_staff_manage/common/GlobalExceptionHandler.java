package com.hawk.company_staff_manage.common;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public R<Object> bizExceptionHandler(HttpServletRequest httpServletRequest, BizException e) {
        log.error("业务异常| 错误码: {}, 提示信息: {}", e.getErrorCode(), e.getErrorMsg());
        return R.fail(e.getErrorCode(), e.getErrorMsg());
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
        log.error("空指针异常, 可能出错的位置: {}", e.getCause().toString());
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
        log.error("系统错误, 提示信息: {}, 可能出错的位置: {}", e.getMessage(), e.getCause().toString());
        return R.fail(RP.FAIL);
    }
}
