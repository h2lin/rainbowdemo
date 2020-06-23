package com.rainbowdemo.service.basic.systemmana.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc 样例Demo
 * @Author wuzh
 * @Date 2020/5/15
 */
@RestController
@RequestMapping("/hello")
public class DemoWebController {
    @RequestMapping("/hi")
    public String HelloBoot() {
        System.out.println("come in!");
        return "Hi!";
    }
}
