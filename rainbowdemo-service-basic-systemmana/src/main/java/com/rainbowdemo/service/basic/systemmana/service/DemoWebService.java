package com.rainbowdemo.service.basic.systemmana.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rainbow.common.pojo.dto.Req;
import com.rainbowdemo.service.basic.systemmana.mapper.UserMapper;
import com.rainbowdemo.service.basic.systemmana.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Assert;
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

    @Transactional
    public void transactionUser() {
        long userId = 10001L;

        // 1.原始值

        User beforeUser = userMapper.selectByPrimaryKey(userId);
        log.info("======= before: {}",JSON.toJSONString(beforeUser));


        // 2.更新参数
        User updateUser = new User();
        String updateRemark = RandomUtils.nextInt()+"";
        updateUser.setUserId(userId);
        updateUser.setRemark(updateRemark);
        try{
            this.updateUserTransactionTest(updateUser);
        } catch (Throwable e) {
            // 如要做异常处理，则需要再次手动抛出异常。或手动进行回滚，如下。
            log.info("======= 异常已被catch");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        // 3.更新后
        User afterUser = userMapper.selectByPrimaryKey(userId);
        log.info("======= after: {}",JSON.toJSONString(afterUser));
        // Assert.isTrue(updateRemark.equals(afterUser.getRemark()), "error");
    }


    private void updateUserTransactionTest(User updateUser) {
        log.info("======= update");
        userMapper.updateByPrimaryKeySelective(updateUser);

        throw new RuntimeException("随机错误抛出！");

        // 随机错误
//        if (RandomUtils.nextInt() % 2 == 0) {
//            try {
//                User afterUser = userMapper.selectByPrimaryKey(updateUser.getUserId());
//            } finally {
//
//                log.info("=== 更新失败");
//            }
//        }
    }
}
