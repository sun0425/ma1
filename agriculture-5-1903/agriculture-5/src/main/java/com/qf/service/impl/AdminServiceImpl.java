package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.domain.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lucifer on 2019.7.25.0025.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin loginByUserNameAndPassword(Admin admin) {
        return adminDao.loginByUserNameAndPassword(admin);
    }

    @Override
    public boolean update(Admin admin) {

        return  adminDao.update(admin)==1?true:false;

    }

    @Override
    public Admin loadById(Integer id) {
        return adminDao.loadById(id);
    }

    @Override
    public int add(Admin admin) {
        return adminDao.add(admin);
    }
}
