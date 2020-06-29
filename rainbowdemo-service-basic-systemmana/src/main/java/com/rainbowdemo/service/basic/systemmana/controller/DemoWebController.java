package com.rainbowdemo.service.basic.systemmana.controller;

import com.rainbow.common.pojo.dto.Req;
import com.rainbowdemo.service.basic.systemmana.service.DemoWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Desc 样例Demo。
 * 适用于网页端的Controller，加WebController后缀。
 * 适用于App端的Controller，加ApiController后缀。
 * 适用于微服务的Controller，加RpcController后缀。
 * @Author wuzh
 * @Date 2020/5/15
 */
@RestController
@RequestMapping("/web/auth/syst")
@Slf4j
public class DemoWebController {
    @Resource
    private DemoWebService demoWebService;

    // [最简单的web服务器]测试。前端访问接口，返回字符串。
    //@PostMapping("/hi")
    @GetMapping("/hi")
    public String HiBoot() {
        System.out.println("come in!");
        log.info("--------------");
        return "Hi!";
    }

    @PostMapping("/user_id/select/user_name")
    public String selectUserNameByUserId(@RequestBody Req<Long> req) {
        System.out.println(req.getBody());
        return demoWebService.selectUserNameByUserId(req);
    }
}
