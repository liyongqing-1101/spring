package com.bitflow.spring_learn.a10.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * MyService class
 *
 * @author liyongqing
 * @date 2023/8/25
 */
@Slf4j
@Service
public class MyService {

    public void foo() {
        log.debug("foo");
        bar();
    }

    public void bar() {
        log.debug("bar()");
    }



}
