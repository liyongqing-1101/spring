package com.bitflow.spring_learn.a05.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Bean2 class
 *
 * @author liyongqing
 * @date 2023/8/23
 */
@Slf4j
@Component
public class Bean2 {

    public Bean2() {
        log.debug("我被 Spring 管理了！");
    }

}
