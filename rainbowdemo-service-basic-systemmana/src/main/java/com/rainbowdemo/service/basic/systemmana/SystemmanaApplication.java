package com.rainbowdemo.service.basic.systemmana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Desc
 * @Author wuzh
 * @Date 2020/5/15
 */
@SpringBootApplication
@MapperScan(basePackages = "com.rainbowdemo.service.basic.systemmana.mapper")
public class SystemmanaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemmanaApplication.class);
    }
}
