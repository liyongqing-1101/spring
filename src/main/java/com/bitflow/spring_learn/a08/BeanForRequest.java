package com.bitflow.spring_learn.a08;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * BeanForRequest class
 *
 * @author liyongqing
 * @date 2023/8/24
 */
@Slf4j
@Scope("request")
@Component
public class BeanForRequest {

    @PreDestroy
    public void destroy() {
        log.debug("destroy");
    }

}
