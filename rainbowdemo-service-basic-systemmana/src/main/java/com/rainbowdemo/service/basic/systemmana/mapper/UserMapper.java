package com.rainbowdemo.service.basic.systemmana.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Desc
 * @Author zh wu
 * @Date 2020/6/28
 */
public interface UserMapper {
    String selectUserNameByUserId(Long userId);
}
