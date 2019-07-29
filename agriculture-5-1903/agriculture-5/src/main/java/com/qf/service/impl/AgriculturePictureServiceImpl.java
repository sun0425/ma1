package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.dao.AgriculturePictureDao;
import com.qf.domain.AgriculturePicture;
import com.qf.service.AgriculturePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
@Service
public class AgriculturePictureServiceImpl implements AgriculturePictureService {

    @Autowired
    private AgriculturePictureDao agriculturePictureDao;

    @Override
    public int update(AgriculturePicture agriculturePicture) {
        int i=agriculturePictureDao.update(agriculturePicture);

        return i>0?1:0;
    }

    @Override
    public int add(AgriculturePicture agriculturePicture) {
        int i=agriculturePictureDao.add(agriculturePicture);
        return i>0?1:0;
    }

    @Override
    public int deletepp(Integer pictureId) {
        return agriculturePictureDao.deletepp(pictureId);
    }

    @Override
    public int deleteap(Integer pictureId) {
        return agriculturePictureDao.deleteap(pictureId);
    }


    @Override
    public AgriculturePicture loadById(Integer pictureId) {
        AgriculturePicture agriculturePicture = agriculturePictureDao.loadById(pictureId);
        return agriculturePicture;
    }

    @Override
    public List<AgriculturePicture> loadAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        return agriculturePictureDao.loadAll();
    }

    @Override
    public int countRows(int rows) {
        int i = agriculturePictureDao.countRows();
        return i%rows>0?i/rows+1:i/rows;
    }

    @Override
    public int deleteBatch(List<Integer> uidList) {

        return agriculturePictureDao.deleteBatch(uidList);
    }

    @Override
    public int addpp(Map<String,Integer> map) {
        return agriculturePictureDao.addpp(map);
    }
}
