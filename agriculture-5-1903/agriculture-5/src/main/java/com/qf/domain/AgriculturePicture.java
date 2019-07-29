package com.qf.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
@Data
public class AgriculturePicture implements Serializable {
    private Integer pictureId;
    private String pictureUrl;
}
