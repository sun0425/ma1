package com.qf.service;

import com.qf.domain.Admin;

/**
 * Created by lucifer on 2019.7.25.0025.
 */
public interface AdminService {

    Admin loginByUserNameAndPassword(Admin admin);
    boolean update(Admin admin);
    Admin loadById(Integer id);
    int add(Admin admin);
}
