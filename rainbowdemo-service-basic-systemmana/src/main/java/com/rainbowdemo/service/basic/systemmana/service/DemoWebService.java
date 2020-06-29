package com.rainbowdemo.service.basic.systemmana.service;

import com.rainbow.common.pojo.dto.Req;
import com.rainbowdemo.service.basic.systemmana.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Desc 样例Demo。
 * 适用于网页端的Service，加WebService后缀。
 * 适用于App端的Service，加ApiService后缀。
 * 适用于微服务的Service，加RpcService后缀。
 * @Author wuzh
 * @Date 2020/6/28
 */
@Service
public class DemoWebService {
    @Resource
    private UserMapper userMapper;

    public String selectUserNameByUserId(Req<Long> req) {
        return userMapper.selectUserNameByUserId(req.getBody());
    }
}
