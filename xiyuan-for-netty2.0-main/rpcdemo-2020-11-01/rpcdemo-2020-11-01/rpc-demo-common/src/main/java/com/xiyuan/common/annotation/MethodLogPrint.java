package com.xiyuan.common.annotation;
import java.lang.annotation.*;


/**
 * 自定义注解用于打印Controller层方式日志
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodLogPrint {
}
