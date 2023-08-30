package com.bitflow.spring_learn.a10;

import com.bitflow.spring_learn.a10.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * A10Application class
 *
 * @author liyongqing
 * @date 2023/8/25
 */
@Slf4j
@SpringBootApplication
public class A10Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A10Application.class);
        MyService service = context.getBean(MyService.class);

        log.debug("service class: {}", service.getClass());
        service.foo();

        context.close();
    }

}
