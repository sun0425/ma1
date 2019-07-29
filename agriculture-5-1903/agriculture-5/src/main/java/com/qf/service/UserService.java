package com.qf.service;

import com.qf.domain.Admin;
import com.qf.domain.AgricultureUser;

import java.util.List;

/**
 * Created by lucifer on 2019.7.19.0019.
 */
public interface UserService {

    //查询所有用户
    public List<AgricultureUser> loadAllUser(int page, int rows);

    public int  countRows(int rows);
    public AgricultureUser loadUserById(Integer userId);
    public int updateUser(AgricultureUser user);
    public int deleteUser(Integer userId);

    public int deleteBatch(List<Integer> uidList);

    public int addUser(AgricultureUser user);

}
