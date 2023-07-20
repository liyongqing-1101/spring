package com.bitflow.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        Object ans = context.getBean("test");
        System.out.println("ans = " + ans);


    }

}
