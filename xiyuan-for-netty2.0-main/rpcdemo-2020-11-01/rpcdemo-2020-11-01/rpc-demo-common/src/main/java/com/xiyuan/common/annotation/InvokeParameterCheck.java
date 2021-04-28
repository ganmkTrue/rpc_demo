package com.xiyuan.common.annotation;


import java.lang.annotation.*;

/**
 * 用于对远程调用的请求参数进行检验
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface InvokeParameterCheck {
}
