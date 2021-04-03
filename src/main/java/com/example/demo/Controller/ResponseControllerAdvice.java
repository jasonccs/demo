package com.example.demo.Controller;

import com.example.demo.Exception.APIException;
import com.example.demo.Result.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @author suruomo
 * @date 2020/8/7 16:38
 * @description: 全局处理增强版Controller，避免Controller里返回数据每次都要用响应体来包装
 */
@RestControllerAdvice(basePackages = {"com.example.demo.Controller"}) // 注意哦，这里要加上需要扫描的包
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !returnType.getGenericParameterType().equals(Result.class);
    }
    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, @NotNull MediaType mediaType, @NotNull Class<? extends HttpMessageConverter<?>> aClass, @NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new Result<>(data));
            } catch (JsonProcessingException e) {
                throw new APIException();
            }
        }
        // 将原本的数据包装在ResultVO里
        return new Result<>(data);
    }
}
