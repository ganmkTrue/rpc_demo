package com.xiyuan.common.enums;

import lombok.Getter;

@Getter
public enum CouponTypeEnum {

    PARAMETER_ERROR(1001, "请求参数有误!"),
    UNKNOWN_ERROR(9999, "未知的错误!"),

    SAVE_SUCCESS (1,"保存成功!"),

    SAVE_ERROR  (2,"保存失败!"),

    DELETE_SUCCESS (3,"删除成功!"),

    LOGIN_ERROR_NULL(4,"请先进行用户登录"),

    DELETE_ERROR  (5,"删除失败!"),

    QUERY_SUCCESS (6,"查询成功!") ,

    LOGIN_ERROR  (7,"用户不存在或密码错误!"),

    CREATE_GRADE_ERROR (8,"该类型有同名的权限"),

    QUERY_ERROR (9,"查询失败!"),

    importExcel_ERROR (10,"导入失败请检查Excel文件!"),

    QUERY_ERROR_DEPLOY (11,"不允许雨燕部署，请选择手工部署!"),

    OPERATE_SUCCESS (12,"操作成功!"),

    OPERATE_ERROR  (13,"操作失败!"),

    EXPORTEXCEL_ERROR (14,"请选择需要导出的数据!"),

    EXPORTEXCEL_ERROR1 (15,"当前没有可导出的数据"),

    IMPORTEXCEL ( 16,"导入操作失败!"),

    NNR_ERROR  (17,"内部服务器异常!"),
    INNR_ERROR2 ( 18,"请检查导入文件是否正确!"),
    PARAM_ERROR  (19,"参数异常!"),



    /**权限状态**/
    NEED_AUTHORITIES(403,"无权访问"),
    NEED_LOGIN(402,"未登录"),
    LOGIN_FAILURE(401,"登陆失败"),
    SESSION_EXPIRES(101,"session 过期"),


    VERIFICATION_CODE_FAILURE (20,"验证码已失效!") ,
    VERIFICATION_CODE_ERROR  (21,"验证码错误!"),
    USER_ALREADY_EXISTS (23,"用户已存在"),
    NEW_USER_FAILED(24,"新增用户失败");


    /**
     * 状态值
     */
    private int couponType;

    /**
     * 状态描述
     */
    private String couponTypeDesc;


    CouponTypeEnum(int couponType, String couponTypeDesc){
        this.couponType = couponType;
        this.couponTypeDesc = couponTypeDesc;
    }


    public static String getDescByType(int couponType) {
        for (CouponTypeEnum type : CouponTypeEnum.values()) {
            if (type.couponType == couponType) {
                return type.couponTypeDesc;
            }
        }
        return null;
    }

    public String getcouponTypeStr(){
        return String.valueOf(this.couponType);
    }

}
