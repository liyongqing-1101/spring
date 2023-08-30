package com.bitflow.spring_learn.a13;

import java.lang.reflect.Method;

/**
 * A13 class
 *
 * @author liyongqing
 * @date 2023/8/25
 */

public class A13 {

    interface Foo {
        void foo();
        int bar();
    }

    static class Target implements Foo {
        @Override
        public void foo() {
            System.out.println("target foo()");
        }

        @Override
        public int bar() {
            System.out.println("target bar()");
            return 100;
        }
    }

    interface InvocationHandler {
        Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
    }

    public static void main(String[] args) {
        Foo proxy = new $Proxy0(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 1 功能增强
                System.out.println("before...");
                // 2 调用目标
                return method.invoke(new Target(), args);
            }
        });

        proxy.foo();
        proxy.bar();
    }

}
