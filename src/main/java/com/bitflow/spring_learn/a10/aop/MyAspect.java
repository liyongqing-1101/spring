package com.bitflow.spring_learn.a10.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * MyAspect class
 *
 * @author liyongqing
 * @date 2023/8/25
 */
@Slf4j
@Aspect  // 注意此切面并未被 Spring 管理
public class MyAspect {

    @Before("execution(* com.bitflow.spring_learn.a10.service.MyService.*())")
    public void before() {
        log.debug("before()");
    }

}
