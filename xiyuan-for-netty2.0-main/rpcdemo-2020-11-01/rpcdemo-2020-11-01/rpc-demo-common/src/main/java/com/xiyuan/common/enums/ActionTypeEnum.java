package com.xiyuan.common.enums;

import com.xiyuan.common.annotation.EnumValidate;
import lombok.Getter;


@Getter
public enum ActionTypeEnum implements EnumValidate<String> {

    ACTION_INVOKR("invoke", "invoke"),
    UNKNOWN_ERROR("no", "no");

    /**
     * 状态值
     */
    private String couponType;

    /**
     * 状态描述
     */
    private String couponTypeDesc;


    ActionTypeEnum(String couponType, String couponTypeDesc) {
        this.couponType = couponType;
        this.couponTypeDesc = couponTypeDesc;
    }


    public static String getDescByType(String couponType) {
        for (ActionTypeEnum type : ActionTypeEnum.values()) {
            if (type.couponType.equals(couponType) ) {
                return type.couponTypeDesc;
            }
        }
        return null;
    }

    /**
     * 判断是否在枚举类当中
     * @param value
     * @return
     */
    @Override
    public boolean existValidate(String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        for (ActionTypeEnum testEnum : ActionTypeEnum.values()) {
            if (testEnum.getCouponType().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }



    public String getcouponTypeStr() {
        return String.valueOf(this.couponType);
    }
}
