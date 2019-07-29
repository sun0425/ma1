package com.qf.domain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("用户对象")
@Data
public class AgricultureUser implements Serializable {


    private Integer userId;//用户编号

    private String userName;//用户名称

    private String userSex;//用户性别

    private String userPassword;//用户密码

    private String userEmail;//用户邮箱

    private BigDecimal userMoney;//用户余额

    private String userPicture;//头像路径

    private String userPayPassword;//支付密码


}
