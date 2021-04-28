package com.xiyuan.common.model;

import com.xiyuan.common.enums.CouponTypeEnum;
import lombok.Getter;

/**
 * 业务自定义异常
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -1895174013651345407L;

    private final CouponTypeEnum errorCode;
    private String primaryErrorCode;
    private String primaryErrorMsg;
    private String primaryErrorIP;

    public BusinessException(CouponTypeEnum errorCode) {
        this(errorCode, errorCode.getCouponTypeDesc());
    }

    public BusinessException(CouponTypeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(CouponTypeEnum errorCode, String message, String primaryErrorCode, String primaryErrorMsg, String primaryErrorIP) {
        super(message);
        this.errorCode = errorCode;
        this.primaryErrorCode = primaryErrorCode;
        this.primaryErrorMsg = primaryErrorMsg;
        this.primaryErrorIP = primaryErrorIP;
    }

    public BusinessException(CouponTypeEnum errorCode, String primaryErrorCode, String primaryErrorMsg, String primaryErrorIP) {
        this(errorCode, errorCode.getCouponTypeDesc());
        this.primaryErrorCode = primaryErrorCode;
        this.primaryErrorMsg = primaryErrorMsg;
        this.primaryErrorIP = primaryErrorIP;
    }

}
