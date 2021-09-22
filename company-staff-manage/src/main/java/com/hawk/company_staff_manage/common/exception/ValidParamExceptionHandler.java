package com.hawk.company_staff_manage.common.exception;

import com.hawk.company_staff_manage.common.R;
import com.hawk.company_staff_manage.common.RP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hawk
 * @package com.hawk.company_staff_manage.common.exception
 * @desc jsr303 校验异常捕获处理
 * @date 2021/9/22
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ValidParamExceptionHandler {
    /**
     * 入参校验异常
     *
     * @param e   MethodArgumentNotValidException
     * @param <T> 返回结果
     */
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public <T> R<T> handValidException(Exception e) {
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        } else if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        }
        String errorMessage = RP.REQUEST_FIELD_ERROR.getMsg();
        if (bindingResult != null && bindingResult.hasFieldErrors()) {
            errorMessage = bindingResult.getFieldErrors().get(0).getDefaultMessage();
        }

        return R.fail(RP.REQUEST_FIELD_ERROR.getCode(), errorMessage);
    }
}
