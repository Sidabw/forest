/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: AspectTest2
 * Author:   feiyi
 * Date:     2019/1/23 3:27 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/23
 * @since 1.0.0
 */
@Aspect
@Component
public class AspectTest2 {


    @Pointcut("execution(public * com.alibaba.fastjson..*.*(..))")
    public void aspectTest() {}

    @Around("aspectTest()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("pre.............");
        return pjp.proceed();
    }
}
