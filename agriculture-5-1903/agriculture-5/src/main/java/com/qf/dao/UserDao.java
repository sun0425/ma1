package com.qf.dao;

import com.qf.domain.AgricultureUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by lucifer on 2019.7.19.0019.
 */
@Mapper
public interface UserDao {

    //查询所有用户
    public List<AgricultureUser> loadAllUser();

    public int  countRows();
    public AgricultureUser loadUserById(Integer userId);
    public int updateUser(AgricultureUser user);
    public int deleteUser(Integer userId);
    public int deleteBatch(List<Integer> list);
    public int  addUser(AgricultureUser user);

}
