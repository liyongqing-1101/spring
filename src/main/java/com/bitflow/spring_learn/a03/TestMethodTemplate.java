package com.bitflow.spring_learn.a03;

/**
 * TestMethodTemplate class
 *
 * @author liyongqing
 * @date 2023/8/21
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 模板方法设计模式
 */
public class TestMethodTemplate {

    public static void main(String[] args) {
        MyBeanFactory beanFactory = new MyBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                                             @Override
                                             public void inject(Object bean) {
                                                 System.out.println("解析 @Autowired");
                                             }
                                         }
        );
        beanFactory.getBean();
    }

    // 模板方法， Template Method Pattern
    static class MyBeanFactory {
        public Object getBean() {
            Object bean = new Object();
            System.out.println("构造 " + bean);
            System.out.println("依赖注入 " + bean);
            for (BeanPostProcessor processor : processors) {
                processor.inject(bean);
            }
            System.out.println("初始化 " + bean);
            return bean;
        }
        private List<BeanPostProcessor> processors = new ArrayList<>();

        public void addBeanPostProcessor(BeanPostProcessor processor) {
            processors.add(processor);
        }
    }

    static interface BeanPostProcessor {
        public void inject(Object bean); // 对依赖注入阶段的扩展
    }
}
