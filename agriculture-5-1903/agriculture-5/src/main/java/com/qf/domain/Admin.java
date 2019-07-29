package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by lucifer on 2019.7.20.0020.
 */
@ApiModel("管理员对象")
@Data

public class Admin implements Serializable {

    private Integer id;
    private String userName;
    private String password;
    private BigDecimal money;
}
