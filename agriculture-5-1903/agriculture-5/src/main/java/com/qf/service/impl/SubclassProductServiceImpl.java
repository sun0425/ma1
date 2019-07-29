package com.qf.service.impl;

import com.qf.dao.SubclassProductDao;
import com.qf.service.SubclassProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lucifer on 2019.7.25.0025.
 */
@Service
public class SubclassProductServiceImpl implements SubclassProductService {

@Autowired
    public SubclassProductDao subclassProductDao;


    @Override
    public int deletesp(Integer id) {
        return subclassProductDao.deletesp(id);
    }

    @Override
    public int deleteop(Integer id) {
        return subclassProductDao.deleteop(id);
    }

    @Override
    public int deletepp(Integer id) {
        return subclassProductDao.deletepp(id);
    }

    @Override
    public int deletesup(Integer id) {
        return subclassProductDao.deletesup(id);
    }

    @Override
    public int deletesop(Integer id) {
        return subclassProductDao.deletesop(id);
    }
}
