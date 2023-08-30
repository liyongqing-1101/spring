package com.bitflow.spring_learn.a12;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxyDemo class
 *
 * @author liyongqing
 * @date 2023/8/25
 */

public class CglibProxyDemo {

    static class Target {
        public void foo() {
            System.out.println("target foo");
        }
    }

    public static void main(String[] args) {
        Target target = new Target();

        // 代理对象其实是子类型，可以转化为父类型
        Target proxy = (Target) Enhancer.create(Target.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object p, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                // Object result = method.invoke(target, args); // 用反射调用目标方法
                // methodProxy 可以避免用反射调用
                Object result = methodProxy.invoke(target, args); // 内部没有用反射，需要目标对象
                methodProxy.invokeSuper(p, args); // 内部也没有反射，需要代理对象
                System.out.println("after...");
                return result;
            }
        });

        proxy.foo();


    }

}
