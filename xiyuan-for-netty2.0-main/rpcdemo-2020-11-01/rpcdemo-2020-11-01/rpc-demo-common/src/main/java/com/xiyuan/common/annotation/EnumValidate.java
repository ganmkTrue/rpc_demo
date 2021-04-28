package com.xiyuan.common.annotation;

/**
 * 用于实现枚举类的校验
 */
public interface EnumValidate<T> {

    /**
     * 校验枚举值是否存在
     */
    boolean existValidate(T value);

}