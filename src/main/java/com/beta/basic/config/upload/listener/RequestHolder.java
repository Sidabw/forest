/**
 * Copyright (C), 2018-2018, zenki.ai
 * FileName: RequestHolder
 * Author:   feiyi
 * Date:     2018/11/5 上午10:08
 * Description: 获取HttpServletRequest 和 HttpServletResponse 工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.config.upload.listener;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉:
 * 〈获取HttpServletRequest 和 HttpServletResponse 工具类〉
 *
 * @author feiyi
 * @create 2018/11/5
 * @since 1.0.0
 */
public class RequestHolder {
    public static HttpServletRequest getRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes == null)
            return null;
        return ((ServletRequestAttributes)requestAttributes).getRequest();
    }
    public static HttpServletResponse getResponse(){
        HttpServletResponse resp = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        return resp;
    }
}
