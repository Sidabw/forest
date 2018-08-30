package com.beta.config.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yando on 2017/11/10.
 */
@Controller
public class ExceptionController {
	private Logger logger = Logger.getLogger(ExceptionController.class);

    @RequestMapping("/nException")
    public String nException() throws Exception {
    	logger.error("Exception:将要到 thymeleaf模板error.html");
        throw new Exception("这里有个错误异常") ;
    }

   /*@RequestMapping("/jsonException")
    public String jsonException() throws MyException {
	   logger.error("Exception:返回页面指定json串表示异常；");
        throw new MyException("这里有个错误异常");
    }*/
}
