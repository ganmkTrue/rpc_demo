package com.xiyuan.server.service.impl;

import com.alibaba.fastjson.JSONException;
import com.xiyuan.common.enums.CouponTypeEnum;
import com.xiyuan.common.model.BusinessException;
import com.xiyuan.common.model.CommandPOJO;
import com.xiyuan.common.model.ResponseResult;
import com.xiyuan.common.utils.FastJsonUtils;
import com.xiyuan.common.utils.SpringUtil;
import com.xiyuan.server.service.IInvokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@Slf4j
public class InvokeServiceImpl implements IInvokeService {


    /**
     * 用于获取SpringBean
     */
    private static ApplicationContext context = SpringUtil.getApplicationContext();

    /**
     * 调用方法(带参数)
     *
     * @param commandPOJO
     * @return
     */
    @Override
    public ResponseResult invokeMethod(CommandPOJO commandPOJO) {
        ResponseResult responseResult = ResponseResult.error();
        Class<?> tClass = null;
        Class<?> rClass = null;
        try {
            tClass = Class.forName(commandPOJO.getInvokeClass());
            try {
                rClass = Class.forName(commandPOJO.getRequestPojoPath());
            } catch (ClassNotFoundException e) {
                log.error("请求类{}不存在，异常{}", commandPOJO.getRequestPojoPath(), e);
                throw new BusinessException(CouponTypeEnum.OPERATE_ERROR, "请求类:" + commandPOJO.getRequestPojoPath() + "不存在");
            }
            Method method = tClass.getMethod(commandPOJO.getInvokeMethod(), rClass);
            return ResponseResult.success(method.invoke(tClass.newInstance(), FastJsonUtils.convertJsonToObject(commandPOJO.getRequestParamsJson(), rClass)), CouponTypeEnum.OPERATE_SUCCESS.getCouponTypeDesc());
        } catch (ClassNotFoundException classBiz) {
            log.error("服务端接口{}不存在，异常{}", commandPOJO.getInvokeClass(), classBiz);
            responseResult.setErrorMsg("服务端该接口:" + commandPOJO.getInvokeClass() + "不存在");
        } catch (NoSuchMethodException nbiz) {
            log.error("服务端接口{}没有方法{}，异常{}", commandPOJO.getInvokeClass(), commandPOJO.getInvokeMethod(), nbiz);
            responseResult.setErrorMsg("服务端接口:" + commandPOJO.getInvokeClass() + "没有该方法:" + commandPOJO.getInvokeMethod());
        } catch (JSONException jsonException) {
            log.error("请求json字符串违法{}，无法转换成对应的请求类{}", commandPOJO.getRequestParamsJson(), commandPOJO.getRequestPojoPath(), jsonException);
            responseResult.setErrorMsg("请求json字符串违法:" + commandPOJO.getRequestParamsJson() + ",无法转换成对应的请求类:" + commandPOJO.getRequestPojoPath());
        } catch (BusinessException biz) {
            log.error("调用方法业务层异常", biz);
            responseResult.setErrorMsg("调用方法业务层异常" + biz.getMessage());
        } catch (Exception e) {
            log.error("调用方法异常", e);
            responseResult.setErrorMsg("调用方法异常" + e.getMessage());
        }
        return responseResult;
    }

}
