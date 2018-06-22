package com.cui.configure;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAopInDao {


    private static Logger log = LoggerFactory.getLogger(DataSourceAopInDao.class);

    @Before("execution(* com.cui.dao..*.find*(..)) "
            + " or execution(* com.cui.dao..*.get*(..)) "
            + " or execution(* com.cui.dao..*.select*(..)) "
            + " or execution(* com.cui.dao.*.query*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.setRead();
    }

    @Before("execution(* com.cui.dao..*.insert*(..)) "
            + " or execution(* com.cui.dao..*.update*(..))"
            + " or execution(* com.cui.dao..*.add*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }
}
