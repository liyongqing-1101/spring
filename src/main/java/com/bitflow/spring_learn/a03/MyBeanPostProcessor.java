package com.bitflow.spring_learn.a03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * MyBeanPostProcessor class
 *
 * @author liyongqing
 * @date 2023/8/19
 */

/**
 * 总体来说，包括四个阶段：
 *  1 实例化  （之前，之后）
 *  2 依赖注入 （当前）
 *  3 初始化  （之前，之后）
 *  4 销毁   （之前）
 *
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.debug("<<<<<< 销毁之前执行，如 @PreDestroy");
        }
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beaClass, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.debug("<<<<<< 实例化之前执行，这里返回的对象会替换掉原本的 bean");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.debug("<<<<<< 实例化之后执行，如果这里返回 false 会跳过依赖注入阶段");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.debug("<<<<<< 依赖注入阶段执行，如 @Autowired、@Value、@Resource");
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.debug("<<<<<< 初始化之前执行，这里返回的对象会替换掉原本的 bean，如@PostConstruct、@ConfigurationProperties");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleBean".equals(beanName)) {
            log.debug("<<<<<< 初始化之后执行，这里返回的对象会替换掉原本的 bean，如代理增强");
        }
        return bean;
    }
}
