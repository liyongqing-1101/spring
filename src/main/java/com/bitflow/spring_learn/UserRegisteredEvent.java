package com.bitflow.spring_learn;

import org.springframework.context.ApplicationEvent;

/**
 * UserRegisteredEvent class
 *
 * @author liyongqing
 * @date 2023/8/9
 */

public class UserRegisteredEvent extends ApplicationEvent {
    public UserRegisteredEvent(Object source) { // 事件源
        super(source);
    }
}
