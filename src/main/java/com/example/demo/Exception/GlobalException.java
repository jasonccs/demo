package com.example.demo.Exception;

import com.example.demo.Result.Result;
import com.example.demo.Result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 全局异常处理类
 * @author 欧阳
 * @since 2019年4月12日 下午3:52:04
 * @version V1.0
 */
//@ControllerAdvice
@RestControllerAdvice
public class GlobalException {

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);


    /**
     * 描述：捕获 ArithmeticException 异常
     * @param model 将Model对象注入到方法中
     * @param e 将产生异常对象注入到方法中
     * @return 指定错误页面
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public String arithmeticExceptionHandle(Model model, Exception e) {

        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
        log.info(e.getMessage());

        return "error";
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result<Object> HttpRequestMethodNotSupportedException(Model model, Exception e) {

//        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
        log.info(e.getMessage());

        return  new Result<>(ResultCode.NO_METHOD_SUPPORT, e.getMessage());
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> MissingServletRequestParameterException(Model model, Exception e) {

//        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
        log.info(e.getMessage());

        return  new Result<>(ResultCode.VALIDATE_FAILED, e.getMessage());
    }

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public Result<Object> HttpMediaTypeNotSupportedException(Model model, Exception e) {

//        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
        log.info(e.getMessage());
        return  new Result<>(ResultCode.UNSUPPORTED_MEDIA_TYPE, e.getMessage());
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> HttpMessageNotReadableException(Model model, Exception e) {

//        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
        log.info(e.getMessage());
        return  new Result<>(ResultCode.UNSUPPORTED_MEDIA_TYPE, e.getMessage());
    }



//    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public  Result<Object> HttpRequestMethodNotSupportedExceptionHandle(HttpRequestMethodNotSupportedException e) {
//
////        model.addAttribute("msg", "@ControllerAdvice + @ExceptionHandler :" + e.getMessage());
//        log.info(e.getMessage());
////        List<String> list=new ArrayList<>();        // 从异常对象中拿到ObjectError对象
////        if (!e.getBindingResult().getAllErrors().isEmpty()){
////            for(ObjectError error:e.getBindingResult().getAllErrors()){
////                list.add(error.getDefaultMessage().toString());
////            }
////        }
//        // 然后提取错误提示信息进行返回
//
//        return  new Result<>(ResultCode.NO_METHOD_SUPPORT, e.getMessage());
//    }



    /**
     * 自定义异常APIException
     */
    @ExceptionHandler(APIException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> APIExceptionHandler(APIException e) {
        log.error("api异常");
        return  new Result<>(ResultCode.FAILED, e.getMsg());
    }

    /**
     * 方法参数错误异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("方法参数错误异常");
        List<String> list=new ArrayList<>();        // 从异常对象中拿到ObjectError对象
        if (!e.getBindingResult().getAllErrors().isEmpty()){
            for(ObjectError error:e.getBindingResult().getAllErrors()){
                list.add(error.getDefaultMessage().toString());
            }
        }
        // 然后提取错误提示信息进行返回
        return new Result<>(ResultCode.VALIDATE_FAILED, list);
    }

}