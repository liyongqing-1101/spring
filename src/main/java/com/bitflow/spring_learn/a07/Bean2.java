package com.bitflow.spring_learn.a07;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * Bean2 class
 *
 * @author liyongqing
 * @date 2023/8/23
 */
@Slf4j
public class Bean2 implements DisposableBean {

    @PreDestroy
    public void destroy1() {
        log.debug("销毁1");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("销毁2");
    }

    private void destroy3() {
        log.debug("销毁3");
    }
}
