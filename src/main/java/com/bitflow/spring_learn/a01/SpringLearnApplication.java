package com.bitflow.spring_learn.a01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

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


        /*
          4. 学到了什么
            a. BeanFactory 与 ApplicationContext 并不仅仅是简单的继承关系，ApplicationContext 组合并扩展了 BeanFactory接口
            b. 又学到了一种代码之间的解耦方式
            练习：完成用户注册与发送短信之间的解耦，用事件方式和 AOP 两个方式分别实现
         */
    }

}
