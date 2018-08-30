package com.beta.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yando on 2017/11/10.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorname", "统一异常处理页面");
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ErrorInfo<String> elErrorHandler(HttpServletRequest request, MissingServletRequestParameterException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("请求参数错误");
        r.setUrl(request.getRequestURL().toString());
        System.out.println("-----------------------------------");
        return r;
    }
}
