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
	String touch() default "";//touch�¼�
	String click() default ""; //onclick�¼�
	String dbclick() default "";
	String itemclick() default "";//item click�¼�
	String longclick() default ""; // long click�¼�
	String className() default ""; //���õ�Ŀ����ȫ
}
