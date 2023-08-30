package com.bitflow.spring_learn.a09;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * F1 class
 *
 * @author liyongqing
 * @date 2023/8/24
 */
@Scope(value = "prototype")
@Component
public class F1 {
}
