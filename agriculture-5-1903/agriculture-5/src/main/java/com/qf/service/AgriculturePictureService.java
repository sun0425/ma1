package com.qf.service;

import com.qf.domain.AgriculturePicture;

import java.util.List;
import java.util.Map;

/**
 * Created by lucifer on 2019.7.24.0024.
 */
public interface AgriculturePictureService {
    int update(AgriculturePicture agriculturePicture);
    int add(AgriculturePicture agriculturePicture);
    int deletepp(Integer pictureId);
    int deleteap(Integer pictureId);
    AgriculturePicture loadById(Integer pictureId);
    List<AgriculturePicture> loadAll(int page, int rows);
    int  countRows(int rows);
    int deleteBatch(List<Integer> uidList);
    int addpp(Map<String,Integer> map);
}
