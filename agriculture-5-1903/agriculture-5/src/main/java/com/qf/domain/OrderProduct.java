package com.qf.domain;


import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by lucifer on 2019.7.26.0026.
 */
@Data
public class OrderProduct {
    private Integer id;
    private String oid;
    private Integer pid;
    private  Integer number;
    private String monicker;
    private String photo;
    private BigDecimal price;


}
