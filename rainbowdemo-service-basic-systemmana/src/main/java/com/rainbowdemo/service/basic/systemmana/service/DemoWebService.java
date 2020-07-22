package com.rainbowdemo.service.basic.systemmana.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainbow.common.pojo.dto.Req;
import com.rainbowdemo.service.basic.systemmana.mapper.UserMapper;
import com.rainbowdemo.service.basic.systemmana.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 样例Demo。
 * 适用于网页端的Service，加WebService后缀。
 * 适用于App端的Service，加ApiService后缀。
 * 适用于微服务的Service，加RpcService后缀。
 * @Author wuzh
 * @Date 2020/6/28
 */
@Service
@Slf4j
public class DemoWebService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private com.rainbowdemo.service.basic.systemmana.mapperbk.UserMapper userMapperBk;

    public String selectUserNameByUserId(Req<Long> req) {
        return userMapper.selectUserNameByUserId(req.getBody());
    }

    public User selectOneUserByUserId(Req<Long> req) {
        User user = new User();
        user.setUserId(req.getBody());

        return userMapper.selectOne(user);
    }

    public List<User> selectMultiDatasource(Req<String> req) {
        User user = new User();
        user.setUserName(req.getBody());

        // 同一个入参，到两个数据源查询，最后汇总结果返回
        List<User> list = new ArrayList<>();
        list.add(userMapper.selectOne(user));
        list.add(userMapperBk.selectOne(user));

        return list;
    }

    public Page<User> pageUser() {
        PageHelper.startPage(2,2);
        Page<User> page = userMapper.pageAll();

        log.info("Datas: "+JSON.toJSONString(page.getResult()));
        log.info("PageCount: "+page.getPages()+"");
        log.info("PageIndex: " +page.getPageNum()+"");
        log.info("PageSize: "+page.getPageSize()+"");
        log.info("TotalCount: "+page.getTotal()+"");

        return page;
    }
}
