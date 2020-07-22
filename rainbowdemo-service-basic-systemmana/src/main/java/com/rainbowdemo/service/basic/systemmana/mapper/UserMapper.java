package com.rainbowdemo.service.basic.systemmana.mapper;

import com.github.pagehelper.Page;
import com.rainbowdemo.service.basic.systemmana.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc
 * @Author zh wu
 * @Date 2020/6/28
 */
public interface UserMapper extends Mapper<User> {
    String selectUserNameByUserId(Long userId);

    Page<User> pageAll();
}
