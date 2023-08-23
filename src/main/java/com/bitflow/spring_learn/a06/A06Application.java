package com.bitflow.spring_learn.a06;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

/**
 * A06Application class
 *
 * @author liyongqing
 * @date 2023/8/23
 */

public class A06Application {

    public static void main(String[] args) {

        GenericApplicationContext context = new GenericApplicationContext();
//        context.registerBean("myBean", MyBean.class);
        context.registerBean("myConfig1", MyConfig1.class);
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        context.registerBean(ConfigurationClassPostProcessor.class);

        context.refresh(); // 1. beanFactory 后处理器 2. 添加 bean 后处理器 3 初始化单例
        context.close();
    }

}
