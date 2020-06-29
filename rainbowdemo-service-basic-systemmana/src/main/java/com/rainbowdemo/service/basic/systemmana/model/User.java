package com.rainbowdemo.service.basic.systemmana.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Desc
 * @Author wuzh
 * @Date 2020/6/29
 */
@Data
@Table(name = "t_syst_user")  // 用于tkMybatis
public class User {
//    @Id
//    @Column(name = "user_id")
    private Long userId;

//    @Column(name = "user_name")
    private String userName;

//    @Column(name = "nick_name")
    private String nickName;

//    @Column(name = "password")
    private String password;

//    @Column(name = "create_user")
    private Long createUser;

//    @Column(name = "update_user")
    private Long updateUser;

//    @Column(name = "remark")
    private String remark;

//    @Column(name = "delete_flag")
    private Byte deleteFlag;
}
