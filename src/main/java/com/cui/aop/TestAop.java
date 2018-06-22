package com.cui.aop;

import java.lang.annotation.*;

/**
 * Created by cuiminglin on 2018/6/12.
 */
@Retention(RetentionPolicy.RUNTIME )
@Target({ElementType.METHOD})
@Documented
public @interface TestAop {
    boolean checkId() default true;
}
