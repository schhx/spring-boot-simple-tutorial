package org.schhx.tutorial.config;

import com.alibaba.fastjson.JSON;
import org.schhx.tutorial.resp.SuccessResp;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author shanchao
 * @date 2020-04-05
 */
@ControllerAdvice(basePackages = {"org.schhx.tutorial.controller"})
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object result = SuccessResp.of(body);
        if (body instanceof String) {
            result = JSON.toJSONString(result);
            response.getHeaders().add("Content-type", "application/json");
        }
        return result;
    }
}
