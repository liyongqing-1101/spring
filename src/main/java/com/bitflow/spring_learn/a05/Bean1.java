package com.bitflow.spring_learn.a05;

import lombok.extern.slf4j.Slf4j;

/**
 * Bean1 class
 *
 * @author liyongqing
 * @date 2023/8/23
 */
@Slf4j
public class Bean1 {

    public Bean1() {
        log.debug("我被 Spring 管理啦！bean1");
    }
}
