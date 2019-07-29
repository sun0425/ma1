package com.qf.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("用户对象")
@Data
@Entity
@Table(name = "agriculture_user")
public class AgricultureUser1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;//用户编号
    @Column(name = "user_name")
    private String userName;//用户名称
    @Column(name = "user_sex")
    private String userSex;//用户性别
    @Column(name = "user_password")
    private String userPassword;//用户密码
    @Column(name = "user_email")
    private String userEmail;//用户邮箱
    @Column(name = "user_money")
    private BigDecimal userMoney;//用户余额
    @Column(name = "user_picture")
    private String userPicture;//头像路径
}
