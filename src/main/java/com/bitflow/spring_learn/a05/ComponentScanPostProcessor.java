package com.bitflow.spring_learn.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * ComponentScanPostProcessor class
 *
 * @author liyongqing
 * @date 2023/8/23
 */

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {

    @Override  // context.refresh()
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        try {
            ComponentScan componentScan = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);

            if (componentScan != null) {
                for (String p : componentScan.basePackages()) {
                    System.out.println(p);
                    // com.bitflow.spring_learn.a05.component -> classpath*:com/bitflow/spring_learn/a05/component/**/*.class
                    String path = "classpath*:" + p.replace(".", "/") + "/**/*.class";
                    System.out.println(path);
                    CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
                    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
                    AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
                    for (Resource resource : resources) {
                        // System.out.println(resource);
                        MetadataReader reader = factory.getMetadataReader(resource);
                        AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
                        // System.out.println("类名：" + reader.getClassMetadata().getClassName());
                        // 是否直接或间接加了 @Component
                        // System.out.println("是否加了 @Component 派生：" + reader.getAnnotationMetadata().hasMetaAnnotation(Component.class.getName()));

                        if (annotationMetadata.hasAnnotation(Component.class.getName())
                                || annotationMetadata.hasMetaAnnotation(Component.class.getName())) {
                            AbstractBeanDefinition bd = BeanDefinitionBuilder
                                    .genericBeanDefinition(reader.getClassMetadata().getClassName())
                                    .getBeanDefinition();
                            if (configurableListableBeanFactory instanceof DefaultListableBeanFactory) {
                                DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
                                String name = generator.generateBeanName(bd, beanFactory);
                                beanFactory.registerBeanDefinition(name, bd);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
