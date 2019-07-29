package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
@ApiModel("管理员对象")
@Data

public class ProductPicture {
    private Integer proId;
    private Integer picId;
}
