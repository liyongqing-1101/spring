package com.bitflow.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.awt.*;
import java.io.IOException;
import java.util.Locale;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        Object ans = context.getBean("test");
        System.out.println("ans = " + ans);

        /*
          3. ApplicationContext 比 BeanFactory多了啥？ MessageSource() 接口
         */
//        System.out.println(context.getMessage("hi", null, Locale.CHINA));
//        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
//        System.out.println(context.getMessage("hi", null, Locale.JAPAN));

        Resource[] resources0 = context.getResources("classpath:application.yml");
        // 在 jar 包下去找
        Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
        for (Resource resource : resources) {
            System.out.println(resource);
        }

        System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("server.port"));

        // context.publishEvent(new UserRegisteredEvent(context));
        context.getBean(Component1.class).register();


    }

}
