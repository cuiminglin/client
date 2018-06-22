package com.cui.aop;

import com.cui.controller.HelloController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by cuiminglin on 2018/6/12.
 */
//@SuppressWarnings("CheckStyle")
//@Aspect
//@Component
//@Order(2)
public class CheckUtil {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void controllerMethodPointcut() {
    }

    @Around("controllerMethodPointcut()")
    public Object checkPerm(ProceedingJoinPoint pjp) {
        Object target = pjp.getTarget();
        Class<?> clz = target.getClass();
        Object[] params = pjp.getArgs();

        LOGGER.error("===="+HelloController.temp.get());
        try {
           return pjp.proceed();
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
        }
        return null;

    }
}
