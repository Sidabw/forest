package com.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodInfo {
	public enum Color{BULE,RED,GREEN};
	Color fruitColor() default Color.BULE;
	    String author() default "brew";
	    String date();
	    int revision() default 1;
	    String comments();
}
