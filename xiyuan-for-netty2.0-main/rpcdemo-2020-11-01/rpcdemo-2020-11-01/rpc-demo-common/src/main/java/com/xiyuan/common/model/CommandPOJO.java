package com.xiyuan.common.model;


import com.xiyuan.common.annotation.ActionTypeEnumValid;
import com.xiyuan.common.enums.ActionTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 指令的封装类
 */
@Getter
@Setter
@ToString
public class CommandPOJO implements Serializable {
    private static final long serialVersionUID = -8497328408069586664L;

    //指令
    @NotNull(message = "指令为必填项，不得为空")
    @ActionTypeEnumValid(message = "该指令暂不支持,暂时只支持invoke", enumClass = ActionTypeEnum.class)
    private String action ="invoke";

    //调用的类
    @NotNull(message = "调用类的路径为必填项，不得为空")
    private String invokeClass;

    //调用的具体方法
    @NotNull(message = "调用方法名为必填项，不得为空")
    private String invokeMethod;

    //调用接口的请求封装类全路径
    @NotNull(message = "请求类路径必填项，不得为空")
    private String requestPojoPath;

    //调用接口请求参数的Json
    @NotNull(message = "请求Json字符串为必填项，不得为空")
    private String requestParamsJson;


}
