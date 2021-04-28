package com.xiyuan.common.annotation.validatos;

import com.xiyuan.common.annotation.ActionTypeEnumValid;
import com.xiyuan.common.annotation.EnumValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 用于校验ActionTypeEnumValidator
 */
public class ActionTypeEnumValidator implements ConstraintValidator<ActionTypeEnumValid,String> {

    private Class<? extends Enum> enumClass;

    @Override
    public void initialize(ActionTypeEnumValid actionTypeEnumValid) {
        enumClass = actionTypeEnumValid.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || "".equals(value)) {
            return true;
        }

        EnumValidate[] enums = (EnumValidate[]) enumClass.getEnumConstants();
        if(enums ==null || enums.length == 0){
            return false;
        }

        return enums[0].existValidate(value);
    }

}
