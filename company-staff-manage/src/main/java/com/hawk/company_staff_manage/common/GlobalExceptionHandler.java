package com.hawk.company_staff_manage.common;

import com.hawk.company_staff_manage.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    public <T> R<T> bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("业务异常| 请求路径:{}, 错误码: {}, 提示信息: {}", req.getRequestURI(), e.getErrorCode(), e.getErrorMsg());
        return R.fail(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 空指针异常处理程序
     *
     * @param req HttpServletRequest
     * @param e   e
     * @return {@link R}
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public <T> R<T> exceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("空指针异常,请求路径：{}, 可能出错的位置: {}",req.getRequestURI(), e.getCause().toString());
        return R.fail(RP.NULL_POINTER_ERROR);
    }
    /**
     * 其他异常处理程序
     *
     * @param req HttpServletRequest
     * @param e   e
     * @return {@link R<Object>}
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> R<T> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("系统错误, 请求路径: {}, 提示信息: {}, 可能出错的位置: {}",req.getRequestURI(), e.getMessage(), e.getCause().toString());
        if (e.getCause() instanceof  BizException){
            BizException bizException = (BizException) e.getCause();
            log.error("业务异常| 错误码: {}, 提示信息: {}",   bizException.getErrorCode(), bizException.getErrorMsg());
            return R.fail(bizException.getErrorCode(), bizException.getErrorMsg());
        }
        return R.fail(RP.FAIL);
    }

    //后端校验异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public <T> R<T> handValidException(MethodArgumentNotValidException e){
        return R.fail(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}
