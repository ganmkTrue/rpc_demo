package com.xiyuan.common.annotation.aspect;

import com.xiyuan.common.annotation.InvokeParameterCheck;
import com.xiyuan.common.enums.ActionTypeEnum;
import com.xiyuan.common.enums.CouponTypeEnum;
import com.xiyuan.common.model.BusinessException;
import com.xiyuan.common.model.CommandPOJO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
@Component
@Aspect
public class InvokeParameterCheckAspect {

    @Pointcut("@annotation(com.xiyuan.common.annotation.InvokeParameterCheck)")
    public void pointCut() {
    }

    /**
     * 在这里扫描来校验 接口以及方法
     * 在切点运行前执行该方法是否存在
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        InvokeParameterCheck annotation = method.getAnnotation(InvokeParameterCheck.class);
        if (Objects.isNull(annotation)) {
            return;
        }
        CommandPOJO commandPOJO =(CommandPOJO) joinPoint.getArgs()[0];

    }



}
