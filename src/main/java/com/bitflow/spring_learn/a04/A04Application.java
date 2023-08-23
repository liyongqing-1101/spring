package com.bitflow.spring_learn.a04;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * A04Application class
 *
 * @author liyongqing
 * @date 2023/8/21
 */

public class A04Application {

    public static void main(String[] args) {

        // GenericApplicationContext 是一个【干净】的容器，没有加一些后处理器
        GenericApplicationContext context = new GenericApplicationContext();

        // 用原始的方法注册三个 Bean
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        context.registerBean("bean4", Bean4.class);

        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver()); // 这个非常复杂，后续还会讲解
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class); // 处理 @Autowired @Value

        context.registerBean(CommonAnnotationBeanPostProcessor.class); // 这个后处理器会处理 @Resource @PostConstruct @PreDestroy

        ConfigurationPropertiesBindingPostProcessor.register(context.getDefaultListableBeanFactory()); // 解析 @ConfigurationProperties

        // 初始化容器
        context.refresh(); // 执行 beanFactory 后处理器，添加 bean 后处理器，初始化所有的单例

        System.out.println(context.getBean("bean4"));
        // 销毁容器
        context.close();

    }

}
