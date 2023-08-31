package com.bitflow.spring_learn.a16;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * A16 class
 *
 * @author liyongqing
 * @date 2023/8/31
 */

public class A16 {

    public static void main(String[] args) throws NoSuchMethodException {
//        AspectJExpressionPointcut pointcut1 = new AspectJExpressionPointcut();
//        pointcut1.setExpression("execution(* bar())");
//        boolean fooMatch = pointcut1.matches(T1.class.getMethod("foo"), T1.class);
//        boolean barMatch = pointcut1.matches(T1.class.getMethod("bar"), T1.class);
//        System.out.println("fooMatch = " + fooMatch);
//        System.out.println("barMatch = " + barMatch);

//        AspectJExpressionPointcut pointcut2 = new AspectJExpressionPointcut();
//        pointcut2.setExpression("@annotation(org.springframework.transaction.annotation.Transactional)");
//        System.out.println(pointcut2.matches(T1.class.getMethod("foo"), T1.class));
//        System.out.println(pointcut2.matches(T1.class.getMethod("bar"), T1.class));

        StaticMethodMatcherPointcut pointcut3 = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                MergedAnnotations annotations = MergedAnnotations.from(method);
                // 检查方法上是否加上Transactional注解
                if (annotations.isPresent(Transactional.class)) {
                    return true;
                }
                // 检查类上是否加上了Transactional注解
                annotations = MergedAnnotations.from(targetClass, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY); // 搜索策略
                if (annotations.isPresent(Transactional.class)) {
                    return true;
                }
                return false;
            }
        };
        System.out.println(pointcut3.matches(T1.class.getMethod("bar"), T1.class));
        System.out.println(pointcut3.matches(T1.class.getMethod("foo"), T1.class));
        System.out.println(pointcut3.matches(T2.class.getMethod("foo"), T2.class));
        System.out.println(pointcut3.matches(T3.class.getMethod("foo"), T3.class));

    }

    // 事务的传播行为 事务的隔离级别
    static class T1 {
        @Transactional
        public void foo() {

        }

        public void bar() {}
    }

    @Transactional
    static class T2 {
        public void foo(){}
    }

    @Transactional
    interface I3 {
        void foo();
    }
    static class T3 implements I3 {
        public void foo(){}
    }


}
