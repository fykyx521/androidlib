package com.wf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Inherited
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FindView  {
	int id();  
	String touch() default "";//touch事件
	String click() default ""; //onclick事件
	String dbclick() default "";
	String itemclick() default "";//item click事件
	String longclick() default ""; // long click事件
	String className() default ""; //调用的目标类全名
	
}
