package com.xiyuan.common.model;



import com.xiyuan.common.enums.CouponTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 〈响应实体类〉
 * 〈功能详细描述〉
 * 响应的封装类
 **/
@Setter
@Getter
@ToString
public class ResponseResult implements Serializable {
    private Boolean success = false; //响应的成功标识
    private Object value; //响应返回的Object
    private String errorCode;//错误编码
    private String errorMsg;//错误提示


    public ResponseResult() {

    }

    public ResponseResult(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ResponseResult(CouponTypeEnum couponTypeEnum) {
        this.errorCode = couponTypeEnum.getcouponTypeStr();
        this.errorMsg = couponTypeEnum.getCouponTypeDesc();
    }

    public static ResponseResult success() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        return responseResult;
    }

    public static ResponseResult success(String message) {
        ResponseResult responseResult = success();
        responseResult.setErrorMsg(message);
        return responseResult;
    }

    public static ResponseResult success(Object data, String message) {
        ResponseResult responseResult = success();
        responseResult.setValue(data);
        responseResult.setErrorMsg(message);
        return responseResult;
    }

    public ResponseResult success(Object data, String message, String str) {
        ResponseResult responseResult = success();
        responseResult.setValue(data);
        responseResult.setErrorMsg(message);
        return responseResult;
    }


    public static ResponseResult error() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        return responseResult;
    }

    public static ResponseResult error(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setErrorMsg(message);
        return responseResult;
    }

    public static ResponseResult error(String message, String str) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setErrorMsg(message);
        return responseResult;
    }

    public static ResponseResult error(Object data, String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setErrorMsg(message);
        responseResult.setValue(data);
        return responseResult;
    }

    public static ResponseResult error(CouponTypeEnum couponTypeEnum) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setErrorCode(couponTypeEnum.getcouponTypeStr());
        responseResult.setErrorMsg(couponTypeEnum.getCouponTypeDesc());
        return responseResult;
    }

}
