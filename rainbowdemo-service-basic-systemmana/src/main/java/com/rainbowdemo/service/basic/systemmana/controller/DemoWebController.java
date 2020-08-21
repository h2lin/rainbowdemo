package com.rainbowdemo.service.basic.systemmana.controller;

import com.github.pagehelper.Page;
import com.rainbow.common.pojo.dto.Req;
import com.rainbow.common.pojo.dto.ReqPageBody;
import com.rainbow.common.pojo.dto.Resp;
import com.rainbow.common.pojo.dto.RespPageBody;
import com.rainbowdemo.common.framework.util.RespUtil;
import com.rainbowdemo.service.basic.systemmana.model.User;
import com.rainbowdemo.service.basic.systemmana.service.DemoWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    // [集成Mybatis]测试。使用mybatis访问DB数据。
    @PostMapping("/user_id/select/user_name")
    public String selectUserNameByUserId(@RequestBody Req<Long> req) {
        System.out.println(req.getBody());
        return demoWebService.selectUserNameByUserId(req);
    }

    // [集成tkMybatis]测试。使用mybatis访问DB数据。
    @PostMapping("/user_id/select/one")
    public User selectOneUserByUserId(@RequestBody Req<Long> req) {
        System.out.println(req.getBody());
        return demoWebService.selectOneUserByUserId(req);
    }

    // [集成多数据源+自定义配置+自动配置]测试。使用mybatis同时访问两个数据源的数据。
    // 注意数据源之间的事务操作问题
    @PostMapping("/user_name/select/multi-datasource")
    public List<User> selectMultiDatasource(@RequestBody Req<String> req) {
        System.out.println(req.getBody());
        return demoWebService.selectMultiDatasource(req);
    }

    // [集成PageHelper]测试 + [集成自定义日志插件]测试
    @PostMapping("/page/user")
    public Resp<RespPageBody<User>> pageUser() {
        return RespUtil.success(RespUtil.tranPageData(demoWebService.pageUser()));
    }

    // [集成Mybatis + 事务]测试
    @PostMapping("/transaction/user")
    public void transactionUser() {
        demoWebService.transactionUser();
    }
}
