package org.schhx.tutorial.exception.handler;

import org.schhx.tutorial.exception.BaseException;
import org.schhx.tutorial.exception.CommonBizException;
import org.schhx.tutorial.exception.RequestException;
import org.schhx.tutorial.resp.ErrorResp;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author schhx
 * @date 2020-04-05
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ErrorResp handleBindException(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMsg = errorFieldToString(fieldErrors);
        return ErrorResp.of(new RequestException(errorMsg));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResp handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMsg = errorFieldToString(fieldErrors);
        return ErrorResp.of(new RequestException(errorMsg));
    }

    private String errorFieldToString(List<FieldError> fieldErrors) {
        StringJoiner stringJoiner = new StringJoiner(";");
        for (FieldError fieldError : fieldErrors) {
            stringJoiner.add(fieldError.getDefaultMessage());
        }
        return stringJoiner.toString();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResp handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> set = e.getConstraintViolations();
        StringJoiner stringJoiner = new StringJoiner(";");
        for (ConstraintViolation constraintViolation : set) {
            stringJoiner.add(constraintViolation.getMessage());
        }
        String errorMsg = stringJoiner.toString();
        return ErrorResp.of(new RequestException(errorMsg));
    }

    @ExceptionHandler({
            NoHandlerFoundException.class, MissingPathVariableException.class,
            HttpMessageNotReadableException.class, HttpRequestMethodNotSupportedException.class,
            MissingServletRequestParameterException.class
    })
    public ErrorResp handleRequestException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return ErrorResp.of(new RequestException("请求路由不存在", e));
        } else if (e instanceof MissingPathVariableException) {
            return ErrorResp.of(new RequestException("缺少路径参数", e));
        } else if (e instanceof HttpMessageNotReadableException) {
            return ErrorResp.of(new RequestException("请输入正确的参数", e));
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return ErrorResp.of(new RequestException("HTTP请求方法错误", e));
        } else if(e instanceof MissingServletRequestParameterException){
            return ErrorResp.of(new RequestException("缺少必填参数", e));
        }
        return ErrorResp.of(new CommonBizException("未知异常", e));
    }

    @ExceptionHandler(BaseException.class)
    public ErrorResp handleException(BaseException e) {
        return ErrorResp.of(e);
    }

    @ExceptionHandler(Exception.class)
    public ErrorResp handleException(Exception e) {
        return ErrorResp.of(new CommonBizException("未知异常", e));
    }
}
