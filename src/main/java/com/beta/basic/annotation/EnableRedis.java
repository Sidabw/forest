
package com.beta.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableRedis {
	/**
     * 缓存失效性 分钟
     *
     * @return int
     */
    int cacheMinutes() default 5;

    String poolId() default "";
}
