package com.rainbowdemo.service.basic.systemmana.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Desc
 * @Author wuzh
 * @Date 2020/6/29
 */
@Getter
@Setter
@Table(name = "t_syst_user")  // 用于tkMybatis
public class User {
//    @Column(name = "user_id")
    @Id
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
