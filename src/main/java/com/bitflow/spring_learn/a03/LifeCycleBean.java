package com.bitflow.spring_learn.a03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * LifeCycleBean class
 *
 * @author liyongqing
 * @date 2023/8/19
 */
@Slf4j
@Component
public class LifeCycleBean {

    public LifeCycleBean() {
        log.debug("构造");
    }

    @Autowired
    public void autowired(@Value("${JAVA_HOME}") String home) {
        log.debug("依赖注入:{}", home);
    }

    @PostConstruct
    public void init() {
        log.debug("初始化");
    }

    @PreDestroy
    public void destroy() {
        log.debug("销毁");
    }
}
