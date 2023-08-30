package com.bitflow.spring_learn.a09;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * A09Application class
 *
 * @author liyongqing
 * @date 2023/8/24
 */
@Slf4j
@ComponentScan("com.bitflow.spring_learn.a09")
public class A09Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(A09Application.class);

        E e = context.getBean(E.class);
        log.debug("{}", e.getF1());
        log.debug("{}", e.getF1());
        System.out.println("----------------");
        log.debug("{}", e.getF2());
        log.debug("{}", e.getF2());
        System.out.println("----------------");
        log.debug("{}", e.getF3());
        log.debug("{}", e.getF3());
        System.out.println("----------------");
        log.debug("{}", e.getF4());
        log.debug("{}", e.getF4());

        context.close();
    }

}
