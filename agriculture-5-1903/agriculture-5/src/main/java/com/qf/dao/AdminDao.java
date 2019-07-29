package com.qf.dao;

import com.qf.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by lucifer on 2019.7.25.0025.
 */
@Mapper
public interface AdminDao {
    //登录
     Admin loginByUserNameAndPassword(Admin admin);
     int update(Admin admin);
     Admin loadById(Integer id);
     int add(Admin admin);
}
