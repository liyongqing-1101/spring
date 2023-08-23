package com.bitflow.spring_learn.a06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * MyConfig1 class
 *
 * @author liyongqing
 * @date 2023/8/23
 */
@Slf4j
@Configuration
public class MyConfig1 {

    ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
        log.debug("注入 ApplicationContext");
    }

    @PostConstruct
    public void init() {
        log.debug("初始化 ");
    }

    @Bean // beanfactory 后处理器
    public BeanFactoryPostProcessor processor1() {
        return new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                log.debug("执行 processor1");
            }
        };
    }
}
