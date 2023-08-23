package com.bitflow.spring_learn.a05.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Bean2 class
 *
 * @author liyongqing
 * @date 2023/8/23
 */
@Slf4j
@Controller
public class Bean3 {

    public Bean3() {
        log.debug("我被 Spring 管理了！");
    }

}
