package org.schhx.tutorial.resp.handler;

import org.schhx.tutorial.exception.BaseException;
import org.schhx.tutorial.exception.CommonBizException;
import org.schhx.tutorial.resp.ErrorResp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shanchao
 * @date 2020-04-05
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ErrorResp handleException(BaseException e) {
        return ErrorResp.of(e);
    }

    @ExceptionHandler(Exception.class)
    public ErrorResp handleException(Exception e) {
        return ErrorResp.of(new CommonBizException("未知异常", e));
    }
}
