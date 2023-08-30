package com.bitflow.spring_learn.a14;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * A14 class
 *
 * @author liyongqing
 * @date 2023/8/26
 */

public class A14 {

    public static void main(String[] args) {

        Proxy proxy = new Proxy();
        Target target = new Target();
        proxy.setMethodInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                return method.invoke(target, args);
            }
        });

        proxy.save();
        proxy.save(1);
        proxy.save(2L);
    }
}
