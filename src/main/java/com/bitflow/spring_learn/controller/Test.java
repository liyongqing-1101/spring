package com.bitflow.spring_learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Test class
 *
 * @author liyongqing
 * @date 2023/7/20
 */
@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/web")
    public String web() {
        System.out.println("这是一个web项目！");
        return "test使用！";
    }

}
