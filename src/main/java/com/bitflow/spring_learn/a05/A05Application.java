package com.bitflow.spring_learn.a05;

import javafx.util.Builder;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

/**
 * A05Application class
 *
 * @author liyongqing
 * @date 2023/8/23
 */

public class A05Application {

    public static void main(String[] args) throws IOException {

        //  GenericApplication 是一个【干净】的容器，没有添加 后处理器
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("config", Config.class);
        // 加上这个beanFactory后处理器，@ComponentScan @Import @ImportResource @Configuration @Bean ... 都能解析了
//        context.registerBean(ConfigurationClassPostProcessor.class);
//        context.registerBean(MapperScannerConfigurer.class, bd -> {
//            bd.getPropertyValues().add("basePackage", "com.bitflow.spring_learn.a05.mapper");
//        }); // SSM整合 @MapperScanner

//        context.registerBean(ComponentScanPostProcessor.class);

//        context.registerBean(AtBeanPostProcessor.class);

        context.registerBean(MapperPostProcessor.class);
        // 初始化容器
        context.refresh();

        System.out.println("-------------------------");
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println("-------------------------");

        // 销毁容器
        context.close();
    }


}
