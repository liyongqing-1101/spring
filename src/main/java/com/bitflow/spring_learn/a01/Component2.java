package com.bitflow.spring_learn.a01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Component2 class
 *
 * @author liyongqing
 * @date 2023/8/9
 */

// 任何一个组件都可以作为监听器
@Slf4j
@Component
public class Component2 {

    @EventListener
    public void aaa(UserRegisteredEvent event) {
        log.debug("{}", event);
        log.debug("发送短信");
    }

}
