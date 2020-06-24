package com.rainbowdemo.service.basic.systemmana.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc 样例Demo
 * @Author wuzh
 * @Date 2020/5/15
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class DemoWebController {

    // 最简单的web服务器测试。前端访问接口，返回字符串。
    @PostMapping("/hi")
    public String HelloBoot() {
        System.out.println("come in!");
        log.info("--------------");
        return "Hi!";
    }
}
