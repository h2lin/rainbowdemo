package com.rainbowdemo.service.basic.systemmana.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;

/**
 * @Desc
 * @Author wuzh
 * @Date 2020/8/25
 */
//
//
//

/*
 * @SpringBootTest 替代了spring-test中的@ContextConfiguration注解，目的是加载ApplicationContext，启动spring容器。
 *
 * @ContextConfiguration({"classes=Congfig.clsss",classpath:applicationContext.xml"})
 * 这里可以用classes来直接导入同包下写的配置类。或者导入配置文件。
 *
 * 使用@SpringBootTest时并没有像@ContextConfiguration一样显示指定locations或classes属性，
 * 原因在于@SpringBootTest注解会自动检索程序的配置文件，检索顺序是从当前包开始，逐级向上查找
 * 被@SpringBootApplication或@SpringBootConfiguration注解的类。
 */
@SpringBootTest
/*
 * @RunWith：用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，为了便于使用spring的依赖注入，
 * spring提供了org.springframework.test.context.junit4.SpringJUnit 4ClassRunner作为Junit测试环境。
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoWebControllerTest {
    @Autowired
    DemoWebController demoWebController;

    @Test
    // 直接使用Bean测试。不过一般推荐用HttpClient模拟Http请求进行测试。
    public void testHiBoot(){
        String check = "Hi!";
        String result = demoWebController.HiBoot();
        Assert.assertEquals(check, result);
        InvocationHandler a;
    }
}
