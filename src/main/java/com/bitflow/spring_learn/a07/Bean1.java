package com.bitflow.spring_learn.a07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Bean1 class
 *
 * @author liyongqing
 * @date 2023/8/23
 */

@Slf4j
public class Bean1 implements InitializingBean {

    @PostConstruct
    public void init1() {
        log.debug("初始化1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("初始化2");
    }

    public void init3() {
        log.debug("初始化3");
    }

}
