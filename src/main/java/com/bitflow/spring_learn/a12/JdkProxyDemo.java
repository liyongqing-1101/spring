package com.bitflow.spring_learn.a12;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JdkProxyDemo class
 *
 * @author liyongqing
 * @date 2023/8/25
 */

public class JdkProxyDemo {

    interface Foo {
        void foo();
    }

    static class Target implements Foo { // 也可以为final类
        @Override
        public void foo() {
            System.out.println("target foo");
        }
    }

    // jdk  只能针对接口代理
    // cdlib
    public static void main(String[] args) {
        // 目标对象
        Target target = new Target();

        // 用来接在在运行期间动态生成的字节码
        ClassLoader loader = JdkProxyDemo.class.getClassLoader();
        // Proxy.newProxyInstance() 生成代理对象，代理类也实现了 Foo 接口，所以可以强转
        Foo proxy = (Foo) Proxy.newProxyInstance(loader, new Class[]{Foo.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                Object result = method.invoke(target, args);
                System.out.println("after...");
                return result; // 让代理也返回目标方法执行的结果
            }
        });

        // 调用方法，会执行invoke方法
        proxy.foo();
    }

}
