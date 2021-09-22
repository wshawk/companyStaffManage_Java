package com.hawk.company_staff_manage.common.exception;

import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.common.RP;
import com.hawk.company_staff_manage.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    /**
     * 业务异常处理
     * @param e 业务异常
     * @param <T> 返回结果
     * @return {@link R <T>}
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = BizException.class)
    public <T> R<T> bizExceptionHandler(BizException e) {
        log.error("业务异常| 错误码: {}, 提示信息: {}", e.getErrorCode(), e.getErrorMsg());
        return R.fail(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 空指针异常处理程序
     *
     * @param e   e
     * @return {@link R<T>}
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = NullPointerException.class)
    public <T> R<T> exceptionHandler(NullPointerException e) {
        log.error("空指针异常, 可能出错的位置: {}", e.getCause().toString());
        return R.fail(RP.NULL_POINTER_ERROR);
    }
    /**
     * 其他异常处理程序
     *
     * @param e   e
     * @return {@link R<T>}
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public <T> R<T> exceptionHandler(Exception e) {
        if (e instanceof  BizException){
            BizException bizException = (BizException) e;
            log.error("业务异常| 错误码: {}, 提示信息: {}", bizException.getErrorCode(), bizException.getErrorMsg());
            return R.fail(bizException.getErrorCode(), bizException.getErrorMsg());
        }
        log.error("系统错误: ", e);
        return R.fail(RP.FAIL);
    }
}
