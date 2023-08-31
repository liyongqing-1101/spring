package com.bitflow.spring_learn.a15;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * A15 class
 *
 * @author liyongqing
 * @date 2023/8/31
 */

public class A15 {

    @Aspect
    static class MyAspect {

        @Before("execution(* foo())")
        public void before() {
            System.out.println("前置增强");
        }

        @Before("execution(* foo())")
        public void after() {
            System.out.println("后置增强");
        }
    }

    public static void main(String[] args) {

        // 1.备好切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())");
        // 2.备好通知
        MethodInterceptor advice = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("before");
                Object result = invocation.proceed(); // 调用目标
                System.out.println("after");
                return result;
            }
        };
        // 3.备好切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        // 4.创建代理
        Target1 target = new Target1();

        Target2 target2 = new Target2();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target2);
        factory.addAdvisor(advisor);
        factory.setInterfaces(target2.getClass().getInterfaces());
//        factory.setProxyTargetClass(true);
        Target2 proxy = (Target2) factory.getProxy();
        System.out.println(proxy.getClass());
        proxy.foo();
        proxy.bar();

    }

    interface I1 {
        void foo();
        void bar();
    }

    static class Target1 implements I1 {
        @Override
        public void foo() {
            System.out.println("target1 foo");
        }
        @Override
        public void bar() {
            System.out.println("target1 bar");
        }
    }

    static class Target2 {
        public void foo() {
            System.out.println("target2 foo");
        }
        public void bar() {
            System.out.println("target2 bar");
        }
    }
}
