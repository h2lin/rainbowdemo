package com.rainbowdemo.service.basic.systemmana.mapperbk;

import com.rainbowdemo.service.basic.systemmana.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc
 * @Author wuzh
 * @Date 2020/7/3
 */
public interface UserMapper extends Mapper<User> {
    String selectUserNameByUserId(Long userId);
}
