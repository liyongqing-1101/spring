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
            public Object intercept(Object p, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
//                return method.invoke(target, args);  普通的反射
//                return methodProxy.invoke(target, args); // 内部无反射，结合目标用
                return methodProxy.invokeSuper(p, args); // 内部无反射，结合代理用
            }
        });

        proxy.save();
        proxy.save(1);
        proxy.save(2L);
    }
}
