package com.Java.bak.middle.ssmBak.SSMAuthManage.src.com.zpark.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
 
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {
	/**
     * 权限类型
     */
    String type() default "";
    /**
     * 是否需要写权限
     */
    boolean write() default false;
}
